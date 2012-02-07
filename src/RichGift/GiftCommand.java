package RichGift;

import RichPlayer.RichPlayer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class GiftCommand {
    public abstract void executeCommand();

    public static GiftCommand createGiftCommand(RichPlayer player, String command) {
        if (command.equals("1")) {
            return new GiftMoneyCommand(player);
        } else if (command.equals("2")) {
            return new GiftPointsCommand(player);
        } else if (command.equals("3")) {
            throw new NotImplementedException();
        } else {
            throw new IllegalArgumentException("Unknown gift type");
        }
    }
}
