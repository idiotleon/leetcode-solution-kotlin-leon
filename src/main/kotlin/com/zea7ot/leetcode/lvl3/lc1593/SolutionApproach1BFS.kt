/**
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/discuss/855153/C++-Brute-Force/706740
 */
package com.zea7ot.leetcode.lvl3.lc1593

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach1BFS {
    fun maxUniqueSplit(str: String): Int {
        val lenS = str.length

        val queue = LinkedList<Node>()
        for (idx in 1..lenS) {
            val sub = str.substring(0, idx)
            val seen = hashSetOf(sub)
            queue.offer(Node(idx, 1, seen))
        }

        var maxNum = 0
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                val idxStart = cur.idxStart
                val num = cur.num
                val seen = cur.seen

                if (idxStart == lenS) maxNum = maxOf(maxNum, num)

                for (idx in 1 + idxStart..lenS) {
                    val sub = str.substring(idxStart, idx)
                    if (seen.contains(sub)) continue
                    val newSeen = seen.toHashSet().also { it.add(sub) }
                    queue.offer(Node(idx, 1 + num, newSeen))
                }
            }
        }

        return maxNum
    }

    private data class Node(val idxStart: Int, val num: Int, val seen: HashSet<String>)
}