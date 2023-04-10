package com.idiotleon.leetcode.ood.lvl3.lc1352

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 *
 * Time Complexities:
 *  `add()`:            O(1)
 *  `getProduct()`:     O(1)
 *
 * Space Complexity:    O(N)
 *  N, number of calls
 *
 * Reference:
 * https://leetcode.com/problems/product-of-the-last-k-numbers/discuss/510260/JavaC%2B%2BPython-Prefix-Product
 */
@Suppress(UNUSED)
class SolutionApproach0PrefixProducts {
    private var prefixProducts = arrayListOf(1)

    fun add(num: Int) {
        if (num > 0) {
            prefixProducts.add(prefixProducts.last() * num)
        } else {
            // `arraylist.clear()` is O(N), while `arraylist.removeAll()` costs even more
            prefixProducts = arrayListOf(1)
        }
    }

    fun getProduct(k: Int): Int {
        val nNums = prefixProducts.size

        return if (k < nNums) prefixProducts[nNums - 1] / prefixProducts[nNums - k - 1] else 0
    }
}