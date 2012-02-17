package RichMap;

import RichHouse.RichHouse;
import RichPlayer.RichPoint;
import RichTool.RichToolFactory;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichDefaultMapBuilder extends RichMapBuilder {
    private BufferedReader _reader;
    private PrintStream _writer;

    public RichDefaultMapBuilder(BufferedReader reader, PrintStream writer) {
        _reader = reader;
        _writer = writer;
    }

    public RichSite buildGiftSite(RichGiftFactory factory) {
        return new RichGiftSite(_reader, _writer, factory);
    }

    public RichSite buildHospitalSite() {
        return new RichHospitalSite(_reader, _writer);
    }

    public RichSite buildHouseSite(RichHouse house) {
        return new RichHouseSite(_reader, _writer, house);
    }

    public RichSite buildMagicSite() {
        return new RichMagicSite(_reader, _writer);
    }

    public RichSite buildPrisonSite() {
        return new RichPrisonSite(_reader, _writer);
    }

    public RichSite buildStartSite() {
        return new RichStartSite(_reader, _writer);
    }

    public RichSite buildToolSite(RichToolFactory factory) {
        return new RichToolSite(_reader, _writer, factory);
    }

    public RichSite buildMineSite(RichPoint point) {
        return new RichMineSite(_reader, _writer, point);
    }
}
