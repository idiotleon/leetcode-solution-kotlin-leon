/**
 * https://leetcode.com/problems/minimum-unique-word-abbreviation/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/minimum-unique-word-abbreviation/discuss/89880/C++-Bit-Manipulation-+-DFS-solution/94420
 *  https://leetcode.com/problems/minimum-unique-word-abbreviation/discuss/89880/C%2B%2B-Bit-Manipulation-%2B-DFS-solution
 */
package com.zea7ot.leetcode.lvl5.lc0411.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private var lenT = 0
    private var range = 0
    private var minAbbr = 0
    private var cand = 0
    private var curMinLen = Int.MAX_VALUE
    private val dict = mutableListOf<Int>()

    fun minAbbreviation(target: String, dictionary: Array<String>): String {
        lenT = target.length
        range = 1 shl lenT

        for (str in dictionary) {
            if (str.length != lenT) continue

            var bitMask = 0
            for (idx in str.indices) {
                if (target[idx] != str[idx]) {
                    bitMask = bitMask or (1 shl idx)
                }
            }

            dict.add(bitMask)
            cand = cand or bitMask
        }

        dfs(1, 0)

        val builder = StringBuilder()
        var hi = 0
        while (hi < lenT) {
            if ((minAbbr and (1 shl hi)) != 0) {
                builder.append(target[hi])
                ++hi
            } else {
                val lo = hi
                while (hi < lenT && (minAbbr and (1 shl hi)) == 0) ++hi
                builder.append(hi - lo)
            }
        }

        return builder.toString()
    }

    private fun dfs(curBit: Int, bitMask: Int) {
        val len = getAbbrLen(bitMask)
        if (len >= curMinLen) return

        var match = true
        for (savedBitMask in dict) {
            if ((savedBitMask and bitMask) == 0) {
                match = false
                break
            }
        }

        if (match) { //  no need to find more if a bitmask can cover all differences
            curMinLen = len
            minAbbr = bitMask
        } else { // to find more if no eligible bit mask has been found
            var bit = curBit
            while (bit < range) {
                if ((cand and bit) != 0) {
                    dfs(bit shl 1, bitMask + bit)
                }

                bit = bit shl 1
            }
        }
    }

    private fun getAbbrLen(bitMask: Int): Int {
        var count = lenT

        var bit = 3
        while (bit < range) {
            if ((bitMask and bit) == 0) {
                --count
            }

            bit = bit shl 1
        }

        return count
    }
}