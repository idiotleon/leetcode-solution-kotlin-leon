/**
 * @author: Leon
 * https://leetcode.com/problems/reformat-phone-number/
 *
 * Time Complexity:     O(`lenN`)
 * Space Complexity:    O(`lenN`) / O(1)
 */
package com.idiotleon.leetcode.lvl2.lc1694

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun reformatNumber(number: String): String {
        // not used
        // val lenN = number.length
        val builder = StringBuilder()
        var count = 0
        var len = 0

        for (ch in number) {
            when (ch) {
                ' ' -> {
                }
                '-' -> {
                }
                else -> {
                    if (count == 3) {
                        builder.append('-')
                        count = 1
                    } else {
                        ++count
                    }

                    builder.append(ch)
                    ++len
                }
            }
        }

        if (len <= 3) return builder.toString()
        if (len % 3 == 1) {
            val idx = builder.lastIndexOf('-')
            val temp = builder[idx - 1]
            builder.setCharAt(idx - 1, '-')
            builder.setCharAt(idx, temp)
        }

        return builder.toString()
    }
}