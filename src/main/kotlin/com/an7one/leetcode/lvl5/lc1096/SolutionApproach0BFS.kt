/**
 * https://leetcode.com/problems/brace-expansion-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/brace-expansion-ii/discuss/348541/JAVA-iter_dfs-36ms/431372
 */
package com.an7one.leetcode.lvl5.lc1096

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun braceExpansionII(expression: String): List<String> {
        val queue = LinkedList<String>().also {
            it.offer(expression)
        }

        val seen = HashSet<String>()

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val curStr = queue.poll()

                if (curStr.indexOf('{') == -1) {
                    seen.add(curStr)
                    continue
                }

                var idx = 0
                var lo = 0
                while (curStr[idx] != '}') {
                    if (curStr[idx] == '{') {
                        lo = idx
                    }

                    ++idx
                }
                val hi = idx

                val before = curStr.substring(0, lo)
                val after = curStr.substring(hi + 1)
                val strs = curStr.substring(lo + 1, hi).split(",")

                val builder = StringBuilder()
                for (str in strs) {
                    builder.setLength(0)
                    queue.offer(builder.append(before).append(str).append(after).toString())
                }
            }
        }

        val ans = seen.toMutableList()
        ans.sort()
        return ans
    }
}