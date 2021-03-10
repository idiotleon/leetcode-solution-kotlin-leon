package com.an7one.leetcode.util.dataStructure.linkedList

data class ListNode(var `val`: Int, var next: ListNode? = null) {

    // util method for testing purpose only
    companion object {
        fun constructLinkedList(nums: IntArray): ListNode? {
            if (nums.isEmpty()) return null
            val dummyHead = ListNode(-1)

            var prev = dummyHead
            for (num in nums) {
                val nextNode = ListNode(num)
                prev.next = nextNode
                prev = prev.next!!
            }

            return dummyHead.next
        }
    }
}