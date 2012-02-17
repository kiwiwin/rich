package RichMap;

import RichHouse.RichHouse;
import RichPlayer.RichPoint;
import RichTool.RichToolFactory;

public abstract class RichMapBuilder {

    public abstract RichSite buildGiftSite(RichGiftFactory factory);

    public abstract RichSite buildHospitalSite();

    public abstract RichSite buildHouseSite(RichHouse house);

    public abstract RichSite buildMagicSite();

    public abstract RichSite buildPrisonSite();

    public abstract RichSite buildStartSite();

    public abstract RichSite buildToolSite(RichToolFactory factory);

    public abstract RichSite buildMineSite(RichPoint bonusPoint);
}
