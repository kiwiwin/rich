package RichMap;

import RichGift.RichGift;
import RichPlayer.RichPlayer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RichGiftSite extends RichSite {
    public void doAcceptPlayer(RichPlayer player){
        System.out.println("欢迎光临礼品屋，请选择一件您喜欢的礼品：");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String giftType = reader.readLine();
            player.acceptGift(RichGift.createGift(Integer.parseInt(giftType)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String display() {
        return "G";
    }
}
