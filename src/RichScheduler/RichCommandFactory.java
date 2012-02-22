package RichScheduler;

import RichCommand.RichCommand;
import RichCore.RichPlayer;

public interface RichCommandFactory {
    public RichCommand createCommand(String commandString, RichPlayer player);
}
