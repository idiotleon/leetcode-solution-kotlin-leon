/**
 * https://leetcode.com/problems/beautiful-array/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/beautiful-array/discuss/186679/Odd-%2B-Even-Pattern-O(N)
 *  https://leetcode.com/problems/beautiful-array/discuss/187669/Share-my-O(NlogN)-C%2B%2B-solution-with-proof-and-explanation
 */
package com.zea7ot.leetcode.lvl5.lc0932

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DivideAndConquer {
    fun beautifulArray(N: Int): IntArray {
        var ans = arrayListOf(1)

        while (ans.size < N) {
            val temp = ArrayList<Int>()
            for (num in ans) {
                if (num * 2 - 1 <= N) {
                    temp.add(num * 2 - 1)
                }
            }

            for (num in ans) {
                if (num * 2 <= N) {
                    temp.add(num * 2)
                }
            }

            ans = temp
        }

        return ans.toIntArray()
    }
}