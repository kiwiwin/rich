package RichHouse;

public class RichHouse {
    private RichHouseLevel _houseLevel;

    public RichHouse() {
        _houseLevel = new RichHousePlatLevel();
    }

    public void upgrade() {
        _houseLevel.upgrade(this);
    }

    public void setLevel(RichHouseLevel level) {
        _houseLevel = level;
    }

    public RichHouseLevel getLevel() {
        return _houseLevel;
    }
}
