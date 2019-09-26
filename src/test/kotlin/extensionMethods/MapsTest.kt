package extensionMethods

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MapsTest {

    @Test
    fun customMapTest() {
        val inputCustomer = listOf(
            Customer(
            name = "John", age = 30, address = Address(
                number = 10, streetName = "Washington Road", postalCode = 300100, cityName = "New York")),
            Customer(
                name = "Jean", age = 40, address = Address(
                    number = 100, streetName = "Boulevard de la République", postalCode = 75011, cityName = "Paris")))

        val output = listOf("New York", "Paris")
        val output1 = listOf("John", "Jean")
        val output2 = listOf(30, 40)
        val output3 = listOf(
            Address(number = 10, streetName = "Washington Road", postalCode = 300100, cityName = "New York"),
            Address(number = 100, streetName = "Boulevard de la République", postalCode = 75011, cityName = "Paris")
        )

        // Working on String
        Assertions.assertEquals(output, inputCustomer.mapAny { it.address.cityName })
        Assertions.assertEquals(output1, inputCustomer.mapAny { it.name })
        // Working on Int
        Assertions.assertEquals(output2, inputCustomer.mapAny { it.age })
        // Checking that we have the same result with the standard .map {}
        Assertions.assertEquals(output2, inputCustomer.map { it.age })
        // Working on Object
        Assertions.assertEquals(output3, inputCustomer.map { it.address })
    }
}