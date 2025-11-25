class Bank {

    long[] b;
    int n;

    public Bank(long[] b) {
        this.b = b;
        this.n = b.length;
    }
    
    public boolean transfer(int a1, int a2, long m) {
        if (!validA(a1) || !validA(a2)) return false;

        if (!validM(m) || b[a1 - 1] < m) return false;

        b[a1 - 1] -= m;
        b[a2 - 1] += m;

        return true;
    }
    
    public boolean deposit(int a, long m) {
        if (!validA(a) || !validM(m)) return false;

        b[a - 1] += m;
        return true;
    }
    
    public boolean withdraw(int a, long m) {
        if (!validA(a) || !validM(m)) return false;
        if (b[a - 1] < m) return false;

        b[a - 1] -= m;
        return true;
    }

    private boolean validA(int a) {
        return a >= 1 && a <= n;
    }

    private boolean validM(long m) {
        return m >= 0;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */