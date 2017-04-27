package v_builders

import util.TODO
import util.doc39
import v_builders.data.getProducts
import v_builders.htmlLibrary.*

fun getTitleColor() = "#b9c9fe"
fun getCellColor(row: Int, column: Int) = if ((row + column) % 2 == 0) "#dce4ff" else "#eff2ff"

fun todoTask39(): Nothing = TODO(
        """
        Task 39.
        1) Fill the table with the proper values from products.
        2) Color the table like a chess board (using getTitleColor() and getCellColor() functions above).
        Pass a color as an argument to functions 'tr', 'td'.
        You can run the 'Html Demo' configuration in IntelliJ IDEA to see the rendered table.
    """,
        documentation = doc39()
)

fun renderProductTable(): String {
    val result = html {
        table {

            tr(color = getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            for(p in getProducts()){
                tr {
                    td(color = getCellColor(1, 1)){
                        text(p.description)
                    }
                    td(color = getCellColor(1, 2)) {
                        text(p.price)
                    }
                    td(color = getCellColor(2, 1)) {
                        text(p.popularity)
                    }
                }
            }
        }
    }.toString()
    println(result)
    return result
}
