package com.an7one.leetcode.lvl4.lc0025

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484597&idx=1&sn=c603f1752e33cb2701e371d84254aee2&chksm=9bd7fabdaca073abd512d8fff18016c9092ede45fed65c307852c65a2026d8568ee294563c78&scene=21#wechat_redirect
 */
@Suppress(UNUSED)
class SolutionApproach0ReverseRecursive {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null

        val start = head
        var end = head
        for (i in 0 until k) {
            if (end == null) return head
            end = end.next
        }

        val newHead = reverseInRange(start, end)

        start.next = reverseKGroup(end, k)
        return newHead
    }

    private fun reverseInRange(start: ListNode?, end: ListNode?): ListNode? {
        var prev: ListNode? = null
        var cur = start

        while (cur != null && cur != end) {
            val next = cur.next

            cur.next = prev
            prev = cur
            cur = next
        }

        return prev
    }
}