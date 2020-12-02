/**
 * https://leetcode.com/problems/linked-list-random-node/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling
 */
package com.zea7ot.leetcode.ood.lvl2.lc0382

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.linkedList.ListNode
import kotlin.random.Random

@Suppress(UNUSED)
class SolutionApproach0ReservoirSampling(private val head: ListNode?) {
    fun getRandom(): Int {
        if (head == null) return 0
        var cur = head
        var value = cur.`val`

        var idx = 1
        while (cur?.next != null) {
            cur = cur.next

            if (Random.nextInt(idx + 1) == idx) {
                value = cur!!.`val`
            }

            ++idx
        }

        return value
    }
}