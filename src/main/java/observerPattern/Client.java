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
public class Client {
    
    public static void main(String[] args){
        YTChannel ytChannel = new YTChannel();
        
        YTUser user = new YTUser("Lukasz");
        ytChannel.register(user);
        //ytChannel.publishNewVideo();
        
        YTUser user2 = new YTUser("Lukasz2");
        ytChannel.register(user2);
        //ytChannel.publishNewVideo();
        
        YTUser user4 = new YTUser("Lukasz3");
        ytChannel.register(user4);
        ytChannel.publishNewVideo();
        ytChannel.publishNewVideo();
        ytChannel.unregister(user);
        ytChannel.publishNewVideo();
    }
}
