package com.idiotleon.leetcode.ood.lvl3.lc1352

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 *
 * Time Complexity:
 *  `add()`:            O(1)
 *  `add()`:            O(1)
 * Space Complexity:    O(N)
 *
 * Reference:
 * https://leetcode.com/problems/product-of-the-last-k-numbers/editorial/
 */
@Suppress(UNUSED)
class Solution0PrefixProducts(
    private val prefixProducts: MutableList<Int> = mutableListOf<Int>(1),
    private var size: Int = 0,
) {
    fun add(num: Int) {
        if (num == 0) {
            this.prefixProducts.clear()
            this.prefixProducts.add(1)
            this.size = 0
        } else {
            this.prefixProducts.add(this.prefixProducts.last() * num)
            ++this.size
        }
    }

    fun getProduct(k: Int): Int {
        if (k > this.size) {
            return 0
        }

        return this.prefixProducts[this.size] / this.prefixProducts[this.size - k]
    }
}