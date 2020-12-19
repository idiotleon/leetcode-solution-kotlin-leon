/**
 * https://leetcode.com/problems/the-skyline-problem/
 *
 * Time Complexity:     O(`totalBuildings` * lg(`totalBuildings`))
 * Space Complexity:    O(`totalBuildings`)
 *
 * References:
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/geometry/SkylineDrawing.java
 *  https://www.youtube.com/watch?v=GSBLe8cKu0s
 *  https://leetcode.com/problems/the-skyline-problem/discuss/61197/(Guaranteed)-Really-Detailed-and-Good-(Perfect)-Explanation-of-The-Skyline-Problem/190968
 */
package com.zea7ot.leetcode.lvl4.lc0218

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

@Suppress(UNUSED)
class SolutionApproach0SweepLine {
    fun getSkyline(blds: Array<IntArray>): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        // sanity check
        if (blds.isEmpty()) return ans

        val totalBuildings = blds.size
        val buildings = Array<Building?>(totalBuildings * 2) { null }

        var idx = 0
        for (building in blds) {
            buildings[idx] = Building(building[0], building[2], true)
            buildings[idx + 1] = Building(building[1], building[2], false)
            idx += 2
        }

        buildings.sort()

        val skyline = TreeMap<Int, Int>()
        skyline[0] = 1

        var prevMaxHeight = 0

        for (building in buildings) {
            if (building == null) continue

            val height = building.height
            if (building.isStart) {
                skyline[height] = 1 + (skyline[height] ?: 0)
            } else {
                skyline[height] = (skyline[height] ?: 1) - 1
                if (skyline[height] == 0)
                    skyline.remove(height)
            }

            val xCoor = building.xCoor
            val curMaxHeight = skyline.lastKey()
            if (prevMaxHeight != curMaxHeight) {
                ans.add(arrayListOf(xCoor, curMaxHeight))
                prevMaxHeight = curMaxHeight
            }
        }

        return ans
    }

    private class Building(val xCoor: Int, val height: Int, val isStart: Boolean) : Comparable<Building> {
        override fun compareTo(other: Building): Int {
            return COMPARATOR.compare(this, other)
        }

        private companion object {
            private val COMPARATOR = Comparator<Building> { a, b ->
                when {
                    a.xCoor != b.xCoor -> a.xCoor.compareTo(b.xCoor)
                    a.isStart && b.isStart -> b.height.compareTo(a.height)
                    !(a.isStart || b.isStart) -> a.height.compareTo(b.height)
                    else -> if (a.isStart) -1 else 1
                }
            }
        }

        private val COMPARATOR_BACKUP = Comparator
            .comparingInt<Building> { it.xCoor }
            .thenComparing { a, b ->
                when {
                    a.isStart && b.isStart -> b.height.compareTo(a.height)
                    !(a.isStart || b.isStart) -> a.height.compareTo(b.height)
                    else -> if (a.isStart) 1 else -1
                }
            }
    }
}