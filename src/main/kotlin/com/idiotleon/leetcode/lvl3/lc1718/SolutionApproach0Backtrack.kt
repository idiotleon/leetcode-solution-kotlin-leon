/**
 * https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 *  https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/discuss/1008864/Java-or-C%2B%2Bor-Detailed-explanation-or-BackTracking-or-100-faster
 *  https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/discuss/1008913/C%2B%2B-Backtracking
 */
package com.idiotleon.leetcode.lvl3.lc1718

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun constructDistancedSequence(n: Int): IntArray {
        val ans = IntArray(2 * n - 1)
        val used = BooleanArray(n + 1) { false }

        backtrack(0, used, n, ans)

        return ans
    }

    private fun backtrack(idxStart: Int, used: BooleanArray, n: Int, res: IntArray): Boolean {
        val len = res.size
        if (idxStart == len)
            return true

        if (res[idxStart] != 0)
            return backtrack(idxStart + 1, used, n, res)

        for (idx in n downTo 1) {
            if (used[idx])
                continue

            used[idx] = true
            res[idxStart] = idx

            if (idx == 1) {
                if (backtrack(idxStart + 1, used, n, res))
                    return true
            } else if (idxStart + idx < len && res[idxStart + idx] == 0) {
                res[idxStart + idx] = idx
                if (backtrack(idxStart + 1, used, n, res))
                    return true
                res[idxStart + idx] = 0
            }

            res[idxStart] = 0
            used[idx] = false
        }

        return false
    }
}