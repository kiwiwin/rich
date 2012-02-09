package RichPlayer;

import RichGift.RichGift;
import RichHouse.RichHouse;
import RichMap.RichSitePosition;
import RichTool.ITool;
import RichTool.ToolOverflowException;
import RichTool.ToolUnderflowException;
import RichTool.ToolPointsNotEnoughException;

import RichHouse.HouseMoneyNotEnoughException;
import RichHouse.HouseOwnerException;

import java.util.ArrayList;

public class RichPlayer {
    private int _points;
    private int _money;

    private ArrayList<ITool> _tools;
    private final int TOOL_NUMBER_LIMIT = 10;
    private final int DEFAULT_INIT_MONEY_COUNT = 10000;
    private final int DEFAULT_INIT_POINTS_COUNT = 0;
    private ArrayList<RichHouse> _houses;
    private RichSitePosition _position;
    private int _remainStep;
    private int _punishDays;
    private int _blessingGodDays;
    private String _name;

    public RichPlayer() {
        _tools = new ArrayList<ITool>();
        _houses = new ArrayList<RichHouse>();
        _money = DEFAULT_INIT_MONEY_COUNT;
        _points = DEFAULT_INIT_POINTS_COUNT;
        _position = null;//TODO:change ?
    }

    public int getToolsNumber() {
        return _tools.size();
    }

    public void addTool(ITool tool) {
        if (getToolsNumber() >= TOOL_NUMBER_LIMIT) throw new ToolOverflowException();
        _tools.add(tool);
    }

    public void removeTool(ITool toolToRemove) {
        for (ITool tool : _tools) {
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

    public void buyTool(ITool tool) {
        if (getPoints() < tool.getPoints()) throw new ToolPointsNotEnoughException(_points, tool);
        addTool(tool);
        _points -= tool.getPoints();
    }

    public void sellTool(ITool toolToSell) {
        removeTool(toolToSell);
        _points += toolToSell.getPoints();
    }

    public void useTool(ITool toolToUse) {
        removeTool(toolToUse);
    }

    public void buyHouse(RichHouse house) {
        if (house.getOwner() != null) throw new HouseOwnerException();
        if (_money < house.getOriginalPrice()) throw new HouseMoneyNotEnoughException();
        addHouse(house);
        _money -= house.getOriginalPrice();
    }

    public void sellHouse(RichHouse house) {
        if (!this.equals(house.getOwner())) throw new HouseOwnerException();
        addMoney(house.getPriceForSell());
        removeHouse(house);
        house.sell();
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
        if (_position != null) _position.getSite().removePlayer(this);
        _position = position;
        _position.getSite().addPlayer(this);
    }

    public void stepForward(int step) {
        if (_position != null) _position.getSite().removePlayer(this);
        setRemainStep(step);
        while (_remainStep-- > 0) {
            stepForward();
        }
    }

    private void stepForward() {
        _position.moveForward(1);
        _position.getSite().acceptPassenger(this);
    }

    public RichSitePosition getPosition() {
        return _position;
    }

    private int getRemainStep() {
        return _remainStep;
    }

    public boolean hasRemainStep() {
        return getRemainStep() > 0;
    }

    public void setRemainStep(int remainStep) {
        _remainStep = remainStep;
    }

    public void setPunishDays(int punishDays) {
        _punishDays = punishDays;
    }

    public boolean isPunished() {
        return _punishDays > 0;
    }

    public void setBlessingGod() {
        _blessingGodDays = 5;
    }

    public boolean hasBlessingGod() {
        return _blessingGodDays > 0;
    }

    public void setVisible(boolean visible) {
        if (visible) {
            _position.getSite().addPlayer(this);
        } else {
            _position.getSite().removePlayer(this);
        }
    }

    public String display() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getPunlishDays() {
        return _punishDays;
    }

    public int getToolsNumberByType(ITool tool) {
        int result = 0;
        for (ITool t : _tools) {
            if (t.equals(tool)) result++;
        }
        return result;
    }

    public int getHousesNumberByLevel(RichHouse house) {
        int result = 0;
        for (RichHouse h : _houses) {
            if (h.isSameLevel(house)) result++;
        }
        return result;
    }
}