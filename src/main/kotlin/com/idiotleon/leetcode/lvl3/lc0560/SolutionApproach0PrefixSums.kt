/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/301242/General-summary-of-what-kind-of-problem-can-cannot-solved-by-Two-Pointers
 *
 *  about `preifxSums.put(0, 1)`;
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-+-HashMap/416171
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-+-HashMap/238328
 */
package com.idiotleon.leetcode.lvl3.lc0560

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val sumToFreq = HashMap<Int, Int>()

        var count = 0
        var sum = 0

        for (num in nums) {
            sum += num

            if (sum == k)
                ++count

            sumToFreq[sum - k]?.let { count += it }
            sumToFreq[sum] = 1 + (sumToFreq[sum] ?: 0)
        }

        return count
    }
}