package com.idiotleon.leetcode.lvl3.lc1792

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-average-pass-ratio/
 *
 * Time Complexity:     O(`nClasses` * lg(`nClasses`)) + O(`extraStudents` * lg(`extraStudents`)) ~ O(`nClasses` * lg(`nClasses`))
 * Space Complexity:    O(`nClasses`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-average-pass-ratio/solutions/1108263/python-java-max-heap-clean-concise/?envType=daily-question&envId=2024-12-15
 */
@Suppress(UNUSED)
class Solution0MaxHeap {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        val nClasses = classes.size
        val maxHeap = PriorityQueue<Node> { a, b -> (b.gain).compareTo(a.gain) }.also {
            for ((pass, total) in classes) {
                it.offer(Node(getGain(pass, total), pass, total))
            }
        }

        for (count in 0 until extraStudents) {
            val (_, pass, total) = maxHeap.poll()
            val newGain = getGain(pass + 1, total + 1)
            maxHeap.offer(Node(newGain, pass + 1, total + 1))
        }

        var sumRatio: Double = 0.0
        while (maxHeap.isNotEmpty()) {
            val (_, pass, total) = maxHeap.poll()
            sumRatio += pass.toDouble() / total.toDouble()
        }

        return sumRatio / nClasses.toDouble()
    }

    private fun getGain(pass: Int, total: Int): Double =
        ((pass + 1).toDouble() / (total + 1).toDouble() - pass.toDouble() / total.toDouble())

    private data class Node(val gain: Double, val pass: Int, val total: Int)
}