/**
 *
 */
package com.zea7ot.leetcode.lvl4.lc0187

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

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