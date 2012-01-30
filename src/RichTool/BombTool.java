package RichTool;

public class BombTool extends RichTool {
    public String display() {
        return "@";
    }

    public int getPoints() {
        return 50;
    }

    public String getName() {
        return "Bomb";
    }

    protected BombTool() {
    }
}
