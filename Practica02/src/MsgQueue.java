/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MsgQueue{
	
	private static MsgQueue instance;
	private Map<Integer,Message> msgs;
	private Random rand;
    
    public static synchronized MsgQueue getInstance() {
        if (instance == null) {
            instance = new MsgQueue();
            instance.msgs = new HashMap<Integer,Message>();
            instance.rand = new Random();
        }
        return instance;
    }
	
	public synchronized boolean send(Message msg, Integer destUID){
		if(msgs.containsKey(destUID)) return false;
		msgs.put(destUID, msg);
		System.out.println("msg sent to " + destUID);
		return true;
	}
	
	public synchronized Message receive(Integer destUID){
		if(!msgs.containsKey(destUID)) return null;
		System.out.println("msg received by " + destUID);
		return msgs.remove(destUID);
	}
	
	public synchronized Integer getRandom(Integer max){
		return rand.nextInt(max);
	}
}