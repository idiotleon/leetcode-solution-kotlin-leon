/**
 * https://leetcode.com/problems/student-attendance-record-ii/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/student-attendance-record-ii/discuss/101638/Simple-Java-O(n)-solution/113451
 *  https://leetcode.com/problems/student-attendance-record-ii/discuss/101638/Simple-Java-O(n)-solution
 *  https://leetcode.com/problems/student-attendance-record-ii/discuss/101643/Share-my-O(n)-C%2B%2B-DP-solution-with-thinking-process-and-explanation
 */
package com.zea7ot.leetcode.lvl5.lc0552

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun checkRecord(n: Int): Int {
        // ending with being "present" without being "absent"
        val present = LongArray(n + 1) { 0L }
        present[0] = 1
        present[1] = 1

        // ending with being "late" without being "absent"
        val late = LongArray(n + 1) { 0L }
        late[1] = 1

        for (idx in 2..n) {
            present[idx] = (present[idx - 1] + late[idx - 1]) % MOD
            late[idx] = (present[idx - 1] + present[idx - 2]) % MOD
        }

        var ans = (present[n] + late[n]) % MOD

        // to insert (being) "absent"
        for (idx in 0 until n) {
            val res = ((present[idx] + late[idx]) % MOD * (present[n - idx - 1] + late[n - idx - 1]) % MOD) % MOD
            ans = (ans + res) % MOD
        }

        return ans.toInt()
    }
}