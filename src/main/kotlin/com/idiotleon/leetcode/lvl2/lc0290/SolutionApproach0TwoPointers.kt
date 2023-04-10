package com.idiotleon.leetcode.lvl2.lc0290

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/word-pattern/
 *
 * Time Complexity:     O(`lenP`) + O(`nWords` * lenW) ~ O(`nWords` * lenW)
 * Space Complexity:    O(`nWords` * lenW)
 *
 * References:
 *  https://leetcode.com/problems/word-pattern/discuss/73399/Very-fast-(3ms)-Java-Solution-using-HashMap
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    private companion object {
        private const val SPACE = ' '
    }

    fun wordPattern(pattern: String, str: String): Boolean {
        val lenP = pattern.length;
        val words = str.split(SPACE);
        val nWords = words.size;

        if (lenP != nWords)
            return false;

        val map = HashMap<Char, String>();
        val seen = HashSet<String>();

        for (i in pattern.indices) {
            val ch = pattern[i];
            val word = words[i];

            if (map.containsKey(ch)) {
                if (map[ch] != word)
                    return false;
            } else {
                // `word`, represented by one pattern,
                // cannot be represented by another pattern.
                if (!seen.add(word))
                    return false;

                map[ch] = word;
            }
        }

        return true;
    }
}