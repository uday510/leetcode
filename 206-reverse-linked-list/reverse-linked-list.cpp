/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        
        ListNode *curNode = head;
        ListNode *prevNode = nullptr;

        while (curNode != nullptr) {

            ListNode* nextNode = curNode->next;
            curNode->next = prevNode;

            prevNode = curNode;
            curNode = nextNode;
        }

        return prevNode;
    }
};

/**

input 1, 2, 3, 4, 5

engine {val:1, next: 2000}  -> {val:2, next: 3000} -> {val:3, next: 4000} -> {val:3, next: 5000} -> {val:4, next: null} tail
            1000                    2000                    30000                4000                   5000


output: => 5, 4, 3, 2, 1


null -> 

1, 2, 3, 4, 5

cur = node
next = cur.next
cur.next = prev

prev = cur
cur = next
------
1--->2--->3--->4--->5 -> null

                                    n
null <---1<----2<----3<--4<---5->nul
                                c
                              p    

prev = null

cur = 1
next = 2
cur.next = 

**/