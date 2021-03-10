package com.an7one.leetcode.lvl3.lc0890

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val ans = ArrayList<String>()

        for (word in words) {
            if (matches(word, pattern)) {
                ans.add(word)
            }
        }

        return ans
    }

    private fun matches(word: String, pattern: String): Boolean {
        val lenW = word.length
        val lenP = pattern.length

        val hashW = IntArray(26) { 0 }
        val hashP = IntArray(26) { 0 }

        for (idx in 0 until minOf(lenW, lenP)) {
            val idxW = word[idx] - 'a'
            val idxP = pattern[idx] - 'a'
            if (hashW[idxW] != hashP[idxP])
                return false
            hashW[idxW] = idx + 1
            hashP[idxP] = idx + 1
        }

        return true
    }
}