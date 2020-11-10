/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 *
 * Time Complexity:     O(`nStrs` * lenS)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/delete-columns-to-make-sorted/discuss/197402/Simple-Java-solution
 */
package com.zea7ot.leetcode.lvl2.lc0944

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun minDeletionSize(strs: Array<String>): Int {
        val nStrs = strs.size

        var count = 0

        for (idxCh in strs[0].indices) {
            for (idxStr in 1 until nStrs) {
                if (strs[idxStr - 1][idxCh] > strs[idxStr][idxCh]) {
                    ++count
                    break
                }
            }
        }

        return count
    }
}