/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * Time Complexity:     O(L) / O(1) + O(1) ~ O(L) / O(1)
 * Space Complexity:    O(1)
 *
 *  `res += lo`
 *   [i - 1, ..., j] is the subarray, of the minimum length, ending at `j`, which contains all three letters.
 *   The validity of the subarray can be extended to `idx == 0`.
 *
 * References:
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977/JavaC%2B%2BPython-Easy-and-Concise
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516955/Java-ELEGANT-No-Sliding-Window-EXPLAINED-(No-of-Sub-Strings-Ending-at-Curr-Index)/456665
 */
package com.zea7ot.leetcode.lvl3.lc1358

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun numberOfSubstrings(s: String): Int {
        // sanity check
        if (s.isEmpty()) return 0

        val lenS = s.length

        val lastIndexes = arrayOf(-1, -1, -1)

        var count = 0

        for (i in 0 until lenS) {
            lastIndexes[s[i] - 'a'] = i
            count += 1 + minOf(lastIndexes[0], lastIndexes[1], lastIndexes[2])
        }

        return count
    }
}