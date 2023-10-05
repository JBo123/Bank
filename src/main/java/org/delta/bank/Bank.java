package org.delta.bank;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.InterestAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.moneyTransfer.InterestTransferService;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.person.Owner;

import java.util.LinkedList;
import java.util.List;

public class Bank {

    public void run() throws Exception {
        System.out.println("Hello bank");
        List<BaseBankAccount> accounts = new LinkedList<BaseBankAccount>();

        InterestTransferService interestTransferService = new InterestTransferService();

        MoneyTransferService moneyTransferService = new MoneyTransferService();

        Owner owner = new Owner("Jakub", "Klucky");

        BaseBankAccount bankAccount = new BaseBankAccount(owner,"x",4000);

        BaseBankAccount secondAccount = new BaseBankAccount(owner, "38134", 6000);

        BaseBankAccount savingAccount = new BaseBankAccount(owner, "3333", 4000);

        System.out.println(bankAccount.getBalance());
        System.out.println(secondAccount.getBalance());

        moneyTransferService.transferMoney(bankAccount, secondAccount, 2000);

        System.out.println(bankAccount.getBalance());
        System.out.println(secondAccount.getBalance());

        BaseBankAccount studentAccount = new StudentBankAccount(owner, "93214192", 5000);

        System.out.println(studentAccount.getBalance());

        moneyTransferService.transferMoney(studentAccount, secondAccount, 200);

        System.out.println(studentAccount.getBalance());

        accounts.add(bankAccount);
        accounts.add(savingAccount);
        accounts.add(studentAccount);
        for (BaseBankAccount account: accounts ) {

            if(account instanceof InterestAccount){

                interestTransferService.transferMoney(account);

            }
            System.out.println(account.getOwner() + ", balance: " + account.getBalance());
        }

    }
}