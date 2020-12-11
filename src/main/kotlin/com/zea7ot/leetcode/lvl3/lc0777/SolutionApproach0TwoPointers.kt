/**
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/113789/Simple-Java-one-pass-O(n)-solution-with-explaination/154344
 *  https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/217070/Python-using-corresponding-position-
 *  https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/113789/Simple-Java-one-pass-O(n)-solution-with-explaination
 */
package com.zea7ot.leetcode.lvl3.lc0777

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    private companion object {
        private const val L = 'L'
        private const val R = 'R'
        private const val X = 'X'
    }

    fun canTransform(start: String, end: String): Boolean {
        val lenS = start.length
        val lenE = end.length

        if (start.replace(X.toString(), "") != end.replace(X.toString(), "")) return false

        var idxS = 0
        var idxE = 0

        while (idxS < lenS) {
            while (idxS < lenS && start[idxS] == X) ++idxS
            while (idxE < lenE && end[idxE] == X) ++idxE
            if (idxS == lenS || idxE == lenE) return true
            if (start[idxS] == R && idxS > idxE) return false
            if (start[idxS] == L && idxS < idxE) return false
            ++idxS
            ++idxE
        }

        return true
    }
}