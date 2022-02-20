/**
 * @author: Leon
 * https://leetcode.com/problems/beautiful-arrangement/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/beautiful-arrangement/discuss/99711/Java-6ms-beats-98-back-tracking-(swap)-starting-from-the-back/807943
 *  https://leetcode.com/problems/beautiful-arrangement/discuss/99711/Java-6ms-beats-98-back-tracking-(swap)-starting-from-the-back
 */
package com.an7one.leetcode.lvl3.lc0526

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack1 {
    private var count = 0

    fun countArrangement(n: Int): Int {
        if (n == 0) return 0
        val nums = IntArray(n + 1) { idx -> idx }

        backtrack(n, nums)

        return count
    }

    private fun backtrack(idxStart: Int, nums: IntArray) {
        if (idxStart == 0) {
            ++count
            return
        }

        for (idx in idxStart downTo 1) {
            swap(idx, idxStart, nums)

            if (nums[idxStart] % idxStart == 0 || idxStart % nums[idxStart] == 0) {
                backtrack(idxStart - 1, nums)
            }

            swap(idx, idxStart, nums)
        }
    }

    private fun swap(i: Int, j: Int, nums: IntArray) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}