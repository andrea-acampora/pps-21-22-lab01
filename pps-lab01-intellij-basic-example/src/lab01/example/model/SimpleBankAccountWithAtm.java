package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractBankAccount {

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(balance, holder);
    }

    @Override
    public double getFee() {
        return 1;
    }
}
