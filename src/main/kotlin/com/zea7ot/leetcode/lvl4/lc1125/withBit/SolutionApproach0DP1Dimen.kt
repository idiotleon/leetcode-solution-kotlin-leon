/**
 * https://leetcode.com/problems/smallest-sufficient-team/
 *
 * Time Complexity:     O(`nPeople` * `range`)
 * Space Complexity:    O(`nReqSkills`) + O(`range`) ~ O(`range`)
 *
 * References:
 *  https://leetcode.com/problems/smallest-sufficient-team/discuss/334572/Python-DP-Solution/639522
 */
package com.zea7ot.leetcode.lvl4.lc1125.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun smallestSufficientTeam(reqSkills: Array<String>, people: List<List<String>>): IntArray {
        // not used
        // val nPeople = people.size
        val nReqSkills = reqSkills.size
        val range = 1 shl nReqSkills

        val map = HashMap<String, Int>()
        for (idx in reqSkills.indices) {
            map[reqSkills[idx]] = idx
        }

        val dp = Array<MutableList<Int>?>(range) { null }
        dp[0] = mutableListOf()

        for (idxP in people.indices) {
            val curSkillSet = getSkill(people[idxP], map)

            for (skill in range - 1 downTo 0) {
                if (dp[skill] == null) continue
                val newSkillSet = curSkillSet or skill
                if (newSkillSet == skill) continue
                if (dp[newSkillSet] == null || dp[newSkillSet]!!.size > dp[skill]!!.size + 1) {
                    val list = dp[skill]!!.toMutableList()
                    list.add(idxP)
                    dp[newSkillSet] = list
                }
            }
        }

        return dp.last()!!.toIntArray()
    }

    private fun getSkill(people: List<String>, map: HashMap<String, Int>): Int {
        var bitMask = 0
        for (skill in people) {
            if (map.containsKey(skill)) {
                val idx = map[skill]!!
                bitMask = bitMask or (1 shl idx)
            }
        }

        return bitMask
    }
}