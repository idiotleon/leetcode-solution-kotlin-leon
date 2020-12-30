/**
 * https://leetcode.com/problems/sliding-window-median/
 *
 * Time Complexity:     O(`nNums` * lg(`k`))
 * Space Complexity:    O(`k`)
 *
 * References:
 *  https://leetcode.com/problems/sliding-window-median/discuss/96352/Never-create-max-heap-in-java-like-this...
 *  https://leetcode.com/problems/sliding-window-median/discuss/96340/O(n-log-k)-C++-using-multiset-and-updating-middle-iterator/356651
 */
package com.zea7ot.leetcode.lvl5.lc0480

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0PriorityQueue1 {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val nNums = nums.size
        val ans = DoubleArray(nNums - k + 1) { 0.0 }
        var idxAns = 0

        val lo = PriorityQueue<Int>(compareBy { -nums[it].toDouble() })
        val hi = PriorityQueue<Int>(compareBy { nums[it].toDouble() })

        for (idx in nums.indices) {
            lo.add(idx)
            hi.add(lo.poll())

            if (hi.size > lo.size) {
                lo.add(hi.poll())
            }

            if (lo.size + hi.size == k) {
                ans[idxAns] = if (lo.size == hi.size) {
                    nums[lo.peek()] / 2.0 + nums[hi.peek()] / 2.0
                } else {
                    nums[lo.peek()] / 1.0
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