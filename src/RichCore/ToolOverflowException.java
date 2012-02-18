package RichCore;

public class ToolOverflowException extends ToolException{
    public String getMessage(){
        return "Each player cannot have more than 10 tools";
    }
}
