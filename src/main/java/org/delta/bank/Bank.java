package org.delta.bank;

import jakarta.inject.Inject;
import org.delta.bank.account.*;
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

    @Inject private LogService logService;
    @Inject private OwnerFactory ownerFactory;
    @Inject private AccountFactory accountFactory;
    @Inject private InterestTransferService interestTransferService;
    @Inject private MoneyTransferService moneyTransferService;

    public void run() throws Exception {

       // LogService logService = new LogService();
       // OwnerFactory ownerFactory = new OwnerFactory();
        //AccountFactory accountFactory = new AccountFactory();
        System.out.println("Hello bank");
        List<BaseBankAccount> accounts = new LinkedList<BaseBankAccount>();

        //InterestTransferService interestTransferService = new InterestTransferService();

        //MoneyTransferService moneyTransferService = new MoneyTransferService();


        Owner owner = ownerFactory.createOwner("Jakub", "Klucky");

        BaseBankAccount bankAccount = accountFactory.createBaseBankAccount(owner,4000.0);

        BaseBankAccount secondAccount = accountFactory.createBaseBankAccount(owner,  6000.0);

        SavingBankAccount savingAccount = accountFactory.createSavingBankAccount(owner, 4000.0);


        logService.logAccountInfo(bankAccount);
        logService.logAccountInfo(secondAccount);
        logService.logAccountInfo(savingAccount);



        moneyTransferService.transferMoney(bankAccount, secondAccount, 2000);

        logService.logAccountInfo(bankAccount);
        logService.logAccountInfo(secondAccount);

        BaseBankAccount studentAccount = accountFactory.createStudentBankAccount(owner, 5000.0);

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