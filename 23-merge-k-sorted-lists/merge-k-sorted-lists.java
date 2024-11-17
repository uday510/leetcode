class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        while (!pq.isEmpty()) {
            ListNode list = pq.poll();

            tail.next = list;
            tail = tail.next;

            if (list.next != null) {
                pq.offer(list.next);
            }
        }

        return dummy.next;
    }
}