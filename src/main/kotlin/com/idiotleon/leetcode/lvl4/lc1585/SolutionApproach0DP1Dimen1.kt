package com.idiotleon.leetcode.lvl4.lc1585

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen1 {
    fun isTransformable(s: String, t: String): Boolean {
        val idxes = List(10) { mutableListOf<Int>() }
        for ((idx, digit) in s.withIndex()) {
            idxes[digit - '0'].add(idx)
        }

        val pos = IntArray(10) { 0 }
        for (ch in t) {
            val digit = ch - '0'
            if (pos[digit] >= idxes[digit].size) return false

            for (d in 0 until digit) {
                if (pos[d] < idxes[d].size && idxes[d][pos[d]] < idxes[digit][pos[digit]])
                    return false
            }

            ++pos[digit]
        }

        return true
    }
}