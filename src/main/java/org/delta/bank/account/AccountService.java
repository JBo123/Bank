package org.delta.bank.account;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.delta.bank.person.Owner;
import org.delta.bank.person.OwnerFactory;
import print.LogService;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class AccountService {

    @Inject private LogService logService;

    @Inject AccountFactory accountFactory;
    private Map<String, BaseBankAccount> accounts;

    public AccountService(){
        this.accounts = new HashMap<>();
    }

    public void createAndStoreNewBaseBankAccount(Owner owner,
                                             double balance){

        BaseBankAccount bankAccount = accountFactory.createBaseBankAccount(owner, balance);

        this.accounts.put(bankAccount.getAccountNumber() , bankAccount);
        this.logService.logAccountInfo(bankAccount);

    }

    public void createAndStoreNewSavingBankAccount(Owner owner,
                                                 double balance){

        SavingBankAccount bankAccount = accountFactory.createSavingBankAccount(owner, balance);
        this.accounts.put(bankAccount.getAccountNumber(), bankAccount);
        this.logService.logAccountInfo(bankAccount);

    }

    public void createAndStoreNewStudentBankAccount(Owner owner,
                                                 double balance){

        StudentBankAccount bankAccount = accountFactory.createStudentBankAccount(owner, balance);
        this.accounts.put(bankAccount.getAccountNumber(), bankAccount);
        this.logService.logAccountInfo(bankAccount);

    }

    public Map<String, BaseBankAccount> getAccounts(){
        return  accounts;
    }
}
