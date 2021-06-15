/**
 * @author: Leon
 * https://leetcode.com/problems/count-items-matching-a-rule/
 *
 * Time Complexity:     O(`nItems` * (lenRuleKey + lenRuleValue))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl1.lc1773

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val RULE_KEY_TYPE = "type"
        private const val RULE_KEY_COLOR = "color"
        private const val RULE_KEY_NAME = "name"
    }

    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
        // not used
        // val nItems = items.size

        var count = 0

        for ((type, color, name) in items) {
            when (ruleKey) {
                RULE_KEY_TYPE -> if (ruleValue == type) ++count
                RULE_KEY_COLOR -> if (ruleValue == color) ++count
                RULE_KEY_NAME -> if (ruleValue == name) ++count
                else -> {
                }
            }
        }

        return count
    }
}