/*
The size of the hash table is not determinate at the very beginning. If the total size of keys is too large (e.g. size >= capacity / 10), we should double the size of the hash table and rehash every keys. Say you have a hash table looks like below:

size=3, capacity=4

[null, 21, 14, null]
       ↓    ↓
       9   null
       ↓
      null
The hash function is:

int hashcode(int key, int capacity) {
    return key % capacity;
}
here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). We store them in the hash table by linked list.

rehashing this hash table, double the capacity, you will get:

size=3, capacity=8

index:   0    1    2    3     4    5    6   7
hash : [null, 9, null, null, null, 21, 14, null]
Given the original hash table, return the new hash table after rehashing .

Have you met this question in a real interview? Yes
Example
Given [null, 21->9->null, 14->null, null],

return [null, 9->null, null, null, null, 21->null, 14->null, null]

Note
For negative integer in hash table, the position can be calculated as follow:

C++/Java: if you directly calculate -4 % 3 you will get -1. You can use function: a % b = (a % b + b) % b to make it is a non negative integer.
Python: you can directly use -1 % 3, you will get 2 automatically.
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int oldSize = hashTable.length;
        int newSize = oldSize * 2;
        if (hashTable==null || oldSize==0) return null;
        ListNode[] res = new ListNode[newSize];
        for (int i=0; i<oldSize; i++) {
            if (hashTable[i] != null) {
                rehash(hashTable, res, i);
            }
        }
        return res;
    }
    
    public void rehash(ListNode[] hashTable, ListNode[] res, int i) {
        int newSize = res.length;
        ListNode cur = hashTable[i];
        while (cur != null) {
            int val = cur.val;
            int newPos = val>=0? val%newSize : (val%newSize+newSize)%newSize;
            if (res[newPos] == null) res[newPos] = new ListNode(val);
            else {
                ListNode temp = res[newPos];
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new ListNode(val);
            }
            cur = cur.next;
        }
    }
}

/*
http://www.cnphp6.com/archives/81202
http://www.cnblogs.com/lishiblog/p/4187959.html
http://www.cnblogs.com/EdwardLiu/p/4386374.html
https://richdalgo.wordpress.com/2015/01/28/lintcode-rehashing/
https://github.com/shogunsea/lintcode/blob/master/rehashing.java
*/