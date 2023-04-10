/**
 * https://leetcode.com/problems/minimum-window-subsequence/
 *
 * Time Complexity:     O(maxOf(`lenS`, `lenT`)) ~ O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-window-subsequence/discuss/109356/JAVA-two-pointer-solution-(12ms-beat-100)-with-explaination/211042
 */
package com.idiotleon.leetcode.lvl4.lc0727

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun minWindow(S: String, T: String): String {
        var ans = ""
        // sanity check
        if (S.isEmpty() || T.isEmpty()) return ans

        val lenS = S.length
        val lenT = T.length

        var idxS = 0
        var idxT = 0
        var len = lenS + 1

        while (idxS < lenS) {
            if (S[idxS] == T[idxT]) {
                ++idxT
                if (idxT == lenT) { // all chars in `CHS_T` have been matched
                    // to check feasibility from left to right of `T`
                    val end = idxS + 1 // `idxS` is the last match index in `CHS_S`/`S`
                    // to check optimization from right to left of T
                    --idxT; // now 'idxT' is the last index in `CHS_T`/`T`
                    while (idxT >= 0) {
                        if (S[idxS] == T[idxT]) {
                            --idxT
                        }

                        --idxS
                    }

                    ++idxS
                    ++idxT

                    // to record the current smallest candidate
                    if (end - idxS < len) {
                        len = end - idxS
                        ans = S.substring(idxS, end) // [idxS, end) is the matching subsequence
                    }
                }
            }

            ++idxS
        }

        return if (len == lenS + 1) "" else ans
    }
}