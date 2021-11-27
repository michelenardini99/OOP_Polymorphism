package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount{
    
    private static final double TRANSACTION_FEE = 0.1;

    public RestrictedBankAccount(double balance, int usrID) {
        super(balance, usrID);
    }

    protected double computeFees() {
        return MANAGEMENT_FEE + (this.getNTransactions() * TRANSACTION_FEE);
    }

    @Override
    protected boolean isWithDrawAllowed(double amount) {
        return this.getBalance() >= amount;
    }

}
