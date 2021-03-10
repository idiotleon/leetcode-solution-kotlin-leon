/**
 * https://leetcode.com/problems/stickers-to-spell-word/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/stickers-to-spell-word/discuss/108333/Rewrite-of-contest-winner's-solution/394405
 *  https://leetcode.com/problems/stickers-to-spell-word/discuss/108333/Rewrite-of-contest-winner's-solution
 */
package com.an7one.leetcode.lvl5.lc0691.withBit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun minStickers(stickers: Array<String>, target: String): Int {
        val lenT = target.length
        val range = 1 shl lenT

        val queue = LinkedList<Int>().also {
            it.offer(0)
        }

        val seen = HashSet<Int>()

        var level = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val curComb = queue.poll()

                for (sticker in stickers) {
                    var nextComb = curComb

                    for (ch in sticker) {
                        for (idxT in target.indices) {
                            val bitIdx = 1 shl idxT
                            if (target[idxT] == ch && ((nextComb and bitIdx) == 0)) {
                                nextComb = nextComb or bitIdx
                                break
                            }
                        }
                    }

                    if (nextComb == range - 1) return 1 + level
                    if (seen.add(nextComb)) queue.offer(nextComb)
                }
            }

            ++level
        }

        return -1
    }
}