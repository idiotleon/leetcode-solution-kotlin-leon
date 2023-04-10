/**
 * https://leetcode.com/problems/tag-validator/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/tag-validator/discuss/103368/Java-Solution:-Use-startsWith-and-indexOf/312693
 *  https://leetcode.com/problems/tag-validator/discuss/103368/Java-Solution%3A-Use-startsWith-and-indexOf
 */
package com.idiotleon.leetcode.lvl4.lc0591

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    fun isValid(code: String): Boolean {
        val lenC = code.length

        val stack = LinkedList<String>()

        var idx = 0

        while (idx < lenC) {
            if (idx > 0 && stack.isEmpty()) return false

            when {
                code.startsWith("<![CDATA[", idx) -> {
                    val hold = idx + 9
                    idx = code.indexOf("]]>", hold)
                    if (idx < 0) return false
                    idx += 3
                }

                code.startsWith("</", idx) -> {
                    val hold = idx + 2
                    idx = code.indexOf('>', hold)
                    if (idx < 0 || idx == hold || idx - hold > 9) return false

                    for (k in hold until idx) {
                        if (!code[k].isUpperCase()) return false
                    }

                    val substr = code.substring(hold, idx)
                    ++idx
                    if (stack.isEmpty() || stack.pop() != substr) return false
                }

                code.startsWith("<", idx) -> {
                    val hold = idx + 1
                    idx = code.indexOf(">", hold)
                    if (idx < 0 || idx == hold || idx - hold > 9) return false

                    for (k in hold until idx) {
                        if (!code[k].isUpperCase()) return false
                    }

                    val substr = code.substring(hold, idx)
                    ++idx
                    stack.push(substr)
                }

                else -> ++idx
            }
        }

        return stack.isEmpty()
    }
}