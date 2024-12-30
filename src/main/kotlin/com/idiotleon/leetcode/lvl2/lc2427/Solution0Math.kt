package com.idiotleon.leetcode.lvl2.lc2427

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-common-factors/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/number-of-common-factors/solutions/2648945/brute-force/comments/1628225
 * https://leetcode.com/problems/number-of-common-factors/solutions/2648945/brute-force/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 */
@Suppress(UNUSED)
class Solution0Math {
    fun commonFactors(a: Int, b: Int): Int {
        var count = 1
        for (num in 2..getGCD(a, b)) {
            if (a % num == 0 && b % num == 0) {
                ++count
            }
        }
        return count
    }

    private fun getGCD(a: Int, b: Int): Int {
        if (a == 0) {
            return b
        }
        return getGCD(b % a, a)
    }
}