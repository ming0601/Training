package extensionMethods

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FiltersTest {

    @DisplayName("Simple test to check custom extension methods from the class List")
    @Test
    fun orderedFilterTest() {
        val input = listOf("chat", "chien", "vache", "mouton", "cochon")
        val output = listOf("cochon", "mouton")
        Assertions.assertEquals(output, input.filterOrder { it.contains("o") })
    }

    @DisplayName("Simple test to check custom embraced Lists filtered to Map")
    @Test
    fun embracedListsToMapTest() {
        val input: List<List<Any>> = listOf(listOf(Genre.FEMININ, "Scarlett"), listOf(Genre.MASCULIN, "George"), listOf(Genre.FEMININ, "Emma"), listOf(Genre.FEMININ, "Marion"))
        val output = mapOf(
            Genre.FEMININ to listOf("Scarlett", "Emma", "Marion"),
            Genre.MASCULIN to listOf("George")
        )
        Assertions.assertEquals(output, input.filterToMap { Pair(it[0], it[1]) })
    }
}