/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 * Time  Complexity:    O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0532

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findPairs(nums: IntArray, k: Int): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        nums.sort()

        val pool = hashSetOf<Int>()
        val ans = hashSetOf<Int>()

        for (num in nums) {
            if (pool.contains(num)) ans.add(num)

            pool.add(num + k)
        }

        return ans.size
    }
}