// Importing ListMap collection from Scala's library
import scala.collection.immutable.ListMap

// Defining the ShoppingBasket object
object ShoppingBasket {
  val prices = Map(
    "Soup" -> 65,
    "Bread" -> 80,
    "Milk" -> 130,
    "Apples" -> 100
  )
 
  // Defining a function to calculate the price of the items in the basket
  def priceBasket(items: List[String]): (Double, Double, Double) = {
    val counts = items.groupBy(identity).view.mapValues(_.size).toMap
    
    
    // Calculating the subtotal cost without considering any discounts
    val subtotal = counts.view
      .map { case (item, qty) => prices(item) * qty }
      .sum / 100.0
    
    // Applying a 10% discount if "Apples" are in the basket
    val appleDiscount = if (counts.contains("Apples")) (counts("Apples") * prices("Apples") * 0.10) / 100.0 else 0.0
    
    // Applying a 50% discount on "Bread" if there are 2 or more "Soup" in the basket
    val soupCount = counts.getOrElse("Soup", 0)
    val breadCount = counts.getOrElse("Bread", 0)
    val soupBreadDiscountCount = (soupCount / 2).min(breadCount)
    val breadDiscount = soupBreadDiscountCount * prices("Bread") * 0.50 / 100.0
    
    // Calculating the total discount
    val totalDiscounts = appleDiscount + breadDiscount

    (subtotal, totalDiscounts, subtotal - totalDiscounts)
  }

  def main(args: Array[String]): Unit = {
    val basketItems = args.drop(1).toList
    val (subtotal, discounts, total) = priceBasket(basketItems)

    println(f"Subtotal: £$subtotal%.2f")
    if (discounts > 0) {
      if (discounts * 100 == prices("Apples") * 0.10)
        println(f"Apples 10%% off: ${(discounts * 100).toInt}p")
      else
        println(f"Bread half price with 2 tins of Soup: ${(discounts * 100).toInt}p")
    }
    else println("No offers available")
    println(f"Total price: £$total%.2f")
  }
}
