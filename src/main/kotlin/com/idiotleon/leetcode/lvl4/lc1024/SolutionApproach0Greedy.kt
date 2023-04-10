/**
 * https://leetcode.com/problems/video-stitching/
 *
 * Time Complexity:     O(`nClips` + `T`) ~ O(max(`nClips`, `T`))
 * Space Complexity:    O(`RANGE`)
 *
 * References:
 *  https://leetcode.com/problems/video-stitching/discuss/270680/C++-O(N)-No-Sorting-(Greedy)-Explained/260205
 *  https://leetcode.com/problems/video-stitching/discuss/270680/C%2B%2B-O(N)-No-Sorting-(Greedy)-Explained
 */
package com.idiotleon.leetcode.lvl4.lc1024

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    private companion object {
        private const val RANGE = 100 + 1
    }

    fun videoStitching(clips: Array<IntArray>, T: Int): Int {
        // not used
        // val nClips = clips.size

        // or call it `jumpMap`, our time travel tunnel
        val clipEnds = IntArray(RANGE) { -1 }
        for ((start, end) in clips) {
            // to greedily keep track of the furthest video clip time.
            // please be reminded that `clips` is not sorted
            clipEnds[start] = maxOf(clipEnds[start], end)
        }

        var curEnd = -1
        var maxEnd = 0
        var count = 0

        for (sec in 0..T) { // the current second/time
            if (sec > maxEnd) break
            maxEnd = maxOf(maxEnd, clipEnds[sec])

            if (sec >= curEnd) {
                ++count
                curEnd = maxEnd
                if (curEnd >= T) return count
            }
        }

        return -1
    }
}