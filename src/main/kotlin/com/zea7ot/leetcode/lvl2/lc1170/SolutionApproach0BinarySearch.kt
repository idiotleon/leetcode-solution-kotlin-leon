/**
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/discuss/366353/java-binary-search
 */
package com.zea7ot.leetcode.lvl2.lc1170

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
        val nQueries = queries.size
        val nWords = words.size

        val freqsQ = IntArray(nQueries) { 0 }.also {
            for (idx in queries.indices) {
                it[idx] = getFreq(queries[idx])
            }
        }

        val freqsW = IntArray(nWords) { 0 }.also {
            for (idx in words.indices) {
                it[idx] = getFreq(words[idx])
            }
        }

        freqsW.sort()

        val ans = IntArray(nQueries) { 0 }
        for (idxQ in freqsQ.indices) {
            var lo = 0
            var hi = nWords

            while (lo < hi) {
                val mid = lo + (hi - lo) / 2

                if (freqsW[mid] <= freqsQ[idxQ]) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }

            ans[idxQ] = nWords - lo
        }

        return ans
    }

    private fun getFreq(str: String): Int {
        val freqs = IntArray(26) { 0 }
        for (ch in str) ++freqs[ch - 'a']

        for (freq in freqs) {
            if (freq > 0) {
                return freq
            }
        }

        return 0
    }
}