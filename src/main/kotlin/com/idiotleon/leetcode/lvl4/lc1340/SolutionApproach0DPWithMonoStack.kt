/**
 * https://leetcode.com/problems/jump-game-v/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://mp.weixin.qq.com/s/kEQ00_WLqDTG6tbsjQ2Xjw
 */
package com.idiotleon.leetcode.lvl4.lc1340

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DPWithMonoStack {
    fun maxJumps(arr: IntArray, d: Int): Int {
        val totalNums = arr.size
        val padded = IntArray(totalNums + 1) { idx -> if (idx == totalNums) Int.MAX_VALUE else arr[idx] }
        val dp = IntArray(totalNums + 1) { 1 }

        val stack1 = LinkedList<Int>()
        val stack2 = LinkedList<Int>()

        for (hi in padded.indices) {
            while (stack1.isNotEmpty() && padded[stack1.peek()] < padded[hi]) {
                val prev = padded[stack1.peek()]

                while (stack1.isNotEmpty() && prev == padded[stack1.peek()]) {
                    val lo = stack1.pop()
                    if (hi - lo <= d) {
                        dp[hi] = maxOf(dp[hi], dp[lo] + 1)
                    }

                    stack2.push(lo)
                }

                while (stack2.isNotEmpty()) {
                    val lo = stack2.pop()
                    if (stack1.isNotEmpty() && lo - stack1.peek() <= d) {
                        dp[stack1.peek()] = maxOf(dp[stack1.peek()], dp[lo] + 1)
                    }
                }
            }

            stack1.push(hi)
        }


        var most = 0
        for (idx in 0 until totalNums) {
            most = maxOf(most, dp[idx])
        }

        return most
    }
}