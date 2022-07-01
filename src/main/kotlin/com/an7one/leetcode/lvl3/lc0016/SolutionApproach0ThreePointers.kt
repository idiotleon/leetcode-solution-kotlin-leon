package com.an7one.leetcode.lvl3.lc0016

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/3sum-closest/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference/9007
 * https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference
 */
@Suppress(UNUSED)
class SolutionApproach0ThreePointers {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val nNums = nums.size
        nums.sort()

        var closest = nums[0] + nums[1] + nums[nNums - 1]

        for (idx in nums.indices) {
            var lo = idx + 1
            var hi = nNums - 1

            while (lo < hi) {
                val sum = nums[idx] + nums[lo] + nums[hi]

                when {
                    sum < target -> {
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            ++lo
                        }
                        ++lo
                    }
                    sum > target -> {
                        while (lo < hi && nums[hi - 1] == nums[hi]) {
                            --hi
                        }
                        --hi
                    }
                    else -> return sum
                }

                if (abs(target - sum) < abs(target - closest)) closest = sum
            }
        }

        return closest
    }
}