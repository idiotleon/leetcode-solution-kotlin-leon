package com.idiotleon.leetcode.lvl2.lc1456

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 *
 * Time Complexity:     O(5 * `lenS`) ~ O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1) + O(5) ~ O(`lenS`) / O(1)
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    private companion object {
        private val VOWELS = arrayOf('a', 'e', 'i', 'o', 'u')
    }

    fun maxVowels(str: String, k: Int): Int {
        val lenS = str.length

        var hi = 0
        var most = 0
        // vowel count
        var count = 0
        while (hi < lenS) {
            if (isVowel(str[hi])) {
                ++count
                most = maxOf(most, count)
            }

            if (hi + 1 >= k) {
                val lo = hi - k + 1
                if (isVowel(str[lo])) {
                    --count
                }
            }

            ++hi
        }

        return most
    }

    private fun isVowel(ch: Char): Boolean {
        for (vowel in VOWELS) {
            if (ch == vowel) {
                return true
            }
        }

        return false
    }
}