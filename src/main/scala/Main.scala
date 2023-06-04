import scala.collection.immutable.ListMap

object ShoppingBasket {
  val prices = Map(
    "Soup" -> 65,
    "Bread" -> 80,
    "Milk" -> 130,
    "Apples" -> 100
  )

  def priceBasket(items: List[String]): (Double, Double, Double) = {
    val counts = items.groupBy(identity).view.mapValues(_.size).toMap

    val subtotal = counts.view
      .map { case (item, qty) => prices(item) * qty }
      .sum / 100.0

    val appleDiscount = if (counts.contains("Apples")) (counts("Apples") * prices("Apples") * 0.10) / 100.0 else 0.0
    
    val soupCount = counts.getOrElse("Soup", 0)
    val breadCount = counts.getOrElse("Bread", 0)
    val soupBreadDiscountCount = (soupCount / 2).min(breadCount)
    val breadDiscount = soupBreadDiscountCount * prices("Bread") * 0.50 / 100.0

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
