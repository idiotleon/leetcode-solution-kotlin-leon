package com.idiotleon.leetcode.lvl2.lc0438

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Time Complexity:     O(lenS) + O(lenT) ~ O(lenS)
 * Space Complexity:    O(1) / O(lenS)
 *
 * References:
 *  https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92015/ShortestConcise-JAVA-O(n)-Sliding-Window-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers1 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val ans = mutableListOf<Int>()
        // sanity check
        if (s.isEmpty() || p.isEmpty() || s.length < p.length) return ans

        val lenS = s.length
        val lenP = p.length
        val hash = IntArray(26)
        for (ch in p) {
            ++hash[ch - 'a']
        }

        var lo = 0
        var hi = 0
        var count = lenP

        while (hi < lenS) {
            if (hash[s[hi++] - 'a']-- > 0) --count

            if (count == 0) {
                ans.add(lo)
            }

            if (hi - lo == lenP && hash[s[lo++] - 'a']++ >= 0) ++count
        }

        return ans
    }
}