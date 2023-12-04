package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private List<String> strList = new LinkedList<>();
    private String nextString;

    @Override
    public void setNextStringToPrint(String str){
        this.nextString = Objects.requireNonNull(str);
    }

    @Override
    public String getNextStringToPrint() {
        return nextString;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(strList);
    }

    @Override
    public void printCurrentString() {
        strList.add(nextString);
        System.out.println(nextString);
    }

}
