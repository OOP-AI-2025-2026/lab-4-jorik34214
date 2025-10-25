import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Startup;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;

public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int initialBalance = super.getBalance();
        this.minBalance = initialBalance;
        this.maxBalance = initialBalance;
    }

    @Override
    public void debit(final Debit d) {
        super.debit(d);
        updateMinMax();
    }

    @Override
    public void credit(final Credit c) {
        super.credit(c);
        updateMinMax();
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }

    private void updateMinMax() {
        int currentBalance = super.getBalance();
        if (currentBalance < minBalance) {
            minBalance = currentBalance;
        }
        if (currentBalance > maxBalance) {
            maxBalance = currentBalance;
        }
    }
}