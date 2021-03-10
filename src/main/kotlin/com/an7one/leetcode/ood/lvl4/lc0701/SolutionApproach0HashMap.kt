/**
 * https://leetcode.com/problems/random-pick-with-blacklist/
 *
 * Time Complexity:
 *  initialization:         O(`nBlocked`)
 *  `pick()`:               O(1)
 *
 * Space Complexity:        O(`nBlocked`)
 *
 * References:
 *  https://leetcode.com/problems/random-pick-with-blacklist/discuss/144624/Java-O(B)-O(1)-HashMap/424919
 *  https://leetcode.com/problems/random-pick-with-blacklist/discuss/144624/Java-O(B)-O(1)-HashMap
 */
package com.an7one.leetcode.ood.lvl4.lc0701

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.random.Random

@Suppress(UNUSED)
class SolutionApproach0HashMap(N: Int, blocklist: IntArray) {
    private val nBlocked = blocklist.size

    private val blockMap = HashMap<Int, Int>()
    private val nPassed = N - nBlocked

    init {
        for (num in blocklist) {
            blockMap[num] = -1
        }

        var n = N
        for (num in blocklist) {
            if (num < nPassed) {
                while (blockMap.containsKey(n - 1)) n--
                blockMap[num] = --n
            }
        }
    }

    fun pick(): Int {
        val pick = Random.nextInt(nPassed)
        return blockMap[pick] ?: pick
    }
}