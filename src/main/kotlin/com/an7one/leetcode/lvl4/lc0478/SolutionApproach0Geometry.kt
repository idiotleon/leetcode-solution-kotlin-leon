package com.an7one.leetcode.lvl4.lc0478

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.random.Random
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.PI

/**
 * @author: LEon
 * https://leetcode.com/problems/generate-random-point-in-a-circle/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/generate-random-point-in-a-circle/discuss/1113623/JS-Python-Java-C%2B%2B-or-Polar-Notation-Solution-w-Explanation
 * https://leetcode.com/problems/generate-random-point-in-a-circle/discuss/155650/Explanation-with-Graphs-why-using-Math.sqrt()
 * https://leetcode.com/problems/generate-random-point-in-a-circle/discuss/357810/Image-explains-....-Why-sqrt()-of-the-radius
 */
@Suppress(UNUSED)
class SolutionApproach0Geometry(
    private val radius: Double, private val xCenter: Double, private val yCenter: Double
) {
    fun randPoint(): DoubleArray {
        val angle = Random.nextDouble() * 2 * PI
        val hyp = sqrt(Random.nextDouble()) * radius
        val adj = cos(angle) * hyp
        val opp = sin(angle) * hyp

        return doubleArrayOf(xCenter + adj, yCenter + opp)
    }
}