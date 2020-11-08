/**
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/discuss/855153/C++-Brute-Force/706740
 *  https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/discuss/855153/C%2B%2B-Brute-Force
 */
package com.zea7ot.leetcode.lvl3.lc1593

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun maxUniqueSplit(str: String): Int {
        val seen = HashSet<String>()
        return backtrack(0, str, seen)
    }

    private fun backtrack(startIdx: Int, str: String, seen: HashSet<String>): Int {
        val lenS = str.length
        if (startIdx == lenS) return 0

        var maxNum = 0
        var isEverSplit = false

        for (idx in startIdx until lenS) {
            val sub = str.substring(startIdx, idx + 1)
            if (seen.contains(sub)) continue
            isEverSplit = true
            seen.add(sub)
            maxNum = maxOf(maxNum, backtrack(idx + 1, str, seen))
            seen.remove(sub)
        }

        return if (isEverSplit) 1 + maxNum else Int.MIN_VALUE
    }
}