package RichTool;

public class ToolUnderflowException extends ToolException {
    private ITool _tool;

    public ToolUnderflowException(ITool tool) {
        _tool = tool;
    }

    public String getMessage() {
        return "You don't have " + _tool.getName();
    }
}
