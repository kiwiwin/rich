package RichMine;

public class RichMineSite {
    private int _minPoints;

    public RichMineSite(int minePoints) {
        _minPoints = minePoints;
    }

    public void acceptPlayerCommand(MineCommand command) {
        command.executeCommand();
    }

    public int getMinePoints() {
        return _minPoints;
    }
}
