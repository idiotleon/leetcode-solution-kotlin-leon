package com.an7one.leetcode.lvl2.lc0811

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/subdomain-visit-count/
 *
 * Time Complexity:     O(`nDomains` * `lenS`)
 * Space Complexity:    O(`nDomains` * `lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/subdomain-visit-count/discuss/121738/C%2B%2BJavaPython-Easy-Understood-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    private companion object {
        private const val DOT = '.'
        private const val SPACE = ' '
    }

    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        // not used
        // val nDomains = cpdomains.size

        val freqs = HashMap<String, Int>()

        for (domain in cpdomains) {
            val idx = domain.indexOf(SPACE)
            val num = domain.substring(0, idx).toInt()

            val str = domain.substring(idx + 1)
            for (idxS in str.indices) {
                if (str[idxS] == DOT) {
                    val seg = str.substring(idxS + 1)
                    freqs[seg] = num + (freqs[seg] ?: 0)
                }
            }

            freqs[str] = num + (freqs[str] ?: 0)
        }

        val ans = ArrayList<String>()
        for ((str, freq) in freqs) {
            ans.add("$freq $str")
        }
        return ans
    }
}