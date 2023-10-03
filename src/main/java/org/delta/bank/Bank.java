package org.delta.bank;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.person.Owner;

public class Bank {


    public void run() throws  Exception {

        MoneyTransferService moneyTransferService = new MoneyTransferService();

        Owner owner = new Owner("Jan", "Novák");
        BaseBankAccount basebankAccount = new BaseBankAccount(owner, "1345", 222);

        //ATM
        moneyTransferService.transferMoneyByATM(basebankAccount, 100);

        BaseBankAccount studentBankAccount = new StudentBankAccount(owner, "1111", 333);
        moneyTransferService.transferMoney(studentBankAccount, basebankAccount, 200);
    }
}
