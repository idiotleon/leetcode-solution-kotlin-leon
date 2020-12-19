/**
 * https://leetcode.com/problems/smallest-integer-divisible-by-k/
 *
 * Time Complexity:     O(`K`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/smallest-integer-divisible-by-k/discuss/260852/JavaC%2B%2BPython-O(1)-Space-with-Proves-of-Pigeon-Holes
 */
package com.zea7ot.leetcode.lvl3.lc1015

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun smallestRepunitDivByK(K: Int): Int {
        if (K % 2 == 0 || K % 5 == 0) return -1

        var num = 0
        for (n in 1..K) {
            num = (num * 10 + 1) % K
            if (num == 0) return n
        }

        return -1
    }
}