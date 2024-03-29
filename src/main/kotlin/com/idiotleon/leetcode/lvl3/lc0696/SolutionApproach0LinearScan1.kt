/**
 * https://leetcode.com/problems/count-binary-substrings/discuss/108625/JavaC%2B%2BPython-Easy-and-Concise-with-Explanation
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 *
 * First, to count the number of 1 or 0 grouped consecutively.
 *  For example "0110001111" will be [1, 2, 3, 4].
 *
 * Second, for any possible substrings with 1 and 0 grouped consecutively,
 *  the number of valid substring will be the minimum number of 0 and 1.
 *  For example "0001111", will be min(3, 4) = 3, ("01", "0011", "000111")
 *
 *
 * References:
 *  https://leetcode.com/problems/count-binary-substrings/discuss/108625/JavaC%2B%2BPython-Easy-and-Concise-with-Explanation
 */
package com.idiotleon.leetcode.lvl3.lc0696

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun countBinarySubstrings(str: String): Int {
        // sanity check
        if (str.isEmpty()) return 0

        val lenS = str.length

        var prev = 0
        var cur = 1
        var count = 0

        for (idx in 1 until lenS) {
            if (str[idx - 1] == str[idx]) {
                ++cur
            } else {
                count += minOf(cur, prev)
                prev = cur
                cur = 1
            }
        }

        return count + minOf(cur, prev)
    }
}