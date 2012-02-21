package RichCore;

public interface RichDeferredTool {
    public abstract void triggerTool(RichPlayer player);

//    public boolean installTool(RichPlayer player, int offset) {
//        RichSitePosition position = new RichSitePosition(player.getPosition());
//        position.moveForward(offset);
//        return position.getSite().installDeferredTool(this);
//    }

    public String display();
}
