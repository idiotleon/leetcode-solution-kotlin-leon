/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * Time Complexity:     O(`lenS`) / O(1) + O(1) ~ O(`lenS`) / O(1)
 * Space Complexity:    O(1)
 *
 *  `count += lo`
 *   [lo - 1, ..., hi] is the subarray, of the minimum length, ending at `hi`, which contains all three letters.
 *   The validity of the subarray can be extended to `idx == 0`.
 *
 * References:
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977/JavaC%2B%2BPython-Easy-and-Concise
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516955/Java-ELEGANT-No-Sliding-Window-EXPLAINED-(No-of-Sub-Strings-Ending-at-Curr-Index)/456665
 */
package com.zea7ot.leetcode.lvl3.lc1358

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun numberOfSubstrings(str: String): Int {
        // not used
        // val lenS = str.length

        // sanity check, not required
        // if (str.isEmpty()) return 0

        val lastIndexes = arrayOf(-1, -1, -1)

        var count = 0

        for (idx in str.indices) {
            lastIndexes[str[idx] - 'a'] = idx
            count += 1 + minOf(lastIndexes[0], lastIndexes[1], lastIndexes[2])
        }

        return count
    }
}