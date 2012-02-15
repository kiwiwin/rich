package RichCommand;

import RichHouse.RichHouse;

import RichHouse.RichHousePlatLevel;

import RichPlayer.RichPlayer;
import RichTool.RichToolFactory;
import RichPlayer.RichMoney;

public class RichQueryCommand extends RichCommand {
    private RichPlayer _player;

    public RichQueryCommand(RichPlayer player) {
        _player = player;
    }

    public void executeCommand() {
        String result = "";
        result += queryMoney() + "\n";
        result += queryPoints() + "\n";
        result += queryHouse() + "\n";
        result += queryTools();
        System.out.println(result);
    }

    private String queryTools() {
        String result = "道具：";
        result += "路障" + _player.getToolsNumberByType(RichToolFactory.createTool(RichToolFactory.ROADBLOCK)) + "个；";
        result += "炸弹" + _player.getToolsNumberByType(RichToolFactory.createTool(RichToolFactory.BOMB)) + "个；";
        result += "机器娃娃" + _player.getToolsNumberByType(RichToolFactory.createTool(RichToolFactory.ROBOT)) + "个";
        return result;
    }

    private String queryHouse() {
        String result = "地产：";
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(0)));
        result += "空地" + _player.getHousesNumberByLevel(house) + "处；";
        house.upgrade();
        result += "茅屋" + _player.getHousesNumberByLevel(house) + "处；";
        house.upgrade();
        result += "洋房" + _player.getHousesNumberByLevel(house) + "处；";
        house.upgrade();
        result += "摩天楼" + _player.getHousesNumberByLevel(house) + "处";
        return result;
    }

    private String queryPoints() {
        return "点数：" + _player.getPoints() + "点";
    }

    private String queryMoney() {
        return "资金：" + _player.getMoney().toInt() + "元";
    }


    public static String getHelp() {
        return "query        显示自家资产信息";
    }
}
