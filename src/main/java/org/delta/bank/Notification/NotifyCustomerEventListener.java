package org.delta.bank.Notification;

import com.google.common.eventbus.Subscribe;

public class NotifyCustomerEventListener {

    @Subscribe
    public void notifyCustomerEvent(NotifyCustomerEvent notifyCustomerEvent){
        System.out.println("########");
        System.out.println("##Event: " + notifyCustomerEvent.getNotificationData());
        System.out.println("########");

    }
}
