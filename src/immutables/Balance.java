package immutables;

/**
 * Created by tomi on 11/17/16.
 */
public final class Balance {

    private final long balanceAccount;


    public Balance(final long balanceAccount) {
        if (validate(balanceAccount)) {
            this.balanceAccount = 0;
        } else
            this.balanceAccount = balanceAccount;
    }

    private boolean validate(final long balanceAccount) {
        return balanceAccount >= 0;
    }

    public Balance withdraw(final long amount) {
        if (canWithdraw(amount)) {
            final long newAmount = this.balanceAccount - amount;
            return new Balance(newAmount);
        } else {
            throw new RuntimeException();
        }
    }

    private boolean canWithdraw(final long amount) {
        return balanceAccount >= amount;
    }


}
