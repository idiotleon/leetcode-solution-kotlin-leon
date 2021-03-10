/**
 * https://leetcode.com/problems/count-binary-substrings/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space/113793
 *  https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space/221785
 */
package com.an7one.leetcode.lvl3.lc0696

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan2 {
    fun countBinarySubstrings(str: String): Int {
        // sanity check
        if (str.isEmpty()) return 0

        var cntOnes = 0
        var cntZeros = 0
        var prev = -1
        var count = 0

        for (ch in str) {
            if (ch == '0') {
                if (prev == 1) cntZeros = 0
                ++cntZeros
                prev = 0
            } else {
                if (prev == 0) cntOnes = 0
                ++cntOnes
                prev = 1
            }

            if ((prev == 1 && cntZeros >= cntOnes) || (prev == 0 && cntOnes >= cntZeros)) ++count
        }

        return count
    }
}