package RichHouse;

public class RichHouseVillaLevel extends RichHouseLevel {
    public void upgrade(RichHouse house) {
        setHouseLevel(house, new RichHouseSkyscraperLevel());
    }
}
