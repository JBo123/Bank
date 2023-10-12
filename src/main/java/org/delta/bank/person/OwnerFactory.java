package org.delta.bank.person;

import print.LogService;
import print.LoggerInterface;

import java.util.UUID;

public class OwnerFactory {

    private OwnerIdGeneratorService ownerIdGeneratorService;

    private LogService logService;

    public OwnerFactory(){
        this.logService = new LogService();
    }
    public Owner createOwner(String name, String lastName){
        UUID id = ownerIdGeneratorService.generateOwnerUUID();
        return new Owner(id, name, lastName);
    }
}
