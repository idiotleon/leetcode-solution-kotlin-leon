/**
 * https://leetcode.com/problems/132-pattern/
 *
 * Time Complexity:     O(`nNums`), one pass
 * Space Complexity:    O(`nNums`)
 *
 * to maintain a strictly decreasing stack:
 *  1. the elements are values, instead of indexes
 *  2. the order of the elements is strictly decreasing,
 *      meaning that nce any bigger value is pushed into the stack, all smaller values are poped out,
 *      meaning that only smaller values can be pushed into the stack directly, without popping out any element
 *
 *
 * key step 1:
 *  elements recently popped out is guaranteed to be smaller than the elements in the stack,
 *  so the elements popped out become the candidates for s3,
 *  and the elements in the stack become the candidates for s2.
 *
 * key step 2:
 *  after key step 1 is satisfied, meaning there are candidates for both s2 and s3,
 *  once s1 can be found, it is the time to return true
 *
 * References:
 *  https://leetcode.com/problems/132-pattern/discuss/94071/Single-pass-C%2B%2B-O(n)-space-and-time-solution-(8-lines)-with-detailed-explanation.
 */
package com.an7one.leetcode.lvl4.lc0456

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun find132pattern(nums: IntArray): Boolean {
        // not used
        // val nNums = nums.size

        var pattern3 = Int.MIN_VALUE
        val stack = LinkedList<Int>()

        for (num in nums.reversed()) {
            if (num < pattern3) {
                return true
            } else {
                while (stack.isNotEmpty() && num > stack.peek()) {
                    pattern3 = stack.pop()
                }
            }

            stack.push(num)
        }

        return false
    }
}