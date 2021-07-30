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
package com.an7one.leetcode.lvl5.lc0932

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DivideAndConquer {
    fun beautifulArray(n: Int): IntArray {
        var ans = mutableListOf(1)

        while (ans.size < n) {
            val temp = mutableListOf<Int>()
            for (num in ans) {
                if (num * 2 - 1 <= n)
                    temp.add(num * 2 - 1)
            }

            for (num in ans) {
                if (num * 2 <= n)
                    temp.add(num * 2)
            }

            ans = temp
        }

        return ans.toIntArray()
    }
}