package org.delta.bank;

import org.delta.bank.account.AccountFactory;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.InterestAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.moneyTransfer.InterestTransferService;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.person.Owner;
import org.delta.bank.person.OwnerFactory;
import print.ConsoleLogger;
import print.LogService;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class Bank {

    public void run() throws Exception {

        LogService logService = new LogService();
        OwnerFactory ownerFactory = new OwnerFactory();
        AccountFactory accountFactory = new AccountFactory();
        System.out.println("Hello bank");
        List<BaseBankAccount> accounts = new LinkedList<BaseBankAccount>();

        InterestTransferService interestTransferService = new InterestTransferService();

        MoneyTransferService moneyTransferService = new MoneyTransferService();


        Owner owner = ownerFactory.createOwner("Jakub", "Klucky");

        BaseBankAccount bankAccount = accountFactory.createBaseBankAccount(owner,4000.0);

        BaseBankAccount secondAccount = new BaseBankAccount(owner, "38134", 6000);

        BaseBankAccount savingAccount = new BaseBankAccount(owner, "3333", 4000);


        logService.logAccountInfo(bankAccount);
        logService.logAccountInfo(secondAccount);
        logService.logAccountInfo(savingAccount);



        moneyTransferService.transferMoney(bankAccount, secondAccount, 2000);

        logService.logAccountInfo(bankAccount);
        logService.logAccountInfo(secondAccount);

        BaseBankAccount studentAccount = new StudentBankAccount(owner, "93214192", 5000);

        logService.logAccountInfo(studentAccount);

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