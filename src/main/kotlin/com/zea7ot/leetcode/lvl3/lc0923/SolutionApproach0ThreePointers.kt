/**
 * https://leetcode.com/problems/3sum-with-multiplicity/
 *
 * Time Complexity:     O(`totalNums` * lg(`totalNums`)) + O(`totalNums` ^ 2) ~ O(`totalNums` ^ 2)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/3sum-with-multiplicity/discuss/181098/JavaPython-3-O(n2)-and-O(n-%2B-101-2)-codes-w-brief-anslysis.
 */
package com.zea7ot.leetcode.lvl3.lc0923

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ThreePointers {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun threeSumMulti(nums: IntArray, target: Int): Int {
        val totalNums = nums.size
        nums.sort()

        var count = 0

        for (idx in nums.indices) {
            var lo = idx + 1
            var hi = totalNums - 1

            while (lo < hi) {
                val sum = nums[lo] + nums[hi] + nums[idx]

                when {
                    sum > target -> --hi
                    sum < target -> ++lo
                    else -> {
                        var dupLo = 0
                        while (lo + dupLo < hi && nums[lo] == nums[lo + dupLo]) {
                            ++dupLo
                        }

                        var dupHi = 0
                        while (lo + dupLo <= hi - dupHi && nums[hi - dupHi] == nums[hi]) {
                            ++dupHi
                        }

                        // if nums[lo, hi](both ends inclusive) all are the same,
                        // there are C(hi - lo + 1, 2) combinations,
                        // otherwise, there are (`dupLo` * `dupHi`) cases
                        count += (if (nums[lo] == nums[hi]) (hi - lo + 1) * (hi - lo) / 2 else dupLo * dupHi) % MOD
                        // cannot be skipped
                        count %= MOD

                        lo += dupLo
                        hi -= dupHi
                    }
                }
            }
        }

        return count
    }
}