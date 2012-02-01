package RichHouse;

public class RichHouseSite {
    private RichHouse _house;
    
    public RichHouseSite(){
        _house = new RichHouse();
    }

    public String display() {
        return "O";
    }

    public void acceptPlayerCommand(HouseCommand command) {
        command.executeCommand();
    }

    public RichHouse getHouse() {
        return _house;
    }

    public void setHouse(RichHouse house) {
        _house = house;
    }
}
