/**
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/discuss/743223/C++Java-Greedy-O(n)/622997
 *  https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/discuss/743223/C%2B%2BJava-Greedy-O(n)
 */
package com.idiotleon.leetcode.lvl5.lc1520

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayList

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun maxNumOfSubstrings(str: String): List<String> {
        val lenS = str.length
        val firstIdxes = IntArray(26) { lenS }
        val lastIdxes = IntArray(26) { 0 }
        for (idx in str.indices) {
            firstIdxes[str[idx] - 'a'] = minOf(firstIdxes[str[idx] - 'a'], idx)
            lastIdxes[str[idx] - 'a'] = maxOf(lastIdxes[str[idx] - 'a'], idx)
        }

        val stack = LinkedList<Range>()

        for (idx in str.indices) {
            val chIdx = str[idx] - 'a'
            // this char has appeared before, so not legit due to invalid condition 2
            if (firstIdxes[chIdx] != idx) continue

            val lo = firstIdxes[chIdx]
            val tail = lastIdxes[chIdx]
            val hi = getHighest(lo, tail, firstIdxes, lastIdxes, str)
            if (hi < 0) continue

            // kind of a mono stack, greedily replacing longer substrings with shorter ones
            // the shorter one has to be completely "within"/overlapped by the longer one
            while (stack.isNotEmpty()
                && lo >= stack.peek().low
                && hi <= stack.peek().high
            ) {
                stack.pop()
            }

            stack.push(Range(lo, hi))
        }

        val ans = ArrayList<String>()
        while (stack.isNotEmpty()) {
            val range = stack.pop()
            ans.add(str.substring(range.low, range.high + 1))
        }
        return ans
    }

    // to find the valid substring range, more importantly the `hi` index,
    // including the whole str.substring[low, high]
    // all letters/chars involved should be covered
    private fun getHighest(
        low: Int,
        high: Int,
        firstIdxes: IntArray,
        lastIdxes: IntArray,
        str: String
    ): Int {

        var hi = high
        var idx = low + 1
        // this has to be a while-loop, instead of a for-loop
        // otherwise, changing `hi` will NOT effect the for-loop range
        while (idx < hi) {
            val chIdx = str[idx] - 'a'
            if (firstIdxes[chIdx] < low) return -1
            hi = maxOf(hi, lastIdxes[chIdx])
            ++idx
        }

        return hi
    }

    // the range of the substring, both ends inclusive
    private data class Range(val low: Int, val high: Int)
}