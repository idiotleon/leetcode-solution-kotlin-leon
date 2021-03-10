package com.an7one.leetcode.lvl4.lc0187

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

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