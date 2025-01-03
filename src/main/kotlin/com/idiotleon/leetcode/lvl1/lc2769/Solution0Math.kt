package com.idiotleon.leetcode.lvl1.lc2769

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-maximum-achievable-number/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0Math {
    fun theMaximumAchievableX(num: Int, t: Int): Int {
        return num + 2 * t
    }
}