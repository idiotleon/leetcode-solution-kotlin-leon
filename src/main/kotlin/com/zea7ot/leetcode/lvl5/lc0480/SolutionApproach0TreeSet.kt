/**
 * https://leetcode.com/problems/sliding-window-median/
 *
 * Time Complexity:     O(`nNums` * lg(`k`))
 * Space Complexity:    O(`k`)
 *
 * to insert indexes, instead of values, in the TreeSet, is for the duplicates
 *
 * References:
 *  https://leetcode.com/problems/sliding-window-median/discuss/96340/O(n-log-k)-C++-using-multiset-and-updating-middle-iterator/653543
 *  https://leetcode.com/problems/sliding-window-median/discuss/96340/O(n-log-k)-C%2B%2B-using-multiset-and-updating-middle-iterator
 */
package com.zea7ot.leetcode.lvl5.lc0480

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0TreeSet {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val nNums = nums.size
        val ans = DoubleArray(nNums - k + 1)
        var idxAns = 0

        val lo = TreeSet<Int>(compareBy({ nums[it] }, { it }))
        val hi = TreeSet<Int>(compareBy({ nums[it] }, { it }))

        for (idx in nums.indices) {
            lo.add(idx)
            hi.add(lo.pollLast()!!)

            if (hi.size > lo.size) {
                lo.add(hi.pollFirst()!!)
            }

            if (lo.size + hi.size == k) {
                ans[idxAns] = if (lo.size == hi.size) {
                    nums[lo.last()] / 2.0 + nums[hi.first()] / 2.0
                } else {
                    nums[lo.last()] / 1.0
                }

                if (!lo.remove(idxAns)) {
                    hi.remove(idxAns)
                }

                ++idxAns
            }
        }

        return ans
    }
}