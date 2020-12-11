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
package com.zea7ot.leetcode.lvl3.lc0254

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun getFactors(n: Int): List<List<Int>> {
        val paths = mutableListOf<List<Int>>()
        if (n == 1) return paths

        val path = mutableListOf<Int>()
        backtrack(n, 2, path, paths)

        return paths
    }

    private fun backtrack(n: Int,
                          factorStart: Int,
                          path: MutableList<Int>,
                          paths: MutableList<List<Int>>) {

        if (n == 1 && path.size > 1) {
            paths.add(path.toList())
            return
        }

        var factor = factorStart
        while (factor * factor <= n) {
            if (n % factor == 0) {
                path.add(factor)
                path.add(n / factor)
                paths.add(path.toList())
                path.removeAt(path.size - 1)
                backtrack(n / factor, factor, path, paths)
                path.removeAt(path.size - 1)
            }

            ++factor
        }
    }
}