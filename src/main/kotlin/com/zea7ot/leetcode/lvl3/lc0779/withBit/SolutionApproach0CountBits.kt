/**
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/k-th-symbol-in-grammar/discuss/113736/PythonJavaC%2B%2B-Easy-1-line-Solution-with-detailed-explanation
 */
package com.zea7ot.leetcode.lvl3.lc0779.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0CountBits {
    fun kthGrammar(N: Int, K: Int): Int {
        var count = 0

        var k = K - 1
        while (k > 0) {
            ++count
            k = k and (k - 1)
        }

        return count and 1
    }
}