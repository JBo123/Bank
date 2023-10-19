package org.delta.bank.person;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.delta.bank.account.AccountFactory;
import org.delta.bank.account.BaseBankAccount;
import print.LogService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class OwnerService {

    @Inject private LogService logService;
    @Inject OwnerFactory ownerFactory;
    private Map<UUID, Owner> owners;

    public OwnerService(){
        this.owners = new HashMap<>();

    }

    public void createAndStoreNewOwner(String firstName, String lastName){
        Owner owner = ownerFactory.createOwner(firstName, lastName);
        this.owners.put(owner.getId(), owner);
    }
}
