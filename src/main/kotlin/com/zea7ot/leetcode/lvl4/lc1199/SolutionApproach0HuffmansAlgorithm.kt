/**
 * https://leetcode.com/problems/minimum-time-to-build-blocks/
 *
 * Time Complexity:     O(`nBlocks` * lg(`nBlocks`))
 * Space Complexity:    O(`nBlocks`)
 *
 * References:
 *  https://youtu.be/pSW8wxvcEcM
 *  https://leetcode.com/problems/minimum-time-to-build-blocks/discuss/387051/JavaC%2B%2BPython-Huffman's-Algorithm
 *  https://leetcode.com/problems/minimum-time-to-build-blocks/discuss/387035/Python:-O(n-log-n)-using-Huffman's-Algorithm-(priority-queue)-with-explanation./513835
 *  https://leetcode.com/problems/minimum-time-to-build-blocks/discuss/387035/Python%3A-O(n-log-n)-using-Huffman's-Algorithm-(priority-queue)-with-explanation.
 */
package com.zea7ot.leetcode.lvl4.lc1199

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0HuffmansAlgorithm {
    fun minBuildTime(blocks: IntArray, split: Int): Int {
        // not used
        // val nBlocks = blocks.size

        val minHeap = PriorityQueue<Int>()
        for (block in blocks) {
            minHeap.offer(block)
        }

        while (minHeap.size > 1) {
            val x = minHeap.poll()
            val y = minHeap.poll()

            minHeap.offer(y + split)
        }

        return minHeap.poll()
    }
}