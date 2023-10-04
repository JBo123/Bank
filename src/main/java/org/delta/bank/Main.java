package org.delta.bank;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            Bank bank = new Bank();
            bank.run();
        } catch (Exception e) {
            System.out.println(e);
        }    }
}