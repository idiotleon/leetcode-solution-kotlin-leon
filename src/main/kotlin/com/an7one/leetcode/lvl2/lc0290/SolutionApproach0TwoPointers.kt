/**
 * https://leetcode.com/problems/word-pattern/
 *
 * Time Complexity:     O(`lenP`) + O(`totalWords` * lenW) ~ O(`totalWords` * lenW)
 * Space Complexity:    O(`totalWords` * lenW)
 *
 * References:
 *  https://leetcode.com/problems/word-pattern/discuss/73399/Very-fast-(3ms)-Java-Solution-using-HashMap
 */
package com.an7one.leetcode.lvl2.lc0290

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    private companion object {
        private const val SPACE = ' '
    }

    fun wordPattern(pattern: String, str: String): Boolean {
        val lenP = pattern.length;
        val words = str.split(SPACE);
        val totalWords = words.size;

        if (lenP != totalWords)
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