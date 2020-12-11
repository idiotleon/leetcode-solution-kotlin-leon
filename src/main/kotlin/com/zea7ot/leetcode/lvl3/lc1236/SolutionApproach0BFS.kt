/**
 * https://leetcode.com/problems/web-crawler/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl3.lc1236

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private const val SPLITTER = '/'
    }

    fun crawl(startUrl: String, htmlParser: FakeHtmlParser): List<String> {
        val hostName = parseHostName(startUrl)

        val queue = LinkedList<String>()
        queue.offer(startUrl)

        val seen = HashSet<String>()
        seen.add(startUrl)

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                for (url in htmlParser.getUrls(cur)) {
                    if (!url.contains(hostName) || !seen.add(url)) continue
                    queue.offer(url)
                }
            }
        }

        return seen.toList()
    }

    private fun parseHostName(url: String) = url.split(SPLITTER)[2]
}