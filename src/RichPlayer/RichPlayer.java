package RichPlayer;

import RichGift.RichGift;
import RichHouse.RichHouse;
import RichHouse.RichHousePlatLevel;
import RichMap.RichSitePosition;
import RichTool.RichTool;
import RichTool.ToolOverflowException;
import RichTool.ToolUnderflowException;
import RichTool.ToolPointsNotEnoughException;

import RichHouse.HouseMoneyNotEnoughException;
import RichHouse.HouseOwnerException;

import java.util.ArrayList;

public class RichPlayer {
    private int _points;
    private int _money;

    private ArrayList<RichTool> _tools;
    private final int TOOL_NUMBER_LIMIT = 10;
    private final int DEFAULT_INIT_MONEY_COUNT = 10000;
    private final int DEFAULT_INIT_POINTS_COUNT = 0;
    private ArrayList<RichHouse> _houses;
    private RichSitePosition _position;
    private int _remainStep;
    private int _punishDays;

    public RichPlayer() {
        _tools = new ArrayList<RichTool>();
        _houses = new ArrayList<RichHouse>();
        _money = DEFAULT_INIT_MONEY_COUNT;
        _points = DEFAULT_INIT_POINTS_COUNT;
        _position = null;//TODO
    }

    public int getToolsNumber() {
        return _tools.size();
    }

    public void addTool(RichTool tool) {
        if (getToolsNumber() >= TOOL_NUMBER_LIMIT) throw new ToolOverflowException();
        _tools.add(tool);
    }

    public void removeTool(RichTool toolToRemove) {
        for (RichTool tool : _tools) {
            if (tool.equals(toolToRemove)) {
                _tools.remove(tool);
                return;
            }
        }

        throw new ToolUnderflowException(toolToRemove);
    }

    public void setPoints(int points) {
        this._points = points;
    }

    public int getPoints() {
        return _points;
    }

    public void setMoney(int money) {
        _money = money;
    }

    public int getMoney() {
        return _money;
    }

    public void buyTool(RichTool tool) {
        if (getPoints() < tool.getPoints()) throw new ToolPointsNotEnoughException(_points, tool);
        addTool(tool);
        _points -= tool.getPoints();
    }


    public void sellTool(RichTool toolToSell) {
        removeTool(toolToSell);
        _points += toolToSell.getPoints();
    }

    public void useTool(RichTool toolToUse) {
        removeTool(toolToUse);
    }

    public void buyHouse(RichHouse house) {
        if (house.getOwner() != null) throw new HouseOwnerException();
        if (_money < house.getOriginalPrice()) throw new HouseMoneyNotEnoughException();
        addHouse(house);
        _money -= house.getOriginalPrice();
    }

    public int getHousesNumber() {
        return _houses.size();
    }

    public void addHouse(RichHouse house) {
        house.setOwner(this);
        _houses.add(house);
    }

    public void upgradeHouse(RichHouse house) {
        if (!this.equals(house.getOwner())) throw new HouseOwnerException();
        house.upgrade();
        _money -= house.getOriginalPrice();
    }

    public void payHouseToll(RichHouse house) {
        if (this.equals(house.getOwner())) throw new HouseOwnerException();
        _money -= house.getToll();
        RichPlayer owner = house.getOwner();
        owner.addMoney(house.getToll());
    }

    public void addMoney(int money) {
        _money += money;
    }

    public void addPoints(int points) {
        _points += points;
    }

    public void sellHouse(RichHouse house) {
        if (!this.equals(house.getOwner())) throw new HouseOwnerException();
        addMoney(house.getPriceForSell());
        removeHouse(house);
        house.setOwner(null);
        house.setLevel(new RichHousePlatLevel(house.getOriginalPrice()));
    }

    private void removeHouse(RichHouse houseToRemove) {
        for (RichHouse house : _houses) {
            if (house.equals(houseToRemove)) {
                _houses.remove(house);
                return;
            }
        }

        throw new HouseOwnerException();
    }

    public void acceptGift(RichGift gift) {
        gift.openGift(this);
    }


    public void setPosition(RichSitePosition position) {
        _position = position;
    }

    public void stepForward() {
        _remainStep--;
        _position.moveForward(1);
        _position.getSite().acceptPassenger(this);
    }

    public RichSitePosition getPosition() {
        return _position;
    }

    public int getRemainStep() {
        return _remainStep;
    }

    public boolean hasRemainStep() {
        return _remainStep > 0;
    }

    public void setRemainStep(int remainStep) {
        _remainStep = remainStep;
    }

    public void setPunishDays(int punishDays) {
        _punishDays = punishDays;
    }
}