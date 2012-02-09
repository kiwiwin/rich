package RichMap;

import RichGift.GiftCommand;
import RichPlayer.RichPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RichGiftSite extends RichSite {
    public void doAcceptPlayer(RichPlayer player){
        System.out.println("欢迎光临礼品屋，请选择一件您喜欢的礼品：");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String command = reader.readLine();
            GiftCommand.createGiftCommand(player, command).executeCommand();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String display() {
        return "G";
    }
}
