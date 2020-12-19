/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 *
 * Time Complexity:     O((`totalPaths` * lenPath) ^ 2)
 *  lenPath, the average length of path(String)
 *
 * Space Complexity:    O(`totalPaths` * lenPath)
 *  lenPath, the average length of path(String)
 *
 * References:
 *  https://leetcode.com/problems/find-duplicate-file-in-system/discuss/104134/Java-Solution-HashMap
 */
package com.zea7ot.leetcode.lvl3.lc0609

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    private companion object {
        private const val SPACE = ' '
        private const val OPEN_PAREN = '('
        private const val SLASH = '/'
    }

    fun findDuplicate(paths: Array<String>): List<List<String>> {
        // not used
        // val totalPaths = paths.size

        val ans = ArrayList<List<String>>()
        // not required
        // if(paths.isEmpty()) return ans

        val map = HashMap<String, HashSet<String>>()
        for (path in paths) {
            val strs = path.split(SPACE)
            val dir = strs[0]
            val totalStrs = strs.size

            for (idx in 1 until totalStrs) {
                val str = strs[idx]
                val contentIdx = str.indexOf(OPEN_PAREN)
                val content = str.substring(contentIdx + 1)
                    .also { it.dropLast(1) } // to trim both chars '(' and ')'                val fileName = dir + SLASH + str.substring(0, contentIdx)
                val fileName = dir + SLASH + str.substring(0, contentIdx)
                map.getOrPut(content) { hashSetOf() }.add(fileName)
            }
        }

        for ((_, pathSet) in map) {
            if (pathSet.size > 1) {
                ans.add(pathSet.toList())
            }
        }

        return ans
    }
}