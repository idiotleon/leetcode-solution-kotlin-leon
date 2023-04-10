/**
 * @author: Leon
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 * Time  Complexity:    O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 */
package com.idiotleon.leetcode.lvl3.lc0532

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findPairs(nums: IntArray, k: Int): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        // not used
        // val nNums = nums.size

        nums.sort()

        val pool = HashSet<Int>()
        val ans = HashSet<Int>()

        for (num in nums) {
            if (pool.contains(num)) ans.add(num)

            pool.add(num + k)
        }

        return ans.size
    }
}