/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`) / O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/range-sum-query-immutable/discuss/75192/Java-simple-O(n)-init-and-O(1)-query-solution/168353
 *  https://leetcode.com/problems/range-sum-query-immutable/discuss/75192/Java-simple-O(n)-init-and-O(1)-query-solution
 */
package com.idiotleon.leetcode.ood.lvl2.lc0303

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSum(nums: IntArray) {
    private val nNums = nums.size
    private val prefixSums = IntArray(nNums + 1) { 0 }.also {
        for (idx in nums.indices) {
            it[idx + 1] = it[idx] + nums[idx]
        }
    }

    fun sumRange(left: Int, right: Int) = prefixSums[right + 1] - prefixSums[left]
}