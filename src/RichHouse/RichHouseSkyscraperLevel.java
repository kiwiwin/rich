package RichHouse;

public class RichHouseSkyscraperLevel extends RichHouseLevel {
    public void upgrade(RichHouse house) {
        throw new HouseLevelOverflowException();
    }
}
