/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Time Complexity:     O(`n` ^ 2)
 * Space Complexity:    O(`n`)
 *
 * `dp[k]`, the number of BSTs built from 1...k
 *
 * to build a tree, one needs to pick a `root` node,
 *  and know how many possible left and right subtrees can be built under that node.
 *  The result is to multiply them.
 *
 * References:
 *  https://leetcode.com/problems/unique-binary-search-trees/discuss/31707/Fantastic-Clean-Java-DP-Solution-with-Detail-Explaination
 *  https://leetcode.com/problems/unique-binary-search-trees/discuss/703488/Detailed-Explanation-%3A-Mental-Leap-on-Why-the-approach-actually-works
 *  https://leetcode-cn.com/problems/unique-binary-search-trees/solution/shou-hua-tu-jie-san-chong-xie-fa-dp-di-gui-ji-yi-h/
 *
 * Catalan number:
 *  https://en.wikipedia.org/wiki/Catalan_number
 */
package com.an7one.leetcode.lvl3.lc0096

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun numTrees(n: Int): Int {
        val dp = IntArray(n + 1) { 0 }.also {
            it[0] = 1
            it[1] = 1
        }

        for (level in 2..n) {
            for (root in 1..level) {
                dp[level] += dp[level - root] * dp[root - 1]
            }
        }

        return dp[n]
    }
}