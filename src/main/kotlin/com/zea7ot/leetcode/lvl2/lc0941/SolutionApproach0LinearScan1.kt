/**
 * https://leetcode.com/problems/valid-mountain-array/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/valid-mountain-array/discuss/194900/C++JavaPython-Climb-Mountain/205147
 *  https://leetcode.com/problems/valid-mountain-array/discuss/194900/C%2B%2BJavaPython-Climb-Mountain
 */
package com.zea7ot.leetcode.lvl2.lc0941

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun validMountainArray(nums: IntArray): Boolean {
        val totalNums = nums.size
        if (totalNums <= 2 || nums[0] > nums[1]) return false

        var down = false
        for (idx in 2 until totalNums) {
            if (nums[idx - 1] > nums[idx]) down = true
            else if (nums[idx - 1] == nums[idx] || down) return false
        }

        return down
    }
}