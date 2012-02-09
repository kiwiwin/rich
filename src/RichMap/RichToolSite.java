package RichMap;

import RichPlayer.RichPlayer;
import RichTool.RichToolFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RichToolSite extends RichSite {
    public void doAcceptPlayer(RichPlayer player) {
        if (player.getPoints() < 30) return; //player do not have enough points, return automatically

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        try {
            while ((command = reader.readLine()) != null) {
                if (command.equals("F")) return;
                try {
                    player.buyTool(RichToolFactory.createTool(command));
                    if (player.getPoints() < 30) return; //player do not have enough points, return automatically
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String display() {
        return "T";
    }
}
