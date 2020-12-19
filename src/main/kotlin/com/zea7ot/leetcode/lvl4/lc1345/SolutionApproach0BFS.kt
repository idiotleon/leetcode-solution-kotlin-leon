/**
 * https://leetcode.com/problems/jump-game-iv/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * double-end BFS
 *
 * References:
 *  https://leetcode.com/problems/jump-game-iv/discuss/507950/Java-Bidirectional-BFS
 */
package com.zea7ot.leetcode.lvl4.lc1345

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun minJumps(nums: IntArray): Int {
        val totalNums = nums.size
        if (totalNums == 1) return 0

        // a map of value to indexes of `nums`
        val idxMap = HashMap<Int, ArrayList<Int>>()
        for (idx in totalNums - 1 downTo 0) {
            idxMap.getOrPut(nums[idx]) { arrayListOf() }.add(idx)
        }

        val visited = BooleanArray(totalNums) { false }

        var head = HashSet<Int>()
        head.add(0)
        visited[0] = true

        var tail = HashSet<Int>()
        tail.add(totalNums - 1)
        visited[totalNums - 1] = true

        var steps = 0

        while (head.isNotEmpty() && tail.isNotEmpty()) {
            if (head.size > tail.size) {
                head = tail.also { tail = head }
            }

            val next = HashSet<Int>()
            for (idx in head) {
                val hiNext = idx + 1
                if (tail.contains(hiNext)) return steps + 1
                if (hiNext in 0 until totalNums && !visited[hiNext]) {
                    next.add(hiNext)
                }

                val loNext = idx - 1
                if (tail.contains(loNext)) return steps + 1
                if (loNext in 0 until totalNums && !visited[loNext]) {
                    next.add(loNext)
                }

                idxMap[nums[idx]]?.let {
                    for (equalValueNext in it) {
                        if (tail.contains(equalValueNext)) return steps + 1

                        if (visited[equalValueNext]) continue
                        next.add(equalValueNext)
                        visited[equalValueNext] = true
                    }

                    // to save time
                    // there is no need to check visited/seen at all later on
                    it.clear()
                }
            }

            head = next
            ++steps
        }

        return -1
    }
}