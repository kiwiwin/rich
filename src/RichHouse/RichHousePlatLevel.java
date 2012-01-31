package RichHouse;

public class RichHousePlatLevel extends RichHouseLevel {
    public void upgrade(RichHouse house){
        setHouseLevel(house, new RichHouseCottageLevel());
    }
}
