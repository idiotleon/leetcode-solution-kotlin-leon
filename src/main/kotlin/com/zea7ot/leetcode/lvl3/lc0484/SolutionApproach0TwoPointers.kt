/**
 * https://leetcode.com/problems/find-permutation/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/find-permutation/discuss/96613/Java-O(n)-clean-solution-easy-to-understand/101222
 */
package com.zea7ot.leetcode.lvl3.lc0484

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    private companion object {
        private const val DECREASING = 'D'
    }

    fun findPermutation(s: String): IntArray {
        val lenS = s.length
        val ans = IntArray(lenS + 1) { idx -> idx + 1 }

        var lo = 0
        while (lo < lenS) {
            var hi = lo
            while (hi < lenS && s[hi] == DECREASING) {
                ++hi
            }

            reverse(lo, hi, ans)
            lo = hi + 1

            // or equivalently
            // for(k in hi - lo downTo 0){
            //     ans[lo++] = hi + 1
            //     --hi
            // }
        }

        return ans
    }

    private fun reverse(low: Int, high: Int, nums: IntArray) {
        var lo = low
        var hi = high

        while (lo < hi) {
            val temp = nums[lo]
            nums[lo] = nums[hi]
            nums[hi] = temp

            ++lo
            --hi
        }
    }
}