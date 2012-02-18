package RichCore;

public class RichPlayerFactory {
    public static RichPlayer createPlayer(String index, RichMoney money) {
        RichPlayer player = new RichPlayer(money, null);
        if (index.equals("1")) {
            player.setName("Q");
        } else if (index.equals("2")) {
            player.setName("A");
        } else if (index.equals("3")) {
            player.setName("S");
        } else if (index.equals("4")) {
            player.setName("J");
        } else {
            throw new IllegalArgumentException("Unknown player index");
        }

        return player;
    }

    public static RichPlayer[] createPlayers(String text, RichMoney money) {
        RichPlayer players[] = new RichPlayer[text.length()];
        for (int i = 0; i < text.length(); i++) {
            players[i] = createPlayer(text.substring(i, i+1), money);
        }
        return players;
    }
}
