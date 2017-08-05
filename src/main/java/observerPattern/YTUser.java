/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerPattern;

/**
 *
 * @author Lukasz
 */
public class YTUser implements Observer{
   private String name;
   private int videosToWatch;

    public YTUser(String name) {
        this.name = name;
        videosToWatch = 0;
    }

    @Override
    public void update() {
        videosToWatch ++;
        System.out.println("Czesc: " + name + "Subskrybujesz ilsoc kanalow " + videosToWatch);
    }
   
    
   
    
}
