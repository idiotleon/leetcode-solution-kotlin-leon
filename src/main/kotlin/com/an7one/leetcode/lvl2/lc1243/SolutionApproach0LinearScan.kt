/**
 * https://leetcode.com/problems/array-transformation/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/array-transformation/discuss/426804/C%2B%2B-space-O(1)-solution
 */
package com.an7one.leetcode.lvl2.lc1243

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun transformArray(arr: IntArray): List<Int> {
        val nNums = arr.size
        val nums = arr.toMutableList()
        if (nNums < 3) return nums

        var changed = true

        while (changed) {
            changed = false

            var prev = nums[0]
            var cur = nums[1]
            var next = nums[2]

            for (idx in 1 until nNums - 1) {
                if (cur < prev && cur < next) {
                    nums[idx] = nums[idx] + 1
                    changed = true
                } else if (cur > prev && cur > next) {
                    nums[idx] = nums[idx] - 1
                    changed = true
                }

                if (idx == nNums - 2) break
                prev = cur
                cur = next
                next = nums[idx + 2]
            }
        }

        return nums
    }
}