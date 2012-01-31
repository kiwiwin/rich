package RichHouse;

public abstract class RichHouseLevel {
    public abstract void upgrade(RichHouse house);
    protected void setHouseLevel(RichHouse house, RichHouseLevel level){
        house.setLevel(level);
    }
}
