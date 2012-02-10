package RichCommand;

import RichUtil.RichScheduler;

public class RichMain {
    public static void main(String args[]) {
        System.out.println((char)27+"[01;31m;This text is red."+(char)27+"[00;00m");
        RichScheduler.initialize();
        RichScheduler.schedule();
    }
}
