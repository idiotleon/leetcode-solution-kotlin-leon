package com.idiotleon.leetcode.lvl2.lc0028

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/implement-strstr/
 *
 * Time Complexity:     O(`lenH` * `lenN`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty())
            return 0

        val lenH = haystack.length
        val lenN = needle.length

        for (idxH in haystack.indices) {
            for (idxN in needle.indices) {
                if (idxH + idxN == lenH)
                    return -1

                if (haystack[idxH + idxN] != needle[idxN])
                    break

                if (idxN == lenN - 1)
                    return idxH
            }
        }

        return -1
    }
}