/**
 * https://leetcode.com/problems/build-array-from-permutation/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/build-array-from-permutation/discuss/1315705/Python-C++-and-Java-Solution-for-both-O(n)-and-O(1)-space-complexity./998378
 *  https://leetcode.com/problems/build-array-from-permutation/discuss/1315705/Python-C%2B%2B-and-Java-Solution-for-both-O(n)-and-O(1)-space-complexity.
 */
package com.an7one.leetcode.lvl2.lc1920

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun buildArray(nums: IntArray): IntArray {
        val nNums = nums.size

        for (idx in nums.indices) {
            nums[idx] += nNums * (nums[nums[idx]] % nNums)
        }

        for (idx in nums.indices) {
            nums[idx] = nums[idx] / nNums
        }

        return nums
    }
}