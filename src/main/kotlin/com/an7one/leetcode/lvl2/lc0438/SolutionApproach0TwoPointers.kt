package com.an7one.leetcode.lvl2.lc0438

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

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
class SolutionApproach0TwoPointers {
    fun findAnagrams(s: String, p: String): List<Int> {
        val ans = mutableListOf<Int>()

        val lenS = s.length
        val lenP = p.length

        val freqs = IntArray(26) { 0 }
        for (ch in p) {
            ++freqs[ch - 'a']
        }

        var lo = 0
        var hi = 0
        var count = lenP

        while (hi < lenS) {
            if (freqs[s[hi] - 'a']-- > 0) {
                --count
            }

            if (count == 0) {
                ans.add(lo)
            }

            if (hi - lo + 1 == lenP) {
                if (freqs[s[lo] - 'a']++ >= 0) {
                    ++count
                }

                ++lo
            }

            ++hi
        }

        return ans
    }
}