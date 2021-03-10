/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 */
package com.an7one.leetcode.lvl3.lc1673

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val nNums = nums.size
        val limit = nNums - k

        val stack = LinkedList<Int>()
        var count = 0

        for (num in nums) {
            while (stack.isNotEmpty() && count < limit && stack.peek() > num) {
                stack.pop()
                ++count
            }

            stack.push(num)
        }

        while (stack.size > k) stack.pop()

        val ans = IntArray(k) { 0 }
        var idx = k - 1
        while (stack.isNotEmpty()) {
            ans[idx--] = stack.pop()
        }
        return ans
    }
}