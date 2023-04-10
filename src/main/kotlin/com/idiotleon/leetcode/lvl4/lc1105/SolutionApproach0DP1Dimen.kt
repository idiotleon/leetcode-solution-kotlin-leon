/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 *
 * Time Complexity:     O(`totalBooks` ^ 2)
 * Space Complexity:    O(`totalBooks`)
 *
 * to split the array into several subarrays, and minimize their max values
 *
 * `dp[i]`, minimum height to place `books[0]` ~ `books[i]`
 * dp[j] = min{dp[i - 1] + H}, 0 < i < j
 *  H = max(height[i ~ j]), given that sum(width[i ~ j]) <= maxWidth
 * ans: dp[`totalBooks`]
 *
 * References:
 *  https://leetcode.com/problems/filling-bookcase-shelves/discuss/323315/Java-DP-solution
 *  https://leetcode.com/problems/filling-bookcase-shelves/discuss/323315/Java-DP-solution/352190
 *  https://youtu.be/FLbqgyJ-70I?t=3249
 */
package com.idiotleon.leetcode.lvl4.lc1105

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
        val totalBooks = books.size

        val dp = IntArray(totalBooks + 1) { 0 }

        for (i in 1..totalBooks) {
            var width = books[i - 1][0]
            var height = books[i - 1][1]
            dp[i] = dp[i - 1] + height

            for (j in i - 1 downTo 1) {
                height = maxOf(height, books[j - 1][1])
                width += books[j - 1][0]
                if (width > shelfWidth) break
                dp[i] = minOf(dp[i], dp[j - 1] + height)
            }
        }

        return dp[totalBooks]
    }
}