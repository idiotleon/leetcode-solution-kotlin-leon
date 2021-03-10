/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 *
 * Time Complexity:     O(`nStrs` * `lenS`)
 * Space Complexity:    ?O()
 *
 * References:
 *  https://leetcode.com/problems/delete-columns-to-make-sorted-ii/discuss/203171/C%2B%2B-12-ms-brute-force
 */
package com.an7one.leetcode.lvl3.lc0955

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun minDeletionSize(arr: Array<String>): Int {
        val nStrs = arr.size
        // not used
        // val lenS = arr[0].length

        val toBeDeleted = HashSet<Int>()

        var idxStr = 1
        while (idxStr < nStrs) {
            for (idxCh in arr[idxStr].indices) {
                if (toBeDeleted.contains(idxCh) || arr[idxStr - 1][idxCh] == arr[idxStr][idxCh]) continue

                if (arr[idxStr - 1][idxCh] > arr[idxStr][idxCh]) {
                    // if, in the same `idxCh`/col,
                    // the current str/row is less than the previous one.
                    // to add that `idxCh`/col to the HashSet
                    toBeDeleted.add(idxCh)

                    // to restart,
                    // because deletion of columns might change the previous order
                    idxStr = 0
                }

                break
            }

            ++idxStr
        }

        return toBeDeleted.size
    }
}