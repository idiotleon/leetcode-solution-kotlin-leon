package com.idiotleon.summary.byAlgorithm.sort.quickSort

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 *
 * pseudo code:
 *  quickSort(nums, lo, hi)
 *      pivot = partition(nums, lo, hi) #O(hi - 1)
 *      quickSort(nums, lo, pivot)
 *      quickSort(nums, pivot + 1, hi)
 *
 * Time Complexity:
 * Best case:
 *  T(N) = 2 * T(N / 2) + O(N) = O(N * lg(N))
 *
 * Worst case:
 *  the pivot always lands at the beginning of the array, e.g. [1,2,3,4,5,6,7]
 *  T(N) = T(N - 1) + T(1) + O(N) = O(N ^ 2)
 *
 * Non-worst case:
 *  T(N) = T(N / 10) + T(9 * N / 10) + O(N) = O(N * lg(N))
 *
 *
 * Space Complexity:
 *  Best/Average:
 *      O(lg(N))
 *
 *  Worst case:
 *      O(N)
 *
 *
 * References:
 *  https://www.programcreek.com/2012/11/quicksort-array-in-java/
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 */
@Suppress(UNUSED)
class QuickSortPartitionWithMid {}