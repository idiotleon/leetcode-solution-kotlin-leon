package com.idiotleon.leetcode.lvl2.lc0408

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/valid-word-abbreviation/
 *
 * Time Complexity:     O(`lenW` + `lenAb`) ~ O(`lenW`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0TwoPointers {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        val lenW = word.length
        val lenAb = abbr.length

        var number = 0
        var idxW = 0
        var idxAb = 0

        while (idxW < lenW && idxAb < lenAb) {
            if (abbr[idxAb] in '0'..'9') {
                number = number * 10 + (abbr[idxAb] - '0')
                if (number == 0) {
                    return false
                }
                ++idxAb
            } else {
                idxW += number
                if (idxW >= lenW || word[idxW] != abbr[idxAb]) {
                    return false
                }
                number = 0
                ++idxW
                ++idxAb
            }
        }

        idxW += number

        return idxW == lenW && idxAb == lenAb
    }
}