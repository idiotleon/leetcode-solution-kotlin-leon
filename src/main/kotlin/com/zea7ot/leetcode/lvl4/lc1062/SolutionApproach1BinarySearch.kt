/**
 * https://leetcode.com/problems/longest-repeating-substring/
 *
 * Time Complexity:     O((L ^ 2) * lg(L))
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/longest-repeating-substring/discuss/304399/Java-O(log(n)*n2)-Binary-Search-Solution
 */
package com.zea7ot.leetcode.lvl4.lc1062

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach1BinarySearch {
    fun longestRepeatingSubstring(str: String): Int {
        val lenS = str.length
        var lo = 0
        var hi = lenS
        var longest = 0

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (canMakeIt(str, mid)) {
                // this trick, instead of returning `lo`, is marvelous
                longest = maxOf(longest, mid)
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return longest
    }

    private fun canMakeIt(str: String, len: Int): Boolean {
        val lenS = str.length
        val seen = HashSet<String>()
        var idx = 0
        while (idx + len <= lenS) {
            val sub = str.substring(idx, idx + len)
            if (seen.contains(sub)) {
                return true
            }
            seen.add(sub)

            ++idx
        }

        return false
    }
}