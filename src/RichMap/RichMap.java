package RichMap;

import RichHouse.RichHouse;

import RichHouse.RichHousePlatLevel;
import RichPlayer.RichMoney;
import RichPlayer.RichPoint;

public class RichMap {
    private RichSite[] _sites;
    private int _width;
    private int _height;
    private static RichMap _instance;
    private static int HOSPITAL_INDEX = 14;

    protected RichMap(int width, int height) {
        _width = width;
        _height = height;
        _sites = new RichSite[width * 2 + height * 2 - 4];
    }

    public int getSitesNumber() {
        return _sites.length;
    }

    public void setSite(RichSite site, int index) {
        _sites[index] = site;
    }

    public RichSite getSite(int index) {
        return _sites[index];
    }

    public String display() {
        String result = "";
        for (int width = 0; width < _width; width++) {
            result += _sites[width].display();
        }
        result += "\n";

        for (int height = 1; height < _height - 1; height++) {
            result += _sites[getSitesNumber() - height].display();
            for (int width = 1; width < _width - 1; width++) {
                result += " ";
            }
            result += _sites[height + _width - 1].display();
            result += "\n";
        }

        for (int width = 0; width < _width; width++) {
            result += _sites[getSitesNumber() - _height - width + 1].display();
        }

        return result;
    }


    public static RichMap instance() {
        if (_instance == null) {
            _instance = buildMap();
        }

        return _instance;
    }

    public static RichMap buildMap() {
        RichMap map = new RichMap(29, 8);
        map.setSite(new RichStartSite(), 0);
        for (int i = 1; i <= 13; i++) {
            map.setSite(new RichHouseSite(new RichHouse(new RichHousePlatLevel(new RichMoney(200)))), i);
        }
        map.setSite(new RichHospitalSite(), 14);
        for (int i = 15; i <= 27; i++) {
            map.setSite(new RichHouseSite(new RichHouse(new RichHousePlatLevel(new RichMoney(200)))), i);
        }
        map.setSite(new RichToolSite(), 28);
        for (int i = 29; i <= 34; i++) {
            map.setSite(new RichHouseSite(new RichHouse(new RichHousePlatLevel(new RichMoney(500)))), i);
        }
        map.setSite(new RichGiftSite(), 35);
        for (int i = 36; i <= 48; i++) {
            map.setSite(new RichHouseSite(new RichHouse(new RichHousePlatLevel(new RichMoney(300)))), i);
        }
        map.setSite(new RichPrisonSite(), 49);
        for (int i = 50; i <= 62; i++) {
            map.setSite(new RichHouseSite(new RichHouse(new RichHousePlatLevel(new RichMoney(300)))), i);
        }
        map.setSite(new RichMagicSite(), 63);
        map.setSite(new RichMineSite(new RichPoint(20)), 64);
        map.setSite(new RichMineSite(new RichPoint(80)), 65);
        map.setSite(new RichMineSite(new RichPoint(100)), 66);
        map.setSite(new RichMineSite(new RichPoint(40)), 67);
        map.setSite(new RichMineSite(new RichPoint(80)), 68);
        map.setSite(new RichMineSite(new RichPoint(60)), 69);

        return map;
    }

    public RichSitePosition getHospitalSitePosition() {
        return new RichSitePosition(this, HOSPITAL_INDEX);
    }
}
