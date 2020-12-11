/**
 * https://leetcode.com/problems/video-stitching/
 *
 * Time Complexity:     O(`nClips` * lg(`nClips`))
 * Space Complexity:    O(`RANGE`)
 *
 * References:
 *  https://leetcode.com/problems/video-stitching/discuss/270036/JavaC++Python-Greedy-Solution-O(1)-Space/259274
 *  https://leetcode.com/problems/video-stitching/discuss/270036/JavaC%2B%2BPython-Greedy-Solution-O(1)-Space
 */
package com.zea7ot.leetcode.lvl4.lc1024

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    private companion object {
        private const val RANGE = 100
    }

    fun videoStitching(clips: Array<IntArray>, T: Int): Int {
        // not used
        // val nClips = clips.size

        clips.sortWith(compareBy({ it[0] }, { it[1] }))

        // to build up the time travel tunnel
        val jumpMap = IntArray(RANGE) { 0 }
        for (clip in clips) {
            val (start, end) = clip
            jumpMap[start] = end
        }
        if (jumpMap[0] == 0) return -1

        var count = 1
        var lo = 0
        // to keep track of currently the furthest point
        var curEnd = jumpMap[0]

        // to greedily reach `T`
        while (lo < T && curEnd < T) {
            var longestJump = 0
            var idxLongestJump = -1

            // to jump as far as possible,
            // and keep track of the longest jump and its index
            for (hi in curEnd downTo lo + 1) {
                if (jumpMap[hi] > longestJump) {
                    longestJump = jumpMap[hi]
                    idxLongestJump = hi
                }
            }

            // if it cannot jump further,
            // or it cannot reach the `curEnd`,
            // to return impossible
            if (idxLongestJump == -1 || longestJump <= curEnd) return -1

            // otherwise, to jump to the furthest point,
            // and repeat the above process
            ++count
            lo = idxLongestJump
            curEnd = jumpMap[lo]
        }

        return count
    }
}