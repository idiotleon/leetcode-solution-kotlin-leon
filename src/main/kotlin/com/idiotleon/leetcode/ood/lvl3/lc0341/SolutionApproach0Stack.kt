/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 *
 * Time Complexities:
 *  `next()`:       O()
 *  `hasNext()`:    O()
 *
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/flatten-nested-list-iterator/discuss/80147/Simple-Java-solution-using-a-stack-with-explanation
 */
package com.idiotleon.leetcode.ood.lvl3.lc0341

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack(nestedList: List<NestedInteger>) {
    private val stack = LinkedList<NestedInteger>()

    init {
        flattenNestedList(nestedList)
    }

    fun next(): Int {
        if (!hasNext()) return -1

        return stack.pop().getInteger()!!
    }

    fun hasNext(): Boolean {
        while (stack.isNotEmpty() && !stack.peek().isInteger()) {
            val list = stack.pop().getList()
            flattenNestedList(list)
        }

        return stack.isNotEmpty()
    }

    private fun flattenNestedList(nestedList: List<NestedInteger>?) {
        nestedList?.let {
            for (idx in it.indices.reversed()) {
                stack.push(it[idx])
            }
        }
    }
}