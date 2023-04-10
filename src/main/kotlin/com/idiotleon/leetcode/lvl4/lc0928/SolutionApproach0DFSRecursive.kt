/**
 * https://leetcode.com/problems/minimize-malware-spread-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/minimize-malware-spread-ii/discuss/184645/Straightforward-DFS-Java-6-ms
 */
package com.idiotleon.leetcode.lvl4.lc0928

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun minMalwareSpread(graph: Array<IntArray>, initials: IntArray): Int {
        initials.sort()

        val malSet = HashSet<Int>()
        for (initial in initials) malSet.add(initial)

        var max = -1
        var res = -1

        for (malware in initials) {
            var save = 0
            val seen = HashSet<Int>()
            seen.add(malware)

            for (idx in graph.indices) {
                if (idx != malware && graph[malware][idx] == 1) {
                    val temp = dfs(idx, seen, malSet, graph)
                    if (temp < 0) continue
                    save += temp
                }
            }

            if (save > max) {
                res = malware
                max = save
            }
        }

        return res
    }

    private fun dfs(
        cur: Int,
        seen: HashSet<Int>,
        mal: HashSet<Int>,
        graph: Array<IntArray>
    ): Int {
        if (seen.contains(cur)) return 0
        if (mal.contains(cur)) return -1
        seen.add(cur)

        var res = 1 // current node saved
        for (next in graph.indices) {
            if (next != cur && graph[cur][next] == 1) {
                var temp = dfs(next, seen, mal, graph)
                if (temp == -1) {
                    mal.add(cur)
                    return -1
                }

                res += temp
            }
        }

        return res
    }
}