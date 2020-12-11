/**
 * https://leetcode.com/problems/corporate-flight-bookings/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487011&idx=1&sn=5e2b00c1c736fd7afbf3ed35edc4aeec&chksm=9bd7f02baca0793d569a9633cc14117e708ccc9eb41b7f0add430ea78f22e4f2443f421c6841&scene=178&cur_album_id=1318883740306948097#rd
 */
package com.zea7ot.leetcode.lvl3.lc1109

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DiffArray {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val ans = IntArray(n) { 0 }

        val diffArray = DiffArray(ans)

        for (booking in bookings) {
            val (start, end, value) = booking

            diffArray.increment(start - 1, end - 1, value)
        }

        return diffArray.getResult()
    }

    private class DiffArray(nums: IntArray) {
        private val nNums = nums.size
        private val diffs = IntArray(nNums) { 0 }

        init {
            diffs[0] = nums[0]

            for (idx in 1 until nNums) {
                diffs[idx] = nums[idx] - nums[idx - 1]
            }
        }

        fun increment(lo: Int, hi: Int, value: Int) {
            diffs[lo] += value
            if (hi + 1 < nNums) {
                diffs[hi + 1] -= value
            }
        }

        fun getResult(): IntArray {
            val res = IntArray(nNums) { 0 }
            res[0] = diffs[0]

            for (idx in 1 until nNums) {
                res[idx] = res[idx - 1] + diffs[idx]
            }

            return res
        }
    }
}