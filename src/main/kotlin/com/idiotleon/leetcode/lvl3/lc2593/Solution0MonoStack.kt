package com.idiotleon.leetcode.lvl3.lc2593

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
 *
 * Time Complexity:     O(`nNum`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/solutions/6141171/stack-sorting-heap-3-approach-in-3-languages/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days&difficulty=MEDIUM
 */
@Suppress(UNUSED)
class Solution0MonoStack {
    fun findScore(nums: IntArray): Long {
        val nNums = nums.size

        var score: Long = 0

        val stack = ArrayDeque<Int>(nNums)

        for (num in nums) {
            if (stack.isNotEmpty() && num >= stack.last()) {
                var skip = false
                while (stack.isNotEmpty()) {
                    val top = stack.removeLast()
                    if (!skip) {
                        score += top.toLong()
                    }
                    skip = !skip;
                }
                continue
            }
            stack.addLast(num)
        }

        var skip = false
        while (stack.isNotEmpty()) {
            val top = stack.removeLast()
            if (!skip) {
                score += top.toLong()
            }
            skip = !skip
        }

        return score
    }
}