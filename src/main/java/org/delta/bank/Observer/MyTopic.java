package org.delta.bank.Observer;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

    List<Observer> observers = new ArrayList<>();
    String message;
    Boolean changed;
    Object MUTEX = new Object();

    public MyTopic(){

    }

    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if(!observers.contains(obj)) observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }
    public void notifyObservers(){

        List<Observer> observersLocal = null;
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }

    }
    public Object getUpdate(Observer obj){

    return this.message;
    }
    public void postMessage(String str){
        System.out.println("Message Posted to Topic:"+str);
        this.message=str;
        this.changed=true;
        notifyObservers();
    }



}
