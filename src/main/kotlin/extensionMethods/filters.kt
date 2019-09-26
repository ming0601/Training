package extensionMethods

import kotlin.streams.toList

enum class Genre {
    MASCULIN,
    FEMININ;
}

fun <T> List<T>.filterOrder(predicate: (T) -> Boolean): List<T> {

    val result = mutableListOf<T>()
    this.forEach {
        if (predicate.invoke(it)) result.add(it)
    }
    return result.stream().sorted().toList()
}

fun List<List<Any>>.filterToMap(predicate: (List<Any>) -> Pair<Any, Any>): Map<Any, List<Any>> {

    val map = mutableMapOf<Any, MutableList<Any>>()
    this.forEach {
        val pair = predicate.invoke(it)
        if (map.containsKey(pair.first).not()) map[pair.first] = mutableListOf(pair.second)
        else map[pair.first]!!.add(pair.second)
    }
    return map
}