package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberViewImpl implements it.unibo.mvc.api.DrawNumberView{

    @Override
    public void setController(DrawNumberController observer) {
        
    }

    @Override
    public void start() {
        
    }

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
    }
    
}
