package com.idiotleon.leetcode.lvl3.lc2381

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/shifting-letters-ii/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val lenS = s.length
        val chs = s.toCharArray()
        val diffs = IntArray(lenS) { 0 }.also {
            for ((start, end, direction) in shifts) {
                when (direction) {
                    0 -> {
                        --it[start]
                        if (end + 1 < lenS) {
                            ++it[end + 1]
                        }
                    }

                    1 -> {
                        ++it[start]
                        if (end + 1 < lenS) {
                            --it[end + 1]
                        }
                    }

                    else -> {

                    }
                }
            }
        }

        var countOfShifts = 0

        for (idx in 0 until lenS) {
            countOfShifts = (countOfShifts + diffs[idx]) % 26
            if (countOfShifts < 0) {
                countOfShifts += 26
            }

            val shiftedChar = 'a' + (chs[idx] - 'a' + countOfShifts) % 26
            chs[idx] = shiftedChar
        }

        return String(chs)
    }
}