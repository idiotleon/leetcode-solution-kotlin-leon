package com.idiotleon.leetcode.lvl4.lc0187

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class SolutionApproach1HashSet {
    class SolutionApproach0HashMap {
        private companion object {
            private const val LEN = 10
        }

        fun findRepeatedDnaSequences(s: String): List<String> {
            val lenS = s.length

            val seen = HashSet<String>()
            val output = HashSet<String>()

            var idx = 0
            while (idx + LEN - 1 < lenS) {
                val sub = s.substring(idx, idx + LEN)
                if (seen.contains(sub)) output.add(sub)
                else seen.add(sub)

                ++idx
            }

            return output.toList()
        }
    }
}