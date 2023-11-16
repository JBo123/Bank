package org.delta.bank.person;


import com.google.gson.Gson;
import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;

public class OwnerToJsonService implements OwnerToJsonInterface {

    @Inject Gson gson;
    public String OwnerToJson(Owner owner) {
        return gson.toJson(owner);
    }
}
