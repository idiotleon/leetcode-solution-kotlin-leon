package com.idiotleon.leetcode.lvl1.lc2558

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.math.sqrt

/**
 * @author: Leon
 * https://leetcode.com/problems/take-gifts-from-the-richest-pile/
 *
 * Time Complexity:     O(`nGifts` & lg(`nGifts`))
 * Space Complexity:    O(`nGifts`)
 *
 * Reference:
 * https://leetcode.com/problems/take-gifts-from-the-richest-pile/solutions/3143788/java-priority-queue-very-easy-intuitive/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days&difficulty=EASY
 */
@Suppress(UNUSED)
class Solution0MaxHeap {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        val nGifts = gifts.size
        val maxHeap = PriorityQueue<Int>(nGifts) { a, b -> b - a }
        for (gift in gifts) {
            maxHeap.offer(gift)
        }

        for (kCount in 0 until k) {
            val top = maxHeap.poll()
            maxHeap.offer(sqrt(top.toDouble()).toInt())
        }

        var sum: Long = 0
        while (maxHeap.isNotEmpty()) {
            sum += maxHeap.poll().toLong()
        }

        return sum
    }
}