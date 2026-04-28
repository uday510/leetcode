class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode();
        ListNode head = output;

        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;

        while (p1 != null || p2 != null || carry != 0) {
            int curSum = (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0) + carry;

            int newNodeVal = curSum % 10;

            ListNode newNode = new ListNode(newNodeVal);
            output.next = newNode;

            output = output.next;

            int curCarry = curSum / 10;
            carry = curCarry;

            p1 = (p1 != null ? p1.next : null);
            p2 = (p2 != null ? p2.next : null);
        }


        return head.next;
    }
}

/**

input: 
l1 = 2 -> 4 -> 3 -> NULL
l2 = 4 -> 6 -> 4 -> NULL

output: 
6 -> 0 -> 8 -> NULL

p1 = NULL
p2 = NULL

         head                 |  
output = [] -> [6] ->[0] -> [8]
carry = 0

curSum = (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0) + carry 
        = 2 + 4 + 0 => 6
        = 4 + 6 + 0 => 10
        = 3 + 4 + 1 => 8

newNodeVal = curSum % 10
           = 6 % 10 = 6
           = 10 % 10 = 0
           = 8 % 10 = 8

newNode = new Node(newNodeVal)

output.next = newNode
output = output.next

p1 = (p1 != null ? p1.next : null)
p2 = (p2 != null ? p2.next : null)

curCarry = curSum / 10
      = 6 / 10 => 0
      = 10 / 10 => 1
      = 8 / 10 => 0

carry = curCarry

*/