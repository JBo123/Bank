package org.delta.bank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import jakarta.inject.Inject;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            Injector injector = Guice.createInjector(new BankInjector());
            Bank bank = injector.getInstance(Bank.class);
            bank.run();
        } catch (Exception e) {
            System.out.println(e);
        }    }
}