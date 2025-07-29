public class ZigzagIterator {

    List<Integer> list;
    int idx;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<>();
        idx = 0;

        for (int i = 0, j = 0; i < v1.size() || j < v2.size();) {
            if (i < v1.size()) list.add(v1.get(i++));
            if (j < v2.size()) list.add(v2.get(j++));
        }
    }

    public int next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */