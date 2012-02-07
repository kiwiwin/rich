package RichMap;

import RichPlayer.RichPlayer;
import RichTool.RichTool;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RichToolSite extends RichSite {
    public void acceptPlayer(RichPlayer player) {
        if (player.getPoints() < 30) return; //return automatically

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        try {
            while ((command = reader.readLine()) != null) {
                if (command.equals("F")) return;
                try {
                    player.buyTool(RichTool.createTool(command));
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
