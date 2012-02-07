package RichTool;

public class BombTool extends RichTool {
    public String display() {
        return "@";
    }

    public int getPoints() {
        return 50;
    }

    public String getName() {
        return "炸弹";
    }

    protected BombTool() {
    }

    public boolean equals(Object arg) {
        return arg instanceof BombTool;
    }
}
