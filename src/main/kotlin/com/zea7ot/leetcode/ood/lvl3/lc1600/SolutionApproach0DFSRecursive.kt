/**
 * https://leetcode.com/problems/throne-inheritance/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/throne-inheritance/discuss/866400/Textbook-DFS-Problem-with-convoluted-wording/712762
 *  https://leetcode.com/problems/throne-inheritance/discuss/866400/Textbook-DFS-Problem-with-convoluted-wording
 */
package com.zea7ot.leetcode.ood.lvl3.lc1600

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive(kingName: String) {
    private val family = HashMap<String, MutableList<String>>().also {
        it[kingName] = mutableListOf()
    }
    private val dead = HashSet<String>()
    private var root = kingName

    fun birth(parentName: String, childName: String) {
        family.getOrPut(parentName) { mutableListOf() }.add(childName)
    }

    fun death(name: String) {
        dead.add(name)
    }

    fun getInheritanceOrder(): List<String> {
        val order = mutableListOf<String>()
        dfs(root, order)
        return order
    }

    private fun dfs(parent: String, res: MutableList<String>) {
        if (!dead.contains(parent)) res.add(parent)

        family[parent]?.let {
            for (child in it) {
                dfs(child, res)
            }
        }
    }
}