/**
 * https://leetcode.com/problems/array-transformation/
 *
 * Time Complexity:     O()
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/array-transformation/discuss/418885/JavaPython-3-Bruteforce
 */
package com.an7one.leetcode.lvl2.lc1243

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun transformArray(arr: IntArray): List<Int> {
        val nNums = arr.size
        val nums = arr.toMutableList()
        if (nNums < 3) return nums

        var ans = MutableList(nNums) { 0 }

        while (ans != nums) {
            ans = nums.toMutableList()

            for (idx in 1 until nNums - 1) {
                if (ans[idx - 1] < ans[idx] && ans[idx] > ans[idx + 1]) {
                    --nums[idx]
                } else if (ans[idx - 1] > ans[idx] && ans[idx] < ans[idx + 1]) {
                    ++nums[idx]
                }
            }
        }

        return ans
    }
}