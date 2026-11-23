class ProductOfNumbers {

    List<Integer> l;
    List<Integer> p;
    public ProductOfNumbers() {
        l = new ArrayList<>();
        p = new ArrayList<>(List.of(1));
    }
    
    public void add(int a) {
        if (a == 0) {
            p = new ArrayList<>();
            p.add(1);
            return;
        }

        p.add(p.getLast() * a);
    }
    
    public int getProduct(int k) {
        int n = p.size();
        if (k >= n) return 0;
        return p.getLast() / p.get(n - 1 - k);
    }
}
