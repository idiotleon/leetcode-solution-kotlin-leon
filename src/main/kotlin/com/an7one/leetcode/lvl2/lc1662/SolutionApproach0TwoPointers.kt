/**
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 *
 * Time Complexity:     O(nWords * len)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/discuss/944525/Java-using-count-pointers-no-String-concatenation-2ms-memory-100
 */
package com.an7one.leetcode.lvl2.lc1662

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun arrayStringsAreEqual(words1: Array<String>, words2: Array<String>): Boolean {
        val nWords1 = words1.size
        val nWords2 = words2.size

        var idxWord1 = 0
        var idxWord2 = 0
        var idxCh1 = 0
        var idxCh2 = 0

        while (idxWord1 < nWords1 && idxWord2 < nWords2) {
            val word1 = words1[idxWord1]
            val len1 = word1.length
            val word2 = words2[idxWord2]
            val len2 = word2.length

            if (word1[idxCh1] != word2[idxCh2]) return false
            idxCh1 = (++idxCh1) % len1
            idxCh2 = (++idxCh2) % len2

            if (idxCh1 == 0) ++idxWord1
            if (idxCh2 == 0) ++idxWord2
        }

        return idxWord1 == nWords1 && idxWord2 == nWords2
    }
}