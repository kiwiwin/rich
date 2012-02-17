package RichPlayer;

import RichHouse.HouseMoneyNotEnoughException;
import RichHouse.HouseOwnerException;
import RichHouse.RichHouse;
import RichMap.RichSitePosition;
import RichTool.RichTool;
import RichTool.ToolOverflowException;
import RichTool.ToolPointsNotEnoughException;
import RichTool.ToolUnderflowException;

import java.util.ArrayList;

public class RichPlayer {
    private RichPoint _points;
    private RichMoney _money;

    private ArrayList<RichTool> _tools;
    private ArrayList<RichHouse> _houses;
    private RichSitePosition _position;
    private int _remainStep;
    private int _punishDays;
    private int _blessingGodDays;
    private String _name;

    public RichPlayer(RichMoney money, RichPoint point) {
        _tools = new ArrayList<RichTool>();
        _houses = new ArrayList<RichHouse>();
        _money = money;
        _points = point;
    }

    public int getToolsNumber() {
        return _tools.size();
    }

    public void addTool(RichTool tool) {
        final int TOOL_NUMBER_LIMIT = 10;
        if (getToolsNumber() >= TOOL_NUMBER_LIMIT) throw new ToolOverflowException();
        _tools.add(tool);
    }

    public void removeTool(RichTool toolToRemove) {
        for (RichTool tool : _tools) {
            if (tool.isSameTool(toolToRemove)) {
                _tools.remove(tool);
                return;
            }
        }

        throw new ToolUnderflowException(toolToRemove);
    }

    public RichPoint getPoints() {
        return _points;
    }

    public RichMoney getMoney() {
        return _money;
    }

    public void buyTool(RichTool tool) {
        if (getPoints().isLessThan(tool.getPoints())) throw new ToolPointsNotEnoughException(_points, tool);
        addTool(tool);
        subtractPoints(tool.getPoints());
    }

    public void sellTool(RichTool toolToSell) {
        removeTool(toolToSell);
        addPoints(toolToSell.getPoints());
    }

    public void useTool(RichTool toolToUse) {
        removeTool(toolToUse);
    }

    public void buyHouse(RichHouse house) {
        if (house.getOwner() != null) throw new HouseOwnerException();
        if (_money.isLessThan(house.getOriginalPrice())) throw new HouseMoneyNotEnoughException();
        addHouse(house);
        subtractMoney(house.getOriginalPrice());
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
        subtractMoney(house.getOriginalPrice());
    }

    public void payHouseToll(RichHouse house) {
        if (this.equals(house.getOwner())) throw new HouseOwnerException();
        subtractMoney(house.getToll());
        RichPlayer owner = house.getOwner();
        owner.addMoney(house.getToll());
    }

    public void addMoney(RichMoney money) {
        _money = _money.add(money);
    }

    public void subtractMoney(RichMoney money) {
        _money = _money.subtract(money);
    }

    public void addPoints(RichPoint points) {
        _points = _points.add(points);
    }

    public void subtractPoints(RichPoint points) {
        _points = _points.subtract(points);
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

    public void setPosition(RichSitePosition position) {
        if (_position != null) _position.getSite().removePlayer(this);
        _position = position;
        _position.getSite().addPlayer(this);
    }

    public void forwardSteps(int step) {
        if (_position != null) _position.getSite().removePlayer(this);
        setRemainStep(step);
        while (hasRemainStep()) {
            _remainStep--;
            forwardSingleStep();
        }

        if (!isPunished()) {
            _position.getSite().acceptPlayer(this);
        } else {
            _position.getSite().removePlayer(this);
        }
    }

    private void forwardSingleStep() {
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

    public String display() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getPunishDays() {
        return _punishDays;
    }

    public int getToolsNumberByType(RichTool tool) {
        int result = 0;
        for (RichTool t : _tools) {
            if (t.isSameTool(tool)) result++;
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