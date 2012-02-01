package RichPlayer;

import RichHouse.RichHouse;
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
    private ArrayList<RichHouse> _houses;

    public RichPlayer() {
        _tools = new ArrayList<RichTool>();
        _houses = new ArrayList<RichHouse>();
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
        if (_money < house.getPrice()) throw new HouseMoneyNotEnoughException();
        addHouse(house);
        _money -= house.getPrice();
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
        removeHouse(house);
        addMoney(house.getPriceForSell());
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
}