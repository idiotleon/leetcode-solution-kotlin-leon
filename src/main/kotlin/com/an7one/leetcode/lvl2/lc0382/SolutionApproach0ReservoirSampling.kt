/**
 * https://leetcode.com/problems/linked-list-random-node/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 *  https://youtu.be/mjKq89QAaJA?t=301
 */
package com.an7one.leetcode.lvl2.lc0382

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.linkedList.ListNode
import kotlin.random.Random

@Suppress(UNUSED)
class SolutionApproach0ReservoirSampling(private val head: ListNode?) {
    fun getRandom(): Int {
        var ans = -1
        var count = 0

        var cur: ListNode? = head
        while (cur != null) {
            if (Random.nextInt(++count) == 0)
                ans = cur.`val`

            cur = cur.next
        }

        return ans
    }
}