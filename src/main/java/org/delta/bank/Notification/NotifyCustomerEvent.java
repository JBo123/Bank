package org.delta.bank.Notification;

public class NotifyCustomerEvent {
    public  NotificationData notificationData;

    public NotifyCustomerEvent(NotificationData notificationData){
        this.notificationData = notificationData;
    }

    public NotificationData getNotificationData() {
        return notificationData;
    }
}
