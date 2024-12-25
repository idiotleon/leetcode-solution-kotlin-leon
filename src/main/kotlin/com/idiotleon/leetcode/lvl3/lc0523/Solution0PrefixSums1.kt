package com.idiotleon.leetcode.lvl3.lc0523

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/continuous-subarray-sum/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * The remainder theorem:
 *  `(a + (n * k)) % k` is the same as `a % k`
 *
 * For the padding `0 to -1`:
 * 1. To return true when `runningSum % k == 0`
 * 2. To prevent early returns if `nums[0] % k == 0`
 *
 * Reference:
 * https://leetcode.com/problems/continuous-subarray-sum/solutions/99499/Java-O(n)-time-O(k)-space/comments/242302
 * https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space/103559
 * https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space
 */
@Suppress(UNUSED)
class Solution0PrefixSums1 {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val nNums = nums.size

        val modToIdx = HashMap<Int, Int>(nNums).also {
            it[0] = -1
        }

        // running sum
        var sum = 0

        for ((idx, num) in nums.withIndex()) {
            sum += num

            val mod = if (k != 0) {
                sum % k
            } else {
                sum
            }

            val prevIdx = modToIdx.getOrPut(mod) { idx }
            if (idx - prevIdx > 1) {
                return true
            }
        }

        return false
    }
}