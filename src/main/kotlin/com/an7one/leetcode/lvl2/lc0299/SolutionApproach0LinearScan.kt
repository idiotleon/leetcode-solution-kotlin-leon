package com.an7one.leetcode.lvl2.lc0299

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/bulls-and-cows/
 *
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(`L`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/bulls-and-cows/discuss/74621/One-pass-Java-solution
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun getHint(secret: String, guess: String): String {
        // sanity check
        if (secret.isEmpty() || guess.isEmpty() || secret.length != guess.length)
            return ""

        val len = secret.length

        var bulls = 0
        var cows = 0

        val freqs = IntArray(10)

        for (i in 0 until len) {
            when {
                secret[i] == guess[i] -> ++bulls
                else -> {
                    if (freqs[secret[i] - '0']++ < 0) ++cows
                    if (freqs[guess[i] - '0']-- > 0) ++cows
                }
            }
        }

        return bulls.toString() + "A" + cows.toString() + "B"
    }
}