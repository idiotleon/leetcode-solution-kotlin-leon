/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L) ~ O(1)
 *
 *  `res += lo`
 *   [i - 1, ..., j] is the subarray, of the minimum length, ending at `j`, which contains all three letters.
 *   The validity of the subarray can be extended to `idx == 0`.
 *
 * References:
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977/JavaC%2B%2BPython-Easy-and-Concise
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977/JavaC++Python-Easy-and-Concise/656186
 */
package com.zea7ot.leetcode.lvl3.lc1358

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun numberOfSubstrings(str: String): Int {
        // sanity check, not required
        // if (str.isEmpty()) return 0

        val lenS = str.length

        val freqs = intArrayOf(0, 0, 0)

        var lo = 0
        var hi = 0
        var count = 0

        while (hi < lenS) {
            ++freqs[str[hi] - 'a']

            while (containsAll(freqs)) {
                --freqs[str[lo] - 'a']
                ++lo
            }

            count += lo
            ++hi
        }

        return count
    }

    private fun containsAll(freqs: IntArray): Boolean {
        return freqs[0] > 0 && freqs[1] > 0 && freqs[2] > 0
    }
}