package com.idiotleon.leetcode.lvl5.lc0899

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/orderly-queue/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/orderly-queue/discuss/165878/C%2B%2BJavaPython-Sort-String-or-Rotate-String
 */
@Suppress(UNUSED)
class SolutionApproach0Math {
    fun orderlyQueue(s: String, k: Int): String {
        if (k > 1) {
            val chs = s.toCharArray()
            chs.sort()
            return String(chs)
        }

        val lenS = s.length
        var res = s
        for (idx in 1 until lenS) {
            val tmp = s.substring(idx) + s.substring(0, idx)
            if (res > tmp) res = tmp
        }
        return res
    }
}