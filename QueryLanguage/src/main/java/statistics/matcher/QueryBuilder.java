
package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder{
  And matcher;
  public QueryBuilder(){
    matcher = new And();
  }

  public QueryBuilder oneOf(Matcher... matchers) {
    matcher = new And(new Or(matchers));
    return this;
  }

  public QueryBuilder playsIn(String team){
    matcher.add(new PlaysIn(team));
    return this;
  }

  public QueryBuilder hasFewerThan(int value, String category){
    matcher.add(new HasFewerThan(value, category));
    return this;
  }

  public QueryBuilder hasAtLeast(int value, String category){
    matcher.add(new HasAtLeast(value, category));
    return this;
  }

  public Matcher build(){
    Matcher matcher = this.matcher;
    this.matcher = new And();
    return matcher;
  }
}