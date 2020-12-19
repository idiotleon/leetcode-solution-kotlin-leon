/**
 * https://leetcode.com/problems/random-flip-matrix/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Fisher-Yates Shuffle
 *  https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#Examples
 *
 * References:
 *  https://leetcode.com/problems/random-flip-matrix/discuss/154053/Java-AC-Solution-call-Least-times-of-Random.nextInt()-function/160255
 *  https://leetcode.com/problems/random-flip-matrix/discuss/155341/Easy-Algorithm-Explanation-Step-By-Step.
 *  https://leetcode.com/problems/random-flip-matrix/discuss/154053/Java-AC-Solution-call-Least-times-of-Random.nextInt()-function
 */
package com.zea7ot.leetcode.lvl3.lc0519

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import kotlin.random.Random

@Suppress(UNUSED)
class SolutionApproach0MathTest(private val nRows: Int, private val nCols: Int) {
    private val map = HashMap<Int, Int>()
    private var nNums = nRows * nCols

    fun flip(): IntArray {
        // to generate the index, by decreasing the total number of values
        val randNum = Random.nextInt(nNums--)

        // to check if there already has been an existing `idx`
        val idx = map[randNum] ?: randNum

        // to swap
        map[randNum] = map[nNums] ?: nNums
        map[nNums] = idx
        return intArrayOf(idx / nCols, idx % nCols)
    }

    fun reset() {
        nNums = nRows * nCols
    }
}