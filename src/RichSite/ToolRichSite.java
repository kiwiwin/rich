package RichSite;

import RichTool.*;

public class ToolRichSite extends RichSite {
    public void acceptPlayerCommand(ToolBuyCommand command) {
        command.executeCommand();
    }
}
