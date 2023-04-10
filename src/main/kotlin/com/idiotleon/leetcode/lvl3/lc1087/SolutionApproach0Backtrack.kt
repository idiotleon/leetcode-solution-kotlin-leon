/**
 * https://leetcode.com/problems/brace-expansion/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/brace-expansion/discuss/327977/Classic-backtracking-solution
 */
package com.idiotleon.leetcode.lvl3.lc1087

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private const val OPEN_BRACKET = '{'
        private const val CLOSED_BRACKET = '}'
    }

    fun expand(str: String): Array<String> {
        val ans = mutableListOf<String>()
        val builder = StringBuilder()
        backtrack(0, builder, str, ans)

        return ans.toTypedArray()
    }

    private fun backtrack(idx: Int, builder: StringBuilder, str: String, res: MutableList<String>) {
        val lenS = str.length
        if (idx == lenS) {
            if (builder.isNotEmpty()) {
                res.add(builder.toString())
            }
            return
        }

        when (val curCh = str[idx]) {
            OPEN_BRACKET -> {
                val chs = mutableListOf<Char>()
                var idxEnd = idx + 1
                while (idxEnd < lenS && str[idxEnd] != CLOSED_BRACKET) {
                    if (str[idxEnd] in 'a'..'z') {
                        chs.add(str[idxEnd])
                    }

                    ++idxEnd
                }

                chs.sort()
                val len = builder.length
                for (ch in chs) {
                    // to further backtrack to the next state
                    builder.append(ch)
                    backtrack(idxEnd + 1, builder, str, res)
                    // to backtrack to the previous state
                    builder.setLength(len)
                }
            }
            in 'a'..'z' -> {
                builder.append(curCh)
                backtrack(idx + 1, builder, str, res)
            }
            else -> {

            }
        }
    }
}