/**
 * https://leetcode.com/problems/unique-email-addresses/
 *
 * Time Complexity:     O(`nEmail` * `lenE`)
 * Space Complexity:    O(`nEmail` * `lenE`)
 *
 * References:
 *  https://leetcode.com/problems/unique-email-addresses/discuss/186798/JavaPython-3-7-and-6-liners-with-comment-and-analysis./194310
 *  https://leetcode.com/problems/unique-email-addresses/discuss/186798/JavaPython-3-7-and-6-liners-with-comment-and-analysis.
 */
package com.zea7ot.leetcode.lvl2.lc0929

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    private companion object {
        private const val SIGN_DOT = '.'
        private const val SIGN_PLUS = '+'
        private const val SIGN_AT = '@'
    }

    fun numUniqueEmails(emails: Array<String>): Int {
        // not used
        // val nEmails = emails.size

        val emailSet = HashSet<String>()

        outer@ for (email in emails) {
            val lenE = email.length
            val builder = StringBuilder()

            inner@ for (lo in email.indices) {
                when (val ch = email[lo]) {
                    SIGN_DOT -> continue@inner
                    SIGN_PLUS -> {
                        var hi = lenE - 1
                        while (email[hi] != SIGN_AT) --hi
                        builder.append(email.substring(hi))
                        break@inner
                    }
                    SIGN_AT -> {
                        builder.append(email.substring(lo))
                        break@inner
                    }
                    else -> builder.append(ch)
                }
            }

            emailSet.add(builder.toString())
        }

        return emailSet.size
    }
}