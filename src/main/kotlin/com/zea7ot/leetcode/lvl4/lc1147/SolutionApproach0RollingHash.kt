/**
 * https://leetcode.com/problems/longest-chunked-palindrome-decomposition/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/longest-chunked-palindrome-decomposition/discuss/408184/Java-Rolling-Hash-Solution
 */
package com.zea7ot.leetcode.lvl4.lc1147

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0RollingHash {
    fun longestDecomposition(str: String): Int {
        val lenS = str.length

        var count = 0

        var lo = 0
        var hi = lenS - 1

        var hash1 = 0L
        var hash2 = 0L

        var base1 = 26L
        var base2 = 1L

        while (lo <= hi) {
            val ch1 = str[lo]
            val ch2 = str[hi]

            hash1 = hash1 * base1 + (ch1 - 'a' + 1)
            hash2 = hash2 + (ch2 - 'a' + 1) * base2
            base2 *= base1

            if (hash1 == hash2) {
                if (lo == hi) count += 1
                else count += 2

                hash1 = 0L
                hash2 = 0L
                base2 = 1L
            }

            ++lo
            --hi
        }

        if (hash1 != 0L) ++count

        return count
    }
}