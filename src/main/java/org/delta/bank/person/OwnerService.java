package org.delta.bank.person;

import org.delta.bank.account.AccountFactory;
import org.delta.bank.account.BaseBankAccount;
import print.LogService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OwnerService {

    private LogService logService;

    private final OwnerFactory ownerFactory;
    private Map<UUID, Owner> owners;

    public OwnerService(){
        this.owners = new HashMap<>();

        this.ownerFactory = new OwnerFactory();

        this.logService = new LogService();
    }

    public void createAndStoreNewOwner(String firstName, String lastName){
        Owner owner = ownerFactory.createOwner(firstName, lastName);
        this.owners.put(owner.getId(), owner);
    }
}
