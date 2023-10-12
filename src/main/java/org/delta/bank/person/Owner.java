package org.delta.bank.person;

import java.util.UUID;

public class Owner {

    private UUID id;
    private String firstName;

    private String lastName;

    public Owner(UUID id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public UUID getId(){
        return id;
    }
}
