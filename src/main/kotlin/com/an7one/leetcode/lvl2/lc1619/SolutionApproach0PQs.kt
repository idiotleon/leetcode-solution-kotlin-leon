/**
 * https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
 *
 * Time Complexity:     O(2 * `nNums` * lg(`nNums` / 20))
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/mean-of-array-after-removing-some-elements/discuss/899148/Java-2-PriorityQueues-O(2-*-n-*-lg(n20))
 */
package com.an7one.leetcode.lvl2.lc1619

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0PQs {
    fun trimMean(nums: IntArray): Double {
        val nNums = nums.size
        val trim = nNums / 20
        var sum = 0

        val hiMinHeap = PriorityQueue<Int>()
        val loMaxHeap = PriorityQueue<Int>(compareBy { -it })

        for (num in nums) {
            hiMinHeap.offer(num)

            if (hiMinHeap.size > trim) {
                loMaxHeap.offer(hiMinHeap.poll())

                if (loMaxHeap.size > trim) {
                    sum += loMaxHeap.poll()
                }
            }
        }

        return sum.toDouble() / (nNums - 2 * trim)
    }
}