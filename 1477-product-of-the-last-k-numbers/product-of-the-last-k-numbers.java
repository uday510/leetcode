class ProductOfNumbers {
        List<Integer> list;
        List<Integer> pf;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        pf = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
        if (pf.size() == 0)
            pf.add(num);
        else 
            pf.add(pf.getLast() * num);
        if (num == 0)
            pf = new ArrayList<>();
    }
    
    public int getProduct(int k) {
        if (pf.size() < k) {
            return 0;
        }
            
        if (k == pf.size()) 
            return pf.getLast();

        int product = pf.getLast() / pf.get(pf.size() - k - 1);

        return product;
    }
}
