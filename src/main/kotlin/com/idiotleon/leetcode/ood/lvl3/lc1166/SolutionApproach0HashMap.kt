package com.idiotleon.leetcode.ood.lvl3.lc1166

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/design-file-system/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/design-file-system/discuss/365901/JavaPython-3-7-line-simple-HashMap-code-w-analysis.
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    private val file = HashMap<String, Int>()

    init {
        file[""] = -1
    }

    fun createPath(path: String, value: Int): Boolean {
        val idx = path.lastIndexOf("/")
        val parent = path.substring(0, idx)
        if (!file.containsKey(parent)) return false
        return file.putIfAbsent(path, value) == null
    }

    fun get(path: String) = file[path] ?: -1
}