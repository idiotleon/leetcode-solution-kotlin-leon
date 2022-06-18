package com.an7one.leetcode.lvl5.lc0140

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/word-break-ii/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS/43414
 *  https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS/215095
 *  https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        // not used
        // val lenS = s.length

        val wordSet = HashSet(wordDict)
        val memo = HashMap<String, List<String>>()
        return dfs(s, wordSet, memo)
    }

    private fun dfs(
        str: String,
        wordSet: HashSet<String>,
        memo: HashMap<String, List<String>>
    ): List<String> {

        memo[str]?.let { return it }

        val res = ArrayList<String>()
        if (wordSet.contains(str)) res.add(str)

        for (idx in str.indices) {
            val curSub = str.substring(idx)
            if (!wordSet.contains(curSub)) continue
            val nextSubs = dfs(str.substring(0, idx), wordSet, memo)
            if (nextSubs.isEmpty()) continue
            for (nextSub in nextSubs) res.add("$nextSub $curSub")
        }

        memo[str] = res
        return res
    }
}