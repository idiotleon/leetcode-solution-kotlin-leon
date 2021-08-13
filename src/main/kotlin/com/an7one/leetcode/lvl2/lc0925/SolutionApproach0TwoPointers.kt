/**
 * https://leetcode.com/problems/long-pressed-name/
 *
 * Time Complexity:     O(`lenN`) + O(`lenT`) ~ O(`lenT`)
 * Space Complexity:    O(`lenN`) / O(1) + O(`lenT`) / O(1) ~ O(`lenT`) / O(1)
 */
package com.an7one.leetcode.lvl2.lc0925

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun isLongPressedName(name: String, typed: String): Boolean {
        val lenN = name.length
        val lenT = typed.length

        var idxN = 0
        var idxT = 0

        while (idxN < lenN && idxT < lenT) {
            if (name[idxN] == typed[idxT]) {
                ++idxN
                ++idxT
            } else {
                if (idxT == 0 || typed[idxT - 1] != typed[idxT])
                    return false

                ++idxT
            }
        }

        while (idxT < lenT && typed[idxT - 1] == typed[idxT]) {
            ++idxT
        }

        return idxN == lenN && idxT == lenT
    }
}