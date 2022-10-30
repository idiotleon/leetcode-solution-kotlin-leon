package com.an7one.leetcode.lvl3.lc0779.withBit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/k-th-symbol-in-grammar/discuss/113736/PythonJavaC%2B%2B-Easy-1-line-Solution-with-detailed-explanation
 */
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