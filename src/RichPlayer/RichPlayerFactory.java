package RichPlayer;

public class RichPlayerFactory {
    public static RichPlayer createPlayer(String index) {
        RichPlayer player = new RichPlayer();
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
}
