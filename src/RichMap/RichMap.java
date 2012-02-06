package RichMap;

import java.util.ArrayList;

public class RichMap {
    private ArrayList<RichSite> _sites;

    public RichMap() {
        _sites = new ArrayList<RichSite>();
    }

    public int getSitesNumber(){
        return _sites.size();
    }

    public void addSiteAtTail(RichSite site) {
        _sites.add(site);
    }

    public RichSite getSite(int index) {
        return _sites.get(index);
    }
    
    public RichSite setSite(int index, RichSite site){
        return _sites.set(index, site);
    }
}
