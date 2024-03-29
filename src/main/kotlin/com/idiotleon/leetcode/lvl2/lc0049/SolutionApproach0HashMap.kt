package com.idiotleon.leetcode.lvl2.lc0049

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/group-anagrams/
 *
 * Time Complexity:     O(`nStrs` * avgLenStr)
 * Space Complexity:    O(`nStrs` * avgLenStr)
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // not used
        // val nStrs = strs.size

        val hashToStrs = HashMap<Int, MutableList<String>>()
        for (str in strs) {
            hashToStrs.getOrPut(hash(str)) { mutableListOf() }.add(str)
        }

        return hashToStrs.values.toList()
    }

    private fun hash(str: String): Int {
        val freqs = IntArray(26) { 0 }
        for (ch in str) {
            ++freqs[ch - 'a']
        }
        return freqs.contentHashCode()
    }
}