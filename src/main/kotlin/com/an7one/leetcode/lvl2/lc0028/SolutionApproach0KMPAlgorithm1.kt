/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * Time Complexity:     O(`lenH` + `lenN`) ~ O(max(`lenH`, `lenN`))
 * Space Complexity:    O(`lenN`)
 */
package com.an7one.leetcode.lvl2.lc0028

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0KMPAlgorithm1 {
    fun strStr(haystack: String, needle: String): Int {
        val lenH = haystack.length
        val lenN = needle.length

        if (lenH < lenN)
            return -1

        val kmpTable = IntArray(lenN) { 0 }
        var i = 1
        var j = 0

        while (i < lenN) {
            when {
                needle[i] == needle[j] -> kmpTable[i++] = ++j
                j == 0 -> kmpTable[i++] = 0
                else -> j = kmpTable[j - 1]
            }
        }

        i = 0
        j = 0
        while (i < lenH) {
            if (j == lenN) break

            when {
                haystack[i] == needle[j] -> {
                    ++i
                    ++j
                }
                j == 0 -> ++i
                else -> j = kmpTable[j - 1]
            }
        }

        if (j == lenN)
            return i - lenN

        return -1
    }
}