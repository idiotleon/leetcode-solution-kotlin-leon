package com.an7one.leetcode.lvl2.lc0290

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/word-pattern/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun wordPattern(pattern: String, str: String): Boolean {
        val len = pattern.length
        val arr: List<String> = str.split(" ")
        val size = arr.size

        if (size != len)
            return false

        val map = HashMap<Char, String>()
        val seen: MutableSet<String> = HashSet()

        val chs: CharArray = pattern.toCharArray()
        for (i in 0 until size) {
            val ch = chs[i]
            val word = arr[i]

            if (map.containsKey(ch)) {
                if (map[ch] != word)
                    return false
            } else {
                if (!seen.add(word))
                    return false
                map[ch] = word
            }
        }

        return true
    }
}