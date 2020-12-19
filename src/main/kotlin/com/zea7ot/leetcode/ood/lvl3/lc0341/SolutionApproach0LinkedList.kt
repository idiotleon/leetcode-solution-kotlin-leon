/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 *
 * Time Complexities:
 *  initialization:     O()
 *  next():             O()
 *  hasNext():          O()
 *
 * Space Complexity:    O()
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485629&idx=1&sn=fc0d0fc2b8618a9b8a575cfa9d5b1c4a&chksm=9bd7f6b5aca07fa33c4fbce0dc439359592ace091814fdcdc0742f336722398090396f0b3668&scene=21#wechat_redirect
 */
package com.zea7ot.leetcode.ood.lvl3.lc0341

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0LinkedList(nestedList: List<NestedInteger>) {
    private val list = LinkedList<NestedInteger>(nestedList)

    fun next(): Int {
        return list.removeFirst().getInteger()!!
    }

    fun hasNext(): Boolean {
        while (list.isNotEmpty() && !list[0].isInteger()) {
            val first = list.removeFirst().getList()!!
            for (idx in first.indices.reversed()) {
                list.addFirst(first[idx])
            }
        }

        return list.isNotEmpty()
    }

}