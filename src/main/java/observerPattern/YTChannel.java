/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerPattern;

import java.util.ArrayList;

/**
 *
 * @author Lukasz
 */
public class YTChannel implements Subject{
    private ArrayList<Observer> observerList;

    public YTChannel() {
        observerList = new ArrayList<>();
    }
    
    public void publishNewVideo(){
        System.out.println("YTChannel published new video");
        notifyObserver();
    }
    
    @Override
    public void register(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o: observerList){
            o.update();
        }
    }
    
}
