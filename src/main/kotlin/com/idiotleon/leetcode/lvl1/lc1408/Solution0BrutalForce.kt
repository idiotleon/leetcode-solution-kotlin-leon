package com.idiotleon.leetcode.lvl1.lc1408

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/string-matching-in-an-array/
 *
 * Time Complexity:     O(`nWords` ^ 2)
 * Space Complexity:    O(1) / O(`nWords`)
 */
@Suppress(UNUSED)
class Solution0BrutalForce {
    fun stringMatching(words: Array<String>): List<String> {
        val ans = mutableListOf<String>()
        if (words.isEmpty()) {
            return ans
        }

        val nWords = words.size
        words.sortBy { it.length }

        for (lo in 0 until nWords - 1) {
            for (hi in lo + 1 until nWords) {
                if (words[hi].indexOf(words[lo]) >= 0) {
                    ans.add(words[lo])
                    break
                }
            }
        }

        return ans
    }
}