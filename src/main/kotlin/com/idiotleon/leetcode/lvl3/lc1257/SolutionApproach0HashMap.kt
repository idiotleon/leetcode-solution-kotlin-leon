/**
 * https://leetcode.com/problems/smallest-common-region/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/smallest-common-region/discuss/430500/JavaPython-3-Lowest-common-ancestor-w-brief-explanation-and-analysis.
 */
package com.idiotleon.leetcode.lvl3.lc1257

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun findSmallestRegion(regions: List<List<String>>, region1: String, region2: String): String {
        val parents = hashMapOf<String, String>()
        val ancestors = hashSetOf<String>()

        for (region in regions) {
            val size = region.size
            for (i in 1 until size) {
                parents[region[i]] = region[0]
            }
        }

        var reg1 = region1
        while (reg1.isNotEmpty()) {
            ancestors.add(reg1)
            reg1 = parents[reg1] ?: ""
        }

        var reg2 = region2
        while (!ancestors.contains(reg2)) {
            reg2 = parents[reg2] ?: ""
        }

        return reg2
    }
}