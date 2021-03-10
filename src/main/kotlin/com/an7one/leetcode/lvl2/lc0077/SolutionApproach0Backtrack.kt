/**
 * https://leetcode.com/problems/combinations/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/combinations/discuss/27002/Backtracking-Solution-Java
 */
package com.an7one.leetcode.lvl2.lc0077

class SolutionApproach0Backtrack {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val paths = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        backtrack(1, n, k, path, paths)
        return paths
    }

    private fun backtrack(
        idxStart: Int, n: Int, k: Int,
        path: MutableList<Int>,
        paths: MutableList<List<Int>>
    ) {
        if (k == 0) {
            paths.add(path.toList())
            return
        }

        for (idx in idxStart..n) {
            path.add(idx)
            backtrack(idx + 1, n, k - 1, path, paths)
            path.removeAt(path.size - 1)
        }
    }
}