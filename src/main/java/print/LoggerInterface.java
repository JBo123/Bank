package print;

import org.delta.bank.account.BaseBankAccount;

public interface LoggerInterface {
    void log(String message);

    void logAccountInfo(BaseBankAccount account);
}
