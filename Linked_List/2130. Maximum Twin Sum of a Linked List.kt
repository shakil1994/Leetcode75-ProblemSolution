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
    fun pairSum(head: ListNode?): Int {
        var slow = head
        var fast = head

        while (fast != null && fast.next != null && fast.next!!.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }

        val nextNode = slow?.next
        slow?.next = null
        val reversed = reverse(nextNode)

        var temp = reversed
        var temp1 = temp
        var ans = 0

        var current = head

        while (current != null && temp != null) {
            ans = maxOf(current.`val` + temp.`val`, ans)
            current = current.next
            temp = temp.next
        }

        return ans
    }

    fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head

        while (current != null) {
            val nextNode = current.next
            current.next = prev
            prev = current
            current = nextNode
        }

        return prev
    }
}