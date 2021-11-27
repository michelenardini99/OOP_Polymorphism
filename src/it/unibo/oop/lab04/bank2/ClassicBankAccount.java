package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount{

    public ClassicBankAccount(double balance, int usrID) {
        super(balance, usrID);
    }

    @Override
    protected double computeFees() {
        return AbstractBankAccount.MANAGEMENT_FEE;
    }

    @Override
    protected boolean isWithDrawAllowed(double amount) {
        return true;
    }

}
