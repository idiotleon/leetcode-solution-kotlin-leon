/**
 * https://leetcode.com/problems/remove-9/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/remove-9/discuss/106561/One-Line-Java-Solution
 *  https://leetcode.com/problems/remove-9/discuss/106578/Share-my-O(logn)-C%2B%2B-solution-with-thinking-process-and-explanation
 *  https://leetcode.com/problems/remove-9/discuss/106573/Alternative-solution-applicable-to-the-general-case
 */
package com.idiotleon.leetcode.lvl4.lc0660

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0RadixSort {
    fun newInteger(n: Int): Int {
        var n = n
        var ans = 0
        var base = 1

        while (n > 0) {
            ans += n % 9 * base
            n /= 9
            base *= 10
        }

        return ans
    }
}