package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    public void setNextStringToPrint(String str);

    public String getNextStringToPrint();

    public List<String> getHistory();

    public void printCurrentString();
}
