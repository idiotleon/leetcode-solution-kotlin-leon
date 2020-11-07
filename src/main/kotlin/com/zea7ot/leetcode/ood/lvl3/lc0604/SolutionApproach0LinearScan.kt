/**
 * https://leetcode.com/problems/design-compressed-string-iterator/
 *
 * Time Complexities:
 *  initialization:     O(1)
 *  `next()`:           O(1)
 *  `hasNext()`:        O(1)
 *
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/design-compressed-string-iterator/discuss/103872/Straightforward-Java-solution-no-fancy-data-structure
 */
package com.zea7ot.leetcode.ood.lvl3.lc0604

class SolutionApproach0LinearScan(private val compressedString: String) {
    private val lenS = compressedString.length

    private var curCh = compressedString[0]
    private var count = 0
    private var idx = 0

    fun next(): Char {
        if (count == 0) {
            if (idx >= lenS) return ' '

            curCh = compressedString[idx++]
            while (idx < lenS && compressedString[idx] in '0'..'9') {
                count = 10 * count + (compressedString[idx] - '0')
                ++idx
            }
        }

        --count
        return curCh
    }

    fun hasNext(): Boolean = idx < lenS || count > 0

}