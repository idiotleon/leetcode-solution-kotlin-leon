package com.idiotleon.leetcode.lvl5.lc0736

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/parse-lisp-expression/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/parse-lisp-expression/discuss/113902/A-Clean-Java-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    fun evaluate(expression: String): Int {
        val memo = HashMap<String, Int>()
        return eval(expression, memo)
    }

    private fun eval(exp: String, tokenToVal: HashMap<String, Int>): Int {
        val lenE = exp.length
        if (exp[0] != '(') {
            if (exp[0] in '0'..'9' || exp[0] == '-') {
                return exp.toInt()
            }

            return tokenToVal[exp]!!
        }

        val memo = HashMap(tokenToVal)

        val substr = exp.substring(if (exp[1] == 'm') 6 else 5, lenE - 1)
        val tokens = parseTokens(substr)
        val nTokens = tokens.size

        return when {
            exp.startsWith("(a") -> eval(tokens[0], memo) + eval(tokens[1], memo) // add
            exp.startsWith("(m") -> eval(tokens[0], memo) * eval(tokens[1], memo) // mult
            else -> { // let
                for (idx in 0 until nTokens - 2 step 2) {
                    memo[tokens[idx]] = eval(tokens[idx + 1], memo)
                }

                return eval(tokens[nTokens - 1], memo)
            }
        }
    }

    private fun parseTokens(expression: String): List<String> {
        val tokens = mutableListOf<String>()
        var cntMatch = 0
        val builder = StringBuilder()

        for (ch in expression) {
            if (ch == '(') ++cntMatch
            if (ch == ')') --cntMatch
            if (cntMatch == 0 && ch == ' ') {
                tokens.add(builder.toString())
                builder.clear()
            } else {
                builder.append(ch)
            }
        }

        if (builder.isNotEmpty()) {
            tokens.add(builder.toString())
        }

        return tokens
    }
}