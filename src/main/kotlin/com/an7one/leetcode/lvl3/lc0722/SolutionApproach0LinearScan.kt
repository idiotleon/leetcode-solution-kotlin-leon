/**
 * https://leetcode.com/problems/remove-comments/
 *
 * Time Complexity:     O(`n` * `lenS`)
 * Space Complexity:    O(`n` * `lenS`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/remove-comments/discuss/161789/Logical-Thinking-with-Code-Beats-99.68/396622
 */
package com.an7one.leetcode.lvl3.lc0722

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val ASTERISK = '*'
        private const val SLASH = '/'
    }

    fun removeComments(sources: Array<String>): List<String> {
        val ans = ArrayList<String>()

        var isBlockComment = false
        val builder = StringBuilder()

        outer@ for (src in sources) {
            val lenS = src.length

            var idx = 0
            inner@ while (idx < lenS) { // to process each line
                if (isBlockComment) {
                    if (idx + 1 < lenS && src[idx] == ASTERISK && src[idx + 1] == SLASH) {
                        isBlockComment = false // to exist the block comment
                        ++idx // to skip '/'
                    }
                } else {
                    when {
                        idx + 1 < lenS && src[idx] == SLASH && src[idx + 1] == SLASH -> break@inner // to skip the rest of the line

                        idx + 1 < lenS && src[idx] == SLASH && src[idx + 1] == ASTERISK -> {
                            isBlockComment = true // to enter the block comment
                            ++idx // to skip '*'
                        }

                        else -> builder.append(src[idx])
                    }
                }

                ++idx
            }

            if (!isBlockComment && builder.isNotEmpty()) {
                ans.add(builder.toString())
                builder.clear()
            }
        }

        return ans
    }
}