/**
 * https://leetcode.com/problems/factor-combinations/
 *
 * Time Complexity:     ?O(n * lg(n))
 * Space Complexity:    ?O(n * lg(n))
 *
 * References:
 *  https://leetcode.com/problems/factor-combinations/discuss/68040/My-Recursive-DFS-Java-Solution/165582
 *  https://leetcode.com/problems/factor-combinations/discuss/68040/My-Recursive-DFS-Java-Solution/159196
 */
package com.zea7ot.lc.lvl3.lc0254

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun getFactors(n: Int): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        // sanity check
        if (n == 1) return ans

        backtrack(n, 2, mutableListOf(), ans)
        return ans
    }

    private fun backtrack(n: Int,
                          start: Int,
                          path: MutableList<Int>,
                          paths: MutableList<MutableList<Int>>): Unit {

        if (n == 1 && path.size > 1) {
            paths.add(path.toMutableList())
            return
        }

        var i = start
        while (i * i <= n) {
            if (n % i == 0) {
                path.add(i)
                path.add(n / i)
                paths.add(path.toMutableList())
                path.remove(path.last())
                backtrack(n / i, i, path, paths)
                path.remove(path.last())
            }

            ++i
        }
    }
}