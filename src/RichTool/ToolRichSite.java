package RichTool;

import RichSite.RichSite;

public class ToolRichSite extends RichSite {
    public void acceptPlayerCommand(ToolBuyCommand command) {
        command.executeCommand();
    }

    public String display() {
        return "T";
    }
}
