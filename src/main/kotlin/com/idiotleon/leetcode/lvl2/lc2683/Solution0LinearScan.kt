package com.idiotleon.leetcode.lvl2.lc2683

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/neighboring-bitwise-xor/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/neighboring-bitwise-xor/editorial/
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        val nNums = derived.size
        var res = 0
        for (num in derived) {
            res = res xor num
        }
        return res == 0
    }
}