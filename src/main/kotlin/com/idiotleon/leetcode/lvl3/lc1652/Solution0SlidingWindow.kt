package com.idiotleon.leetcode.lvl3.lc1652

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/defuse-the-bomb/
 *
 * Time Complexity:     O(`nCodes`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/defuse-the-bomb/solutions/935398/java-o-n-100-time-and-space-short-concise-sliding-window/comments/1728079
 * https://leetcode.com/problems/defuse-the-bomb/solutions/935398/java-o-n-100-time-and-space-short-concise-sliding-window/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    fun decrypt(codes: IntArray, k: Int): IntArray {
        val nCodes = codes.size
        val ans = IntArray(nCodes) { 0 }
        if (k == 0) {
            return ans
        }

        var lo = if (k > 0) 1 else nCodes - (-k)
        var hi = if (k > 0) k else nCodes - 1

        var sum = 0
        for (idx in lo..hi) {
            sum += codes[idx]
        }

        for (idx in 0 until nCodes) {
            ans[idx] = sum
            sum -= codes[lo++ % nCodes]
            sum += codes[++hi % nCodes]
        }

        return ans
    }
}