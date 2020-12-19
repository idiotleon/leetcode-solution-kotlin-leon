/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Time Complexity:     O(`n` ^ 2)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/unique-binary-search-trees/discuss/31696/Simple-Recursion-Java-Solution-with-Explanation/30507
 *  https://leetcode.com/problems/unique-binary-search-trees/discuss/31696/Simple-Recursion-Java-Solution-with-Explanation
 */
import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun numTrees(n: Int): Int {
        val memo = Array<Int?>(n + 1) { null }
        return dfs(n, memo)
    }

    private fun dfs(n: Int, memo: Array<Int?>): Int {
        memo[n]?.let { return it }

        if (n <= 1) return 1

        var total = 0

        for (i in 1..n) {
            total += dfs(i - 1, memo) * dfs(n - i, memo)
        }

        memo[n] = total
        return total
    }
}