package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

abstract class AbstractBankAccount implements BankAccount{
    
    public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;

    private double balance;
    private int nTransactions;
    private final int usrID;
    
    public AbstractBankAccount(double balance, int usrID) {
        this.balance = balance;
        this.usrID = usrID;
        this.nTransactions = 0;
    }
    
    private boolean checkUser(final int id) {
        return this.usrID == id;
    }

    private void incTransactions() {
        nTransactions++;
    }
    
    protected abstract double computeFees();
    
    public void computeManagementFees(int usrID) {
        final double feeAmount = this.computeFees();
        if (checkUser(usrID) && this.isWithDrawAllowed(feeAmount)) {
            balance -= feeAmount;
            this.resetTransactions();
        }
    }
    
    protected final void resetTransactions() {
        this.nTransactions = 0;
    }

    public void deposit(int usrID, double amount) {
        this.transactionOp(usrID, amount);
    }

    public void depositFromATM(int usrID, double amount) {
        this.deposit(usrID, amount - AbstractBankAccount.ATM_TRANSACTION_FEE);
    }

    public double getBalance() {
        return this.balance;
    }
    
    protected final void setBalance(final double amount) {
        this.balance = amount;
    }

    public int getNTransactions() {
        return this.nTransactions;
    }
    
    private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.incTransactions();
        }
    }
    
    protected abstract boolean isWithDrawAllowed(double amount);

    public void withdraw(int usrID, double amount) {
        if (isWithDrawAllowed(amount)) {
            this.transactionOp(usrID, -amount);
        }
    }

    public void withdrawFromATM(int usrID, double amount) {
        this.withdraw(usrID, amount + AbstractBankAccount.ATM_TRANSACTION_FEE);
    }

}
