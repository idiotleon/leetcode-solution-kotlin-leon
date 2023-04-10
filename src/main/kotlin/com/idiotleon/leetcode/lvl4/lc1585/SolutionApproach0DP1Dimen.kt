package com.idiotleon.leetcode.lvl4.lc1585

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/
 *
 * Time Complexity:     O(max(lenS, lenT))
 * Space Complexity:    O(10) ~ O(1)
 *
 * Reference:
 * https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/discuss/843917/C++JavaPython-O(n)/694392
 * https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/discuss/843917/C%2B%2BJavaPython-O(n)
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun isTransformable(s: String, t: String): Boolean {
        val idxes = List(10) { LinkedList<Int>() }
        for ((idx, digit) in s.withIndex().reversed()) {
            idxes[digit - '0'].add(idx)
        }

        for (ch in t) {
            val digit = ch - '0'
            if (idxes[digit].isEmpty()) return false

            for (k in 0 until digit) {
                if (idxes[k].isNotEmpty() && idxes[k].last() < idxes[digit].last()) return false
            }

            idxes[digit].removeLast()
        }

        return true
    }
}