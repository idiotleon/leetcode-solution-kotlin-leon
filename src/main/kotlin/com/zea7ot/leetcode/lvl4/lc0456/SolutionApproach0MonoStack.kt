/**
 * https://leetcode.com/problems/132-pattern/
 *
 * Time Complexity:     O(`totalNums`), one pass
 * Space Complexity:    O(`totalNums`)
 *
 * to maintain a strickly decreasing stack:
 *  1. the elements are values, instead of indexes
 *  2. the order of the elements is strictly decreasing,
 *      meaning that nce any bigger value is pushed into the stack, all smaller values are poped out,
 *      meaning that only smaller values can be pushed into the stack directly, without popping out any element
 *
 * key step 1:
 *  elements recently popped out is guaranteed to be smaller than the elements in the stack,
 *  so the elements popped out become the candidates for s3,
 *  and the elements in the stack become the candidates for s2.
 * key step 2:
 *  after key step 1 is satified, meaning there are candidates for both s2 and s3,
 *  once s1 can be found, it is the time to return true
 */
package com.zea7ot.leetcode.lvl4.lc0456

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun find132pattern(nums: IntArray): Boolean {
        val totalNums = nums.size
        var s3 = Int.MIN_VALUE
        val stack = LinkedList<Int>()

        for (idx in totalNums - 1 downTo 0) {
            if (nums[idx] < s3) {
                return true
            } else {
                while (stack.isNotEmpty() && nums[idx] > stack.peek()) {
                    s3 = stack.pop()
                }
            }

            stack.push(nums[idx])
        }

        return false
    }
}