/**
 * https://leetcode.com/problems/ambiguous-coordinates/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/ambiguous-coordinates/discuss/123875/Really-clear-Java-code
 */
package com.an7one.leetcode.lvl3.lc0816

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    fun ambiguousCoordinates(s: String): List<String> {
        val str = s.substring(1, s.length - 1)
        val lenS = str.length

        val ans = mutableListOf<String>()
        for (idx in 1 until lenS) {
            val leftStrs = getAllowed(str.substring(0, idx))
            val rightStrs = getAllowed(str.substring(idx))

            for (leftStr in leftStrs) {
                for (rightStr in rightStrs) {
                    ans.add("($leftStr, $rightStr)")
                }
            }
        }

        return ans
    }

    private fun getAllowed(str: String): List<String> {
        val lenS = str.length
        val res = mutableListOf<String>()

        if (str[0] == '0' && str[lenS - 1] == '0') {
            if (lenS == 1) {
                res.add("0")
            }

            return res
        }

        if (str[0] == '0') {
            res.add("0.${str.substring(1)}")
            return res
        }

        if (str[lenS - 1] == '0') {
            res.add(str)
            return res
        }

        res.add(str)
        for (idx in 1 until lenS) {
            res.add("${str.substring(0, idx)}.${str.substring(idx)}")
        }

        return res
    }
}