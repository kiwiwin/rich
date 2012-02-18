package RichSite;

import RichCore.RichGift;
import RichCore.RichGiftFactory;
import RichCore.RichPlayer;
import RichCore.RichSite;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichGiftSite extends RichSite {
    RichGiftFactory _giftFactory;

    public RichGiftSite(BufferedReader reader, PrintStream writer, RichGiftFactory factory){
        super(reader, writer);
        _giftFactory = factory;
    }

    public void doAcceptPlayer(RichPlayer player){
        _outputWriter.println("欢迎光临礼品屋，请选择一件您喜欢的礼品：");

        try {
            String giftType = _inputReader.readLine();
            RichGift gift = _giftFactory.createGift(giftType);
            gift.openGift(player);
        } catch (Exception ex) {
            _outputWriter.println(ex.getMessage());
        }
    }

    public String display() {
        return "G";
    }
}
