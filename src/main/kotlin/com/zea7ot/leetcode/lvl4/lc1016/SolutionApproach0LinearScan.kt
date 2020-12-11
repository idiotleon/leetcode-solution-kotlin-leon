/**
 * https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
 *
 * Time Complexity:     O(`lenS` * lg(`N`))
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/discuss/260882/C++-O(S-log-N)-vs.-O(N-*-(S-+-log-N))/253202
 *  https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/discuss/260882/C%2B%2B-O(S-log-N)-vs.-O(N-*-(S-%2B-log-N))
 */
package com.zea7ot.leetcode.lvl4.lc1016

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun queryString(str: String, N: Int): Boolean {
        val lenS = str.length
        if (lenS < N) return false

        val seen = BooleanArray(N + 1) { false }
        var seenCnt = 0

        for (lo in str.indices) {
            if (str[lo] == '0') continue

            var num = 0
            for (hi in lo until lenS) {
                num = (num shl 1) + (str[hi] - '0')

                if (num in 1..N && !seen[num]) {
                    seen[num] = true
                    ++seenCnt
                    if (seenCnt == N) return true
                }

                if (num > N) break
            }
        }

        return false
    }
}