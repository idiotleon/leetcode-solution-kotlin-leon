/**
 * https://leetcode.com/problems/similar-rgb-color/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/similar-rgb-color/discuss/138448/Simple-java-sol
 */
package com.an7one.leetcode.lvl2.lc0800

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private val HEXES = arrayOf("00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc", "dd", "ee", "ff")
        private const val HEX = 16
    }

    fun similarRGB(color: String): String {
        val builder = StringBuilder("#")
        val lenS = color.length

        for (idx in 1 until lenS step 2) {
            val hex = color.substring(idx, idx + 2)

            var num = Int.MAX_VALUE
            var rgb = ""

            for (he in HEXES) {
                val res = abs(hex.toInt(HEX) - he.toInt(HEX))

                if (res < num) {
                    num = res
                    rgb = he
                }
            }

            builder.append(rgb)
        }

        return builder.toString()
    }
}