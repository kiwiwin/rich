package RichGift;

import RichPlayer.RichPlayer;

public class GiftMoneyCommand extends GiftCommand {
    private static final int BONUS_MONEY = 2000;
    private RichPlayer _player;

    public GiftMoneyCommand(RichPlayer player) {
        _player = player;
    }

    public void executeCommand() {
        _player.addMoney(BONUS_MONEY);
    }
}
