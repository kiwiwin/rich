package RichCore;

public class ToolOverflowException extends ToolException {
    public String getMessage() {
        return "你最多能够拥有10个道具";
    }
}
