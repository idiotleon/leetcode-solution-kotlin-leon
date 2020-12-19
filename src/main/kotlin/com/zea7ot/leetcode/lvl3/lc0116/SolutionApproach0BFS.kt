/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487126&idx=1&sn=4de13e66397bc35970963c5a1330ce18&chksm=9bd7f09eaca0798853c41fba05ad5fa958b31054eba18b69c785ae92f4bd8e4cc7a2179d7838&scene=21#wechat_redirect
 */
package com.zea7ot.leetcode.lvl3.lc0116

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun connect(root: Node?): Node? {
        if (root == null) return null

        val queue = LinkedList<Node>().also { it.offer(root) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                if (sz < size - 1) {
                    cur.next = queue.peek()
                }

                cur.left?.let { queue.offer(it) }
                cur.right?.let { queue.offer(it) }
            }
        }

        return root
    }
}