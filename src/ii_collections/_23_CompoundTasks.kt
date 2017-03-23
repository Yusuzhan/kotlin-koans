package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter { it.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
        //customers.fold(0, { count, customer -> count + customer.orders.flatMap { it.products }.filter { it == product }.size })
        customers.fold(0, { count, customer -> count + customer.orders.flatMap { it.products }.count { it == product } })
// Return the number of times the given product was ordered.
// Note: a customer may order the same product for several times.
// solution 1 : using flatMap
// return customers.flatMap { it.orders }.flatMap { it.products }.filter { it == product }.size


