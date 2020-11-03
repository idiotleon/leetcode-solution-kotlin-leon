/**
 * https://leetcode.com/problems/html-entity-parser/
 *
 * Time Complexity:     O(`lenT`)
 * Space Complexity:    O(`lenT`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/html-entity-parser/discuss/738731/Java-Solution-using-StringBuilder-and-Map
 */
package com.zea7ot.leetcode.ood.lvl2.lc1410

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    private companion object {
        private val map = hashMapOf(
                "&quot;" to "\"",
                "&apos;" to "'",
                "&amp;" to "&",
                "&gt;" to ">",
                "&lt;" to "<",
                "&frasl;" to "/")

        private const val AMPERSAND = '&'
        private const val SEMICOLON = ';'
    }

    fun entityParser(text: String): String {
        // not used
        // val lenT = text.length

        val builder = StringBuilder()
        val entity = StringBuilder()

        // parsing started or not
        var started = false

        for (ch in text) {
            when (ch) {
                AMPERSAND -> {
                    entity.append(ch)
                    started = true
                }

                SEMICOLON -> {
                    entity.append(ch)

                    val str = entity.toString()
                    builder.append(map[str] ?: str)
                    entity.clear()

                    started = false
                }

                else -> {
                    if (started) entity.append(ch)
                    else builder.append(ch)
                }
            }
        }

        return builder.append(entity).toString()
    }
}