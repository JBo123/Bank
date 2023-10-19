package org.delta.bank.person;

import jakarta.inject.Inject;
import print.LogService;
import print.LoggerInterface;

import java.util.UUID;

public class OwnerFactory {

    private OwnerIdGeneratorService ownerIdGeneratorService;

    @Inject LogService logService;


    public Owner createOwner(String name, String lastName){
        UUID id = ownerIdGeneratorService.generateOwnerUUID();
        return new Owner(id, name, lastName);
    }
}
