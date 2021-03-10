/**
 * https://leetcode.com/problems/grumpy-bookstore-owner/
 *
 * Time Complexity:     O(`size`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/grumpy-bookstore-owner/discuss/299492/Java-one-pass-with-comments-sliding-window
 */
package com.an7one.leetcode.lvl2.lc1052

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, X: Int): Int {
        // not used
        // val size = customers.size

        var save = 0
        var totalCustomers = 0
        var totalGrumpy = 0
        var maxSave = 0

        for (idx in customers.indices) {
            totalCustomers += customers[idx]
            totalGrumpy += customers[idx] * grumpy[idx]
            save += customers[idx] * grumpy[idx]

            if (idx > X - 1) {
                save -= customers[idx - X] * grumpy[idx - X]
            }

            maxSave = maxOf(maxSave, save)
        }

        return totalCustomers - totalGrumpy + maxSave
    }
}