package RichHouse;

public class RichHouseCottageLevel extends RichHouseLevel {
    public void upgrade(RichHouse house) {
        setHouseLevel(house, new RichHouseVillaLevel());
    }
}
