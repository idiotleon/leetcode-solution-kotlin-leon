package com.idiotleon.leetcode.lvl2.lc0049

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/group-anagrams/
 *
 * Time Complexity:     O(`nStrs` * avgLenStr)
 * Space Complexity:    O(`nStrs` * avgLenStr)
 *
 * Bitmask does not apply here.
 * Because not only the position of the char is needed,
 * but also the actual amount.
 */
@Suppress(UNUSED)
class Solution0HashMap {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val nStrs = strs.size

        val hashToStrs = HashMap<Int, MutableList<String>>(nStrs)
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