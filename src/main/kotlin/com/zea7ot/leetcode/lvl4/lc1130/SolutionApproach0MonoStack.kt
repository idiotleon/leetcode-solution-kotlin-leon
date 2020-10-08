/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
 */
package com.zea7ot.leetcode.lvl4.lc1130

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun mctFromLeafValues(nums: IntArray): Int {

        // not used
        // val totalNums = nums.size

        var minCost = 0

        val stack = LinkedList<Int>()
        stack.push(Int.MAX_VALUE)

        for (num in nums) {
            while (stack.peek() <= num) {
                val mid = stack.pop()
                minCost += mid * minOf(stack.peek(), num)
            }

            stack.push(num)
        }

        while (stack.size > 2) {
            minCost += stack.pop() * stack.peek()
        }

        return minCost
    }
}