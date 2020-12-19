/**
 * https://leetcode.com/problems/magical-string/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/magical-string/discuss/96413/Simple-Java-solution-using-one-array-and-two-pointers/101021
 */
package com.zea7ot.leetcode.lvl4.lc0481

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Deque {
    fun magicalString(n: Int): Int {
        if (n <= 0) return 0
        if (n <= 3) return 1

        val deque = LinkedList<Int>().also {
            it.add(2)
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