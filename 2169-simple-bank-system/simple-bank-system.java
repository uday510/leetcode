class Bank {

    long[] balance;
    int n;

    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }
    
    public boolean transfer(int acc1, int acc2, long money) {
        if (!validAcc(acc1) || !validAcc(acc2)) return false;

        if (!validAmtForTransfer(acc1, money)) return false;

        balance[acc1 - 1] -= money;
        balance[acc2 - 1] += money;

        return true;
    }
    
    public boolean deposit(int acc, long money) {
        if (!validAcc(acc) || !validAmtForDeposit(money)) {
            return false;
        }

        balance[acc - 1] += money;

        return true;
    }
    
    public boolean withdraw(int acc, long money) {
        if (!validAcc(acc) || !validAmtForTransfer(acc, money)) return false;

        balance[acc - 1] -= money;

        return true;
    }
    
    private boolean validAcc(int acc) {
        return acc >= 0 && acc <= n;
    }

    private boolean validAmtForTransfer(int acc, long money) {
        return balance[acc - 1] >= money;
    }

    private boolean validAmtForDeposit(long money) {
        return money >= 0;
    }
    
}