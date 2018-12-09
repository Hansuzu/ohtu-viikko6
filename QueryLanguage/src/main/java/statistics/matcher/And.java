package statistics.matcher;

import statistics.Player;
import java.util.ArrayList;

public class And implements Matcher {
    private ArrayList<Matcher> matchers;

    public And(Matcher... matchers) {
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
            if (!matcher.matches(p)) {
                return false;
            }
        }

        return true;
    }
}
