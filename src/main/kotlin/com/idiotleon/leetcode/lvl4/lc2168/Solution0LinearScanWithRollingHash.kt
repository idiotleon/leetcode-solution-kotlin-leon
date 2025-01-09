package com.idiotleon.leetcode.lvl4.lc2168

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/unique-substrings-with-equal-digit-frequency/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/unique-substrings-with-equal-digit-frequency/solutions/1759403/java-rolling-hash-13-lines-trie/?envType=weekly-question&envId=2025-01-08
 */
@Suppress(UNUSED)
class Solution0LinearScanWithRollingHash {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun equalDigitFrequency(s: String): Int {
        val lenS = s.length

        val hashes = HashSet<Int>()
        for (lo in 0 until lenS) {
            val freqs = IntArray(10) { 0 }
            var unique = 0
            var maxCount = 0
            var hash = 0
            for (hi in lo until lenS) {
                val digit = s[hi] - '0'
                if (freqs[digit] == 0) {
                    ++unique
                }
                ++freqs[digit]
                maxCount = maxOf(maxCount, freqs[digit])
                hash = (hash * 11 + digit + 1) % MOD
                if (maxCount * unique == hi - lo + 1) {
                    hashes.add(hash)
                }
            }
        }

        return hashes.size
    }
}