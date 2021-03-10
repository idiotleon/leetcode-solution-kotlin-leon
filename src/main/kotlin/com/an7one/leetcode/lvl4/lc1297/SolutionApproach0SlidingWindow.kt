/**
 * https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
 *
 * Time Complexity:     O(26 * L) ~ O(L)
 * Space Complexity:    O(L) + O(26) ~ O(L)
 *
 *
 * The greedy part of the solution is that, we also notice that we only need `minSize`,
 *  since if the `minSize` satisfies the constraints that distinct letters <= `maxLetters`,
 *  any substring greater than that size would only add at max a new distinct letter.
 *
 * This essentially means that since the substring of size greater than `minSize` satisfies the constraint of distinct letters <= `maxLetters`,
 *  there will be a substring of this selected substring of length `minSize`,
 *  that'll satisfy the same constraint and the frequency of this substring will be at least as much as the parent substring.
 *
 * We also know that number of shorter substrings are more than the longer ones,
 *  thus we only need to check for substrings of `minSize` satisfying the condition.
 *
 *
 * References:
 *  https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/discuss/457577/C++-Greedy-approach-+-Sliding-window-O(n)./411614
 *  https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/discuss/457577/C%2B%2B-Greedy-approach-%2B-Sliding-window-O(n).
 */
package com.an7one.leetcode.lvl4.lc1297

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.Constant.Annotation.UNUSED_PARAMETER

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    @Suppress(UNUSED_PARAMETER)
    fun maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int {
        // sanity check
        if (s.isEmpty()) return 0

        val lenS = s.length

        val subOccurMap = HashMap<String, Int>()
        val freqs = IntArray(26)

        var lo = 0
        var hi = 0
        var distinct = 0

        var maxOccur = 0

        while (hi < lenS) {
            if (freqs[s[hi] - 'a']++ == 0) ++distinct

            while (distinct > maxLetters || (hi - lo + 1) > minSize) {
                if (--freqs[s[lo] - 'a'] == 0) --distinct

                ++lo
            }

            if (hi - lo + 1 == minSize) {
                val sub = s.substring(lo, hi + 1)
                val occurrence = (subOccurMap[sub] ?: 0) + 1
                subOccurMap[sub] = occurrence
                maxOccur = maxOf(maxOccur, occurrence)
            }

            ++hi
        }

        return maxOccur
    }
}