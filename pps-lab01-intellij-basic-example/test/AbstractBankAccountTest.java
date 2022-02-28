import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {

    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;
    @Test
    void testInitialBalance() {
        Assertions.assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        int deposited_amount = 100;
        bankAccount.deposit(accountHolder.getId(), deposited_amount);
        assertEquals(deposited_amount - bankAccount.getFee(), bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        final int deposited_amount = 100;
        final int withdrawn_amount = 70;
        bankAccount.deposit(accountHolder.getId(), deposited_amount);
        bankAccount.withdraw(accountHolder.getId(), withdrawn_amount);
        Assertions.assertEquals(deposited_amount - withdrawn_amount - 2 * bankAccount.getFee(), bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        final int deposited_amount = 100;
        bankAccount.deposit(accountHolder.getId(), deposited_amount);
        bankAccount.deposit(2, 50);
        Assertions.assertEquals(deposited_amount - bankAccount.getFee(), bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        final int deposited_amount = 100;
        final int withdrawn_amount = 70;
        bankAccount.deposit(accountHolder.getId(), deposited_amount);
        bankAccount.withdraw(2, withdrawn_amount);
        Assertions.assertEquals(deposited_amount - bankAccount.getFee(), bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithoutEnoughMoney() {
        final int deposited_amount = 100;
        final int withdrawn_amount = 200;
        bankAccount.deposit(accountHolder.getId(), deposited_amount);
        bankAccount.withdraw(accountHolder.getId(), withdrawn_amount);
        assertEquals(deposited_amount - bankAccount.getFee(), bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithoutEnoughMoneyOfGoldAccount() {
        this.accountHolder.setGoldAccount(true);
        final int deposited_amount = 100;
        final int withdrawn_amount = 200;
        bankAccount.deposit(accountHolder.getId(), deposited_amount);
        bankAccount.withdraw(accountHolder.getId(), withdrawn_amount);
        assertEquals(deposited_amount - withdrawn_amount - 2 * bankAccount.getFee(), bankAccount.getBalance());
    }



}
