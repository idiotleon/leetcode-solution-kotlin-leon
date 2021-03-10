/**
 * @author: Leon
 * https://leetcode.com/problems/single-row-keyboard/
 *
 * Time Complexity:     O(`lenK`)
 * Space Complexity:    O(26) ~ O(1)
 */
package com.an7one.leetcode.lvl1.lc1165

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun calculateTime(keyboard: String, word: String): Int {
        // not used
        // val lenK = keyboard.length

        val indexes = IntArray(26) { 0 }
        for (idx in keyboard.indices) {
            indexes[keyboard[idx] - 'a'] = idx
        }

        var cost = 0
        var prevIdx = 0
        for (ch in word) {
            val curIdx = indexes[ch - 'a']
            cost += abs(indexes[ch - 'a'] - prevIdx)
            prevIdx = curIdx
        }

        return cost
    }
}