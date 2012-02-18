package RichGift;

import RichCore.RichGift;
import RichCore.RichPlayer;

public class BlessingGodGift implements RichGift {

    public void openGift(RichPlayer player) {
        player.setBlessingGod();
    }
}
