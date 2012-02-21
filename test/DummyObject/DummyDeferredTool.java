package DummyObject;

import RichCore.RichDeferredTool;
import RichCore.RichPlayer;

public class DummyDeferredTool implements RichDeferredTool {
    private boolean _used;

    public DummyDeferredTool() {
        _used = false;
    }

    public void triggerTool(RichPlayer player) {
        _used = true;
    }

    public String display() {
        return "Dummy Deferred Tool";
    }

    public boolean isUsed() {
        return _used;
    }
}
