/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
 
class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head == null || head.next == null){
            return null
        }

        var slow = head
        var fast = head
        var prev: ListNode? = null

        while(fast != null && fast.next != null){
            prev = slow
            slow = slow?.next
            fast = fast.next?.next
        }
        prev?.next = slow?.next

        return head
    }
}