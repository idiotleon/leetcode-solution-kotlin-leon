package com.idiotleon.leetcode.ood.lvl3.lc0341

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 *
 * Time Complexity:
 *  `next()`:       O()
 *  `hasNext()`:    O()
 *
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/flatten-nested-list-iterator/discuss/80147/Simple-Java-solution-using-a-stack-with-explanation
 */
@Suppress(UNUSED)
class SolutionApproach0Stack(nestedList: List<NestedInteger>) {
    private val stack = ArrayDeque<NestedInteger>()

    init {
        flattenNestedList(nestedList)
    }

    fun next(): Int {
        if (!hasNext()) return -1

        return stack.removeLast().getInteger()!!
    }

    fun hasNext(): Boolean {
        while (stack.isNotEmpty() && !stack.last().isInteger()) {
            val list = stack.removeLast().getList()
            flattenNestedList(list)
        }

        return stack.isNotEmpty()
    }

    private fun flattenNestedList(nestedList: List<NestedInteger>?) {
        nestedList?.let {
            for (idx in it.indices.reversed()) {
                stack.addLast(it[idx])
            }
        }
    }
}