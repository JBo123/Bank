package print;

import org.delta.bank.account.BaseBankAccount;

public class ConsoleLogger implements LoggerInterface {
    public void log(String message) {
        System.out.println(message);
    }

    public void logAccountInfo(BaseBankAccount account) {
        String accountInfo = String.format("%s %s owned by %s contains %.2f",
                account.getClass().getSimpleName(),
                account.getAccountNumber(),
                account.getOwner(),
                account.getBalance());

        System.out.println(accountInfo);
    }
}
