/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Time Complexity:     O(`lenS` * (2 ^ `lenS`))
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/palindrome-partitioning/discuss/41974/My-Java-DP-only-solution-without-recursion.-O(n2)
 */
package com.zea7ot.leetcode.lvl3.lc0131

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun partition(str: String): List<List<String>> {
        val lenS = str.length
        val results = Array(lenS + 1) { ArrayList<ArrayList<String>>() }
        results[0] = arrayListOf(arrayListOf())

        val isPalindrome = Array(lenS) { BooleanArray(lenS) { false } }

        for (hi in str.indices) {
            results[hi + 1] = arrayListOf()
            for (lo in 0..hi) {
                if (str[lo] == str[hi] && (hi - lo <= 2 || isPalindrome[lo + 1][hi - 1])) {
                    isPalindrome[lo][hi] = true

                    val substr = str.substring(lo, hi + 1)
                    for (list in results[lo]) {
                        val copy = ArrayList(list).also { it.add(substr) }
                        results[hi + 1].add(copy)
                    }
                }
            }
        }

        return results[lenS]
    }
}