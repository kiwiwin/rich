package RichMain;

import RichCommand.RichDefaultCommandFactory;
import RichCore.RichMap;
import RichCore.RichSitePosition;
import RichScheduler.RichCommandFactory;
import RichScheduler.RichPlayerFactory;
import RichScheduler.RichScheduler;
import RichSite.RichDefaultMap;
import RichSite.RichDefaultMapBuilder;
import RichTool.RichDefaultToolFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class RichMain {
    public static void main(String args[]) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream writer = System.out;

        RichMap map = initMap(reader, writer);
        RichCommandFactory commandFactory = initCommandFactory(writer, map);
        RichPlayerFactory playerFactory = new RichPlayerFactory();

        RichScheduler scheduler = initScheduler(reader, writer, map, commandFactory, playerFactory);

        while (true) {
            try {
                scheduler.initMoney();
                break;
            } catch (Exception ex) {
                writer.println(ex.getMessage());
            }
        }

        while (true) {
            try {
                scheduler.initPlayers();
                break;
            } catch (Exception ex) {
                writer.println(ex.getMessage());
            }
        }

        scheduler.schedule();
    }

    private static RichScheduler initScheduler(BufferedReader reader, PrintStream writer, RichMap map, RichCommandFactory commandFactory, RichPlayerFactory factory) {
        RichScheduler scheduler = new RichScheduler(reader, writer);
        scheduler.setPlayerFactory(factory);
        scheduler.setCommandFactory(commandFactory);
        scheduler.setMap(map);
        return scheduler;
    }

    private static RichCommandFactory initCommandFactory(PrintStream writer, RichMap map) {
        RichDefaultCommandFactory commandFactory = new RichDefaultCommandFactory();
        commandFactory.setToolFactory(new RichDefaultToolFactory());
        commandFactory.setMap(map);
        commandFactory.setWriter(writer);
        commandFactory.setHospitalSitePosition(new RichSitePosition(map, map.getHospitalIndex()));
        return commandFactory;
    }

    private static RichMap initMap(BufferedReader reader, PrintStream writer) {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(reader, writer));
        map.buildMap();
        return map;
    }
}
