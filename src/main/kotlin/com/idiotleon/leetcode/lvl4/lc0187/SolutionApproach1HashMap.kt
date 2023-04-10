package com.idiotleon.leetcode.lvl4.lc0187

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class SolutionApproach1HashMap {
    private companion object {
        private const val LEN = 10
    }

    fun findRepeatedDnaSequences(s: String): List<String> {
        val lenS = s.length

        val ans = arrayListOf<String>()

        val freqs = HashMap<String, Int>()

        var idx = 0
        while (idx + LEN - 1 < lenS) {
            val sub = s.substring(idx, idx + LEN)
            freqs[sub] = (freqs[sub] ?: 0) + 1
            freqs[sub]?.let {
                if (it == 2) { // to add eligible substrings only ONCE
                    ans.add(sub)
                }
            }

            ++idx
        }

        return ans
    }
}