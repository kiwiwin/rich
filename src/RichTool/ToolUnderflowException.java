package RichTool;

public class ToolUnderflowException extends ToolException {
    private RichTool _tool;

    public ToolUnderflowException(RichTool tool) {
        _tool = tool;
    }

    public String getMessage() {
        return "You don't have " + _tool.getName();
    }
}
