package com.idiotleon.leetcode.lvl4.lc2772

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero/solutions/3739101/java-c-python-greedy-sliding-window/
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    fun checkArray(nums: IntArray, k: Int): Boolean {
        val nNums = nums.size
        var cur = 0
        for (idx in 0 until nNums) {
            if (cur > nums[idx]) {
                return false
            }
            nums[idx] -= cur
            cur += nums[idx]
            if (idx >= k - 1) {
                cur -= nums[idx - k + 1]
            }
        }
        return cur == 0
    }
}