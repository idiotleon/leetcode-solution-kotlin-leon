/**
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 *
 * Time Complexity:     O((`hi` - `lo`) * lg(`hi` - `lo`))
 * Space Complexity:    O(`k`) + O(`hi` - `lo`)
 *
 * References:
 *  https://leetcode.com/problems/sort-integers-by-the-power-value/discuss/679828/Java-hashMap-and-Heap
 */
package com.an7one.leetcode.lvl2.lc1387

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0MaxHeap {
    fun getKth(lo: Int, hi: Int, k: Int): Int {
        val powerMap = hashMapOf(1 to 0)
        val maxHeap = PriorityQueue<Int>(compareBy({ -getPower(it, powerMap) }, { -it }))
        for (num in lo..hi) {
            maxHeap.offer(num)
            if (maxHeap.size > k) maxHeap.poll()
        }

        return maxHeap.peek()
    }

    private fun getPower(num: Int, powerMap: HashMap<Int, Int>): Int {
        powerMap[num]?.let { return it }

        val power = 1 + if (num % 2 == 0) {
            getPower(num / 2, powerMap)
        } else {
            getPower(3 * num + 1, powerMap)
        }

        powerMap[num] = power
        return power
    }
}