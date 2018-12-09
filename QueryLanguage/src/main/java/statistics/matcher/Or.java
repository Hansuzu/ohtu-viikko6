package statistics.matcher;

import java.util.ArrayList;
import statistics.Player;

public class Or implements Matcher {

    private ArrayList<Matcher> matchers;

    public Or(Matcher... matchers) {
        this.matchers = new ArrayList<Matcher>();
        for (Matcher matcher : matchers){
            this.matchers.add(matcher);
        }
    }

    public void add(Matcher matcher){
        this.matchers.add(matcher);
    }


    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                return true;
            }
        }
        return false;
    }
}
