/**
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/discuss/855153/C++-Brute-Force/706740
 *  https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/discuss/855153/C%2B%2B-Brute-Force
 */
package com.zea7ot.leetcode.lvl3.lc1593.withBit

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun maxUniqueSplit(str: String): Int {
        val lenS = str.length

        var maxNum = 0
        val range = 1 shl lenS
        for (bitMask in 0 until range) {
            if (countOneBits(bitMask) <= maxNum - 1) continue

            val seen = HashSet<String>()

            var curLen = 0
            var idxStart = 0

            for (idx in str.indices) {
                if ((bitMask and (1 shl idx)) != 0 || idx == lenS - 1) {
                    val sub = str.substring(idxStart, 1 + idx)
                    idxStart = idx + 1
                    if (seen.add(sub)) {
                        ++curLen
                    } else {
                        curLen = 0
                        break
                    }
                }
            }

            maxNum = maxOf(maxNum, curLen)
        }

        return maxNum
    }

    private fun countOneBits(n: Int): Int {
        var count = 0
        var num = n
        while (num > 0) {
            num = num and (num - 1)
            ++count
        }

        return count
    }
}