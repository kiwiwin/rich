package RichPlayer;

public class ToolUnderflowException extends ToolException {
    public String getMessage(){
        return "You don't have such tool to sell";
    }
}
