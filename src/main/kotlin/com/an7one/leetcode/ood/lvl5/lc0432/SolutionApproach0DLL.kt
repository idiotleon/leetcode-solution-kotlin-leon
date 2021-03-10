package com.an7one.leetcode.ood.lvl5.lc0432

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DLL {
    /** Initialize your data structure here. */
    private val dummyHead = Bucket(Int.MIN_VALUE)
    private val dummyTail = Bucket(Int.MAX_VALUE)
    private val freqToBucket = HashMap<Int, Bucket>()
    private val keyToFreq = HashMap<String, Int>()

    init {
        dummyHead.next = dummyTail
        dummyTail.prev = dummyHead
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    fun inc(key: String) {
        if (keyToFreq.containsKey(key)) {
            changeKey(key, 1)
        } else {
            keyToFreq[key] = 1
            if (dummyHead.next!!.freq != 1) {
                insertBucketIntoDLL(Bucket(1), dummyHead)
            }

            dummyHead.next!!.keySet.add(key)
            freqToBucket[1] = dummyHead.next!!
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    fun dec(key: String) {
        keyToFreq[key]?.let { freq ->
            if (freq == 1) {
                keyToFreq.remove(key)
                removeKeyFromBucket(key, freqToBucket[freq]!!)
            } else {
                changeKey(key, -1)
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    fun getMaxKey() = if (dummyTail.prev == dummyHead) ""
    else dummyTail.prev!!.keySet.iterator().next()

    /** Returns one of the keys with Minimal value. */
    fun getMinKey() = if (dummyHead.next == dummyTail) ""
    else dummyHead.next!!.keySet.iterator().next()

    private fun changeKey(key: String, offset: Int) {
        val freq = keyToFreq[key]!!
        keyToFreq[key] = freq + offset

        val curBucket = freqToBucket[freq]!!

        val newBucket = if (freqToBucket[freq + offset] == null) {
            val tempBucket = Bucket(freq + offset)
            freqToBucket[freq + offset] = tempBucket
            insertBucketIntoDLL(tempBucket, if (offset == 1) curBucket else curBucket.prev!!)

            tempBucket
        } else {
            freqToBucket[freq + offset]!!
        }

        newBucket.keySet.add(key)
        removeKeyFromBucket(key, curBucket)
    }

    private fun removeKeyFromBucket(key: String, bucket: Bucket) {
        bucket.keySet.remove(key)
        if (bucket.keySet.isEmpty()) {
            removeBucketFromDLL(bucket)
            freqToBucket.remove(bucket.freq)
        }
    }

    private fun removeBucketFromDLL(bucket: Bucket) {
        val prev = bucket.prev
        val next = bucket.next

        prev?.next = next
        next?.prev = prev

        bucket.prev = null
        bucket.next = null
    }

    private fun insertBucketIntoDLL(newBucket: Bucket, prevBucket: Bucket) {
        val nextBucket = prevBucket.next

        prevBucket.next = newBucket
        newBucket.prev = prevBucket
        newBucket.next = nextBucket
        nextBucket?.prev = newBucket
    }

    private data class Bucket(val freq: Int) {
        val keySet = HashSet<String>()
        var prev: Bucket? = null
        var next: Bucket? = null
    }
}