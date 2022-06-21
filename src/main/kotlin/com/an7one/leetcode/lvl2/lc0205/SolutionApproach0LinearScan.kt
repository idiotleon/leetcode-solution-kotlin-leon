package com.an7one.leetcode.lvl2.lc0205

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/isomorphic-strings/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(256) ~ O(1)
 *
 * Reference:
 * https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution
 * https://leetcode.com/problems/isomorphic-strings/discuss/57810/Short-Java-solution-without-maps
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun isIsomorphic(s: String, t: String): Boolean {
        // not used
        // val lenS = s.length

        val dictS = IntArray(256) { -1 }
        val dictT = IntArray(256) { -1 }

        for (idx in s.indices) {
            val idxS = s[idx].code
            val idxT = t[idx].code

            if (dictS[idxS] != dictT[idxT])
                return false

            dictS[idxS] = idx
            dictT[idxT] = idx
        }

        return true
    }
}