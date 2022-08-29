package com.an7one.leetcode.lvl4.lc0481

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/magical-string/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * Reference:
 * https://leetcode.com/problems/magical-string/discuss/96413/Simple-Java-solution-using-one-array-and-two-pointers/101021
 */
@Suppress(UNUSED)
class SolutionApproach0Deque {
    fun magicalString(n: Int): Int {
        if (n <= 0) return 0
        if (n <= 3) return 1

        val deque = ArrayDeque<Int>().also {
            it.addLast(2)
        }

        var ans = 1
        var len = 2
        var nextNum = 1

        while (len < n) {
            val curNum = deque.removeFirst()
            if (curNum == 1) ++ans
            ++len

            for (repeat in 0 until curNum) {
                deque.addLast(nextNum)
            }

            nextNum = nextNum xor 3
        }

        return ans
    }
}