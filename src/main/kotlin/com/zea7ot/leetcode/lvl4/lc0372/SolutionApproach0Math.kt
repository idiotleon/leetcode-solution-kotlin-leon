/**
 * https://leetcode.com/problems/super-pow/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O()
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485035&idx=1&sn=c03c9056f412bf590480156e4357b433&chksm=9bd7f863aca07175eca0bd5e638c857969af1936cc2b7b4a01610809ba1d85a3272703e2b3a2&scene=21#wechat_redirect
 */
package com.zea7ot.leetcode.lvl4.lc0372

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Math {
    private companion object {
        private const val MOD = 1337
    }

    fun superPow(a: Int, b: IntArray): Int {
        // not used
        // val nNums = b.size

        val queue = LinkedList<Int>().also {
            for (num in b) {
                it.offer(num)
            }
        }

        return superPow(a, queue)
    }

    private fun superPow(a: Int, queue: LinkedList<Int>): Int {
        if (queue.isEmpty()) return 1
        val last = queue.removeLast()

        val part1 = myPow(a, last)
        val part2 = myPow(superPow(a, queue), 10)

        return (part1 * part2) % MOD
    }

    private fun myPow(a: Int, K: Int): Int {
        var a = a
        a %= MOD
        var res = 1
        for (k in 0 until K) {
            res *= a
            res %= MOD
        }

        return res
    }
}