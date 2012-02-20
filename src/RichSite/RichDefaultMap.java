package RichSite;

import RichCore.*;
import RichGift.RichGiftDefaultFactory;
import RichHouse.RichHousePlatLevel;
import RichTool.RichDefaultToolFactory;

public class RichDefaultMap extends RichMap {
    private final int WIDTH = 29;
    private final int HEIGHT = 8;
    private final int HOSPITAL_SITE_INDEX = 14;
    private final RichSite[] _sites = new RichSite[WIDTH * 2 + HEIGHT * 2 - 4];

    public RichDefaultMap(RichMapBuilder mapBuilder) {
        super(mapBuilder);
    }

    public int getSitesNumber() {
        return _sites.length;
    }

    public RichSite getSite(int index) {
        return _sites[index];
    }

    public String display() {
        String result = "";
        for (int width = 0; width < WIDTH; width++) {
            result += _sites[width].display();
        }
        result += "\n";

        for (int height = 1; height < HEIGHT - 1; height++) {
            result += _sites[getSitesNumber() - height].display();
            for (int width = 1; width < WIDTH - 1; width++) {
                result += " ";
            }
            result += _sites[height + WIDTH - 1].display();
            result += "\n";
        }

        for (int width = 0; width < WIDTH; width++) {
            result += _sites[getSitesNumber() - HEIGHT - width + 1].display();
        }

        return result;
    }

    public void buildMap() {
        setSite(_mapBuilder.buildStartSite(), 0);
        for (int i = 1; i <= 13; i++) {
            setSite(_mapBuilder.buildHouseSite(new RichHouse(new RichHousePlatLevel(new RichMoney(200)))), i);
        }
        setSite(_mapBuilder.buildHospitalSite(), HOSPITAL_SITE_INDEX);
        for (int i = 15; i <= 27; i++) {
            setSite(_mapBuilder.buildHouseSite(new RichHouse(new RichHousePlatLevel(new RichMoney(200)))), i);
        }
        setSite(_mapBuilder.buildToolSite(new RichDefaultToolFactory()), 28);
        for (int i = 29; i <= 34; i++) {
            setSite(_mapBuilder.buildHouseSite(new RichHouse(new RichHousePlatLevel(new RichMoney(500)))), i);
        }
        setSite(_mapBuilder.buildGiftSite(new RichGiftDefaultFactory()), 35);
        for (int i = 36; i <= 48; i++) {
            setSite(_mapBuilder.buildHouseSite(new RichHouse(new RichHousePlatLevel(new RichMoney(300)))), i);
        }
        setSite(_mapBuilder.buildPrisonSite(), 49);
        for (int i = 50; i <= 62; i++) {
            setSite(_mapBuilder.buildHouseSite(new RichHouse(new RichHousePlatLevel(new RichMoney(300)))), i);
        }
        setSite(_mapBuilder.buildMagicSite(), 63);
        setSite(_mapBuilder.buildMineSite(new RichPoint(20)), 64);
        setSite(_mapBuilder.buildMineSite(new RichPoint(80)), 65);
        setSite(_mapBuilder.buildMineSite(new RichPoint(100)), 66);
        setSite(_mapBuilder.buildMineSite(new RichPoint(40)), 67);
        setSite(_mapBuilder.buildMineSite(new RichPoint(80)), 68);
        setSite(_mapBuilder.buildMineSite(new RichPoint(60)), 69);
    }

    public int getHospitalIndex() {
        return HOSPITAL_SITE_INDEX;
    }

    private void setSite(RichSite site, int index) {
        _sites[index] = site;
    }


}
