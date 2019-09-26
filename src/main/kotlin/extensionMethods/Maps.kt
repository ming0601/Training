package extensionMethods

data class Customer (
    val name: String,
    val age: Int,
    val address: Address
)

data class Address(
    val number: Int,
    val streetName: String,
    val postalCode: Int,
    val cityName: String
)

fun <T, R> Iterable<T>.mapAny(predicate: (T) -> R): Iterable<R> {
    val list = mutableListOf<R>()
    this.forEach {
        val result = predicate.invoke(it)
        list.add(result)
    }
    return list
}