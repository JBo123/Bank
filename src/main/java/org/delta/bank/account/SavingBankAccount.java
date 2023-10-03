package org.delta.bank.account;

import org.delta.bank.person.Owner;

public class SavingBankAccount extends BaseBankAccount {


    public SavingBankAccount(Owner owner, String bankAccountNumber, double balance) {
        super(owner, bankAccountNumber, balance);
    }
}
