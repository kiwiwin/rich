package RichMap;

public class RichSitePosition {
    private int _index;
    private RichMap _map;
    
    public RichSitePosition(RichMap map, int index) {
        _map = map;
        _index = index;
    }

    public int getIndex() {
        return _index;
    }

    public void moveForward(int step) {
        _index = (_index + step)%_map.getSitesNumber();
    }

    public RichSite getSite() {
        return _map.getSite(_index);
    }

    public void moveBackward(int step) {
        _index = (_index - step + _map.getSitesNumber())%_map.getSitesNumber();
    }
}
