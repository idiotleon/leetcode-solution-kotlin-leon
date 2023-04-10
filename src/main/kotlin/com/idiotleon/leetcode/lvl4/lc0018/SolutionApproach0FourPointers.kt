package com.idiotleon.leetcode.lvl4.lc0018

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/4sum/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA
 */
@Suppress(UNUSED)
class SolutionApproach0FourPointers {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        val nNums = nums.size
        nums.sort()

        for (i in 0 until nNums - 3) {
            if (i > 0 && nums[i - 1] == nums[i]) continue

            for (j in i + 1 until nNums - 2) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue

                var lo = j + 1
                var hi = nNums - 1
                while (lo < hi) {
                    val sum = nums[i] + nums[j] + nums[lo] + nums[hi]

                    when {
                        sum == target -> {
                            ans.add(listOf(nums[i], nums[j], nums[lo], nums[hi]))
                            ++lo
                            --hi

                            while (lo < hi && nums[lo - 1] == nums[lo]) {
                                ++lo
                            }

                            while (lo < hi && nums[hi] == nums[hi + 1]) {
                                --hi
                            }
                        }
                        sum < target -> ++lo
                        else -> --hi
                    }
                }
            }
        }

        return ans
    }
}