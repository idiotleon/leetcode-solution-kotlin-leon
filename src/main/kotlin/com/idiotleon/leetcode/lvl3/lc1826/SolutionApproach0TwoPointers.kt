/**
 * https://leetcode.com/problems/faulty-sensor/
 *
 * Time Complexity:     O(`nSensors`)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/faulty-sensor/discuss/1160927/C%2B%2BJava-One-Pass
 */
package com.idiotleon.leetcode.lvl3.lc1826

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun badSensor(sensor1: IntArray, sensor2: IntArray): Int {
        val nSensors = sensor1.size

        var idx = 0
        while (idx + 1 < nSensors) {
            if (sensor1[idx] != sensor2[idx]) {
                if (sensor1[idx] == sensor1.last() && sensor2[idx] == sensor2.last())
                    return -1

                while (idx + 1 < nSensors && sensor1[idx] == sensor2[idx + 1])
                    ++idx

                return if (idx + 1 == nSensors) 1 else 2
            }

            ++idx
        }

        return -1
    }
}