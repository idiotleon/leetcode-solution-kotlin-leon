/**
 * https://leetcode.com/problems/distinct-echo-substrings/
 *
 * Time Complexity:     O(`lenT` ^ 2)
 * Space Complexity:    O(`lenT`)
 *
 * References:
 *  https://github.com/huanminwu/LeetCode/blob/master/LeetCode_String_III_KMP_RabinKarp.docx
 */
package com.zea7ot.leetcode.lvl4.lc1316

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach1KMPAlgorithm {
    fun distinctEchoSubstrings(text: String): Int {
        val lenT = text.length
        val set = HashSet<String>()

        for (idxStart in text.indices) {
            val kmpTable = IntArray(lenT) { 0 }
            var lo = 0
            var hi = 1

            loop@ while (idxStart + hi < lenT) {
                when {
                    text[idxStart + lo] == text[idxStart + hi] -> {
                        kmpTable[hi++] = ++lo

                        // must be of even length
                        if (hi % 2 == 1) continue@loop

                        // if duplicate as half,
                        // the remaining prefix length must be
                        // divisible to total length
                        if ((hi / 2) % (hi - lo) == 0) {
                            set.add(text.substring(idxStart, idxStart + hi))
                        }
                    }

                    lo == 0 -> ++hi
                    else -> lo = kmpTable[lo - 1]
                }
            }
        }

        return set.size
    }
}