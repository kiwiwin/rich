package DummyObject;

import RichCore.*;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichDummyMapBuilder extends RichMapBuilder {
    private final BufferedReader _dummyReader;
    private final PrintStream _dummyWriter;

    public RichDummyMapBuilder(BufferedReader dummyReader, PrintStream dummyWriter) {
        _dummyReader = dummyReader;
        _dummyWriter = dummyWriter;
    }

    @Override
    public RichSite buildGiftSite(RichGiftFactory factory) {
        return new RichDummySite(_dummyReader, _dummyWriter);
    }

    @Override
    public RichSite buildHospitalSite() {
        return new RichDummySite(_dummyReader, _dummyWriter);
    }

    @Override
    public RichSite buildHouseSite(RichHouse house) {
        return new RichDummySite(_dummyReader, _dummyWriter);
    }

    @Override
    public RichSite buildMagicSite() {
        return new RichDummySite(_dummyReader, _dummyWriter);
    }

    @Override
    public RichSite buildPrisonSite() {
        return new RichDummySite(_dummyReader, _dummyWriter);
    }

    @Override
    public RichSite buildStartSite() {
        return new RichDummySite(_dummyReader, _dummyWriter);
    }

    @Override
    public RichSite buildToolSite(RichToolFactory factory) {
        return new RichDummySite(_dummyReader, _dummyWriter, factory);
    }

    @Override
    public RichSite buildMineSite(RichPoint bonusPoint) {
        return new RichDummySite(_dummyReader, _dummyWriter);
    }
}
