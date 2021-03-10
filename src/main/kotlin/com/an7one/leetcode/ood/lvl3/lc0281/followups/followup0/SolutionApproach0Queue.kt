/**
 * https://leetcode.com/problems/zigzag-iterator/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/zigzag-iterator/discuss/71779/Simple-Java-solution-for-K-vector
 */
package com.an7one.leetcode.ood.lvl3.lc0281.followups.followup0

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Queue(lists: List<List<Int>>) {
    val iters = LinkedList<Iterator<Int>>()

    init {
        for (list in lists) {
            iters.add(list.listIterator())
        }
    }

    fun next(): Int {
        val iter = iters.remove()
        val res = iter.next()
        if (iter.hasNext()) iters.add(iter)
        return res
    }

    fun hasNext() = iters.isNotEmpty()
}