package com.idiotleon.util

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class UtilSort {
    companion object {
        fun <T : Comparable<T>> isSortedAscending(arr: Array<T>) = isSortedAscending(arr.toList())
        fun <T : Comparable<T>> isSortedDescending(arr: Array<T>) = isSortedDescending(arr.toList())

        fun <T : Comparable<T>> isSortedAscending(list: List<T>) = isSortedAscending(0, list.size - 1, list)
        fun <T : Comparable<T>> isSortedDescending(list: List<T>) = isSortedDescending(0, list.size - 1, list)


        fun <T : Comparable<T>> isSortedAscending(lo: Int, hi: Int, arr: List<T>): Boolean {
            for (idx in lo + 1..hi) {
                if (isLarger(arr[idx - 1], arr[idx])) return false
            }

            return true
        }

        fun <T : Comparable<T>> isSortedDescending(lo: Int, hi: Int, arr: List<T>): Boolean {
            for (idx in lo + 1..hi) {
                if (isSmaller(arr[idx - 1], arr[idx])) return false
            }

            return true
        }

        private fun <T : Comparable<T>> isLarger(v: T, w: T) =
            if (v == w) false
            else v > w

        private fun <T : Comparable<T>> isSmaller(v: T, w: T) =
            if (v == w) false // optimization when reference equals
            else v < w
    }
}