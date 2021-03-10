/**
 * Each person has two interests (interest1, interest2).
 *  1. A and B are friends, if they share at least one common interest
 *  2. If A and B are friends, B and C are friends, A and C are friends
 *
 * Time Complexity:     O(`nPersons`)
 * Space Complexity:    O(`nPersons`)
 */
package com.an7one.byCompany.other.friendsSharingCommonInterests

class SolutionApproach0UnionFind {
    fun groupFriends(persons: Array<Person>): Int {
        val nPersons = persons.size
        val uf = UnionFind(nPersons)

        val map = HashMap<Int, MutableList<Int>>()
        for ((id, interest1, interest2) in persons) {
            map.getOrPut(interest1) { mutableListOf() }.add(id)
            map.getOrPut(interest2) { mutableListOf() }.add(id)
        }

        for ((_, ids) in map) {
            val nIds = ids.size
            if (nIds < 2) continue

            for (idx in 1 until nIds) {
                uf.union(ids.first(), ids[idx])
            }
        }

        return uf.getCount()
    }

    private class UnionFind(capacity: Int) {
        private val roots = IntArray(capacity) { idx -> idx }
        private val ranks = IntArray(capacity) { 1 }
        private var size = capacity

        fun find(x: Int): Int {
            while (roots[x] != x) {
                roots[x] = find(roots[x])
            }
            return roots[x]
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)

            if (rootX == rootY) return

            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX
                ++ranks[rootX]
            } else {
                roots[rootX] = rootY
                ++ranks[rootY]
            }

            --size
        }

        fun getCount() = size
    }
}

data class Person(val id: Int, val interest1: Int, val interest2: Int)
