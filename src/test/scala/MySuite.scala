
import munit._

class MySuite extends FunSuite {
  test("Price of a single apple") {
    val price = ShoppingBasket.priceBasket(List("Apples"))
    assertEquals(price._1, 1.00)
    assertEquals(price._2, 0.10) // 10% discount on apples
    assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 0.90)
  }

  test("Price of two apples") {
    val price = ShoppingBasket.priceBasket(List("Apples", "Apples"))
    assertEquals(price._1, 2.00)
    assertEquals(price._2, 0.20) // 10% discount on each apple
    assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 1.80)
  }

  test("Price of a tin of soup") {
    val price = ShoppingBasket.priceBasket(List("Soup"))
    assertEquals(price._1, 0.65)
    assertEquals(price._2, 0.00) // No discount on soup
    assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 0.65)
  }

  test("Price of two tins of soup and a loaf of bread") {
    val price = ShoppingBasket.priceBasket(List("Soup", "Soup", "Bread"))
    assertEquals(price._1, 2.10)
    assertEquals(price._2, 0.40) // Half price on bread for buying two soups
    assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 1.70)
  }

  test("Price of a loaf of bread") {
    val price = ShoppingBasket.priceBasket(List("Bread"))
    assertEquals(price._1, 0.80)
    assertEquals(price._2, 0.00) // No discount on single loaf of bread
    assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 0.80)
  }

  test("Price of a bottle of milk") {
    val price = ShoppingBasket.priceBasket(List("Milk"))
    assertEquals(price._1, 1.30)
    assertEquals(price._2, 0.00) // No discount on milk
    assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 1.30)
  }

  test("Price of a loaf of bread and a bottle of milk") {
    val price = ShoppingBasket.priceBasket(List("Bread", "Milk"))
    assertEquals(price._1, 2.10)
    assertEquals(price._2, 0.00) // No discount applicable
    assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 2.10)
  }

  test("Price of a loaf of bread and two bottles of milk") {
    val price = ShoppingBasket.priceBasket(List("Bread", "Milk", "Milk"))
    assertEquals(price._1, 3.40)
    assertEquals(price._2, 0.00) // No discount applicable
    assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 3.40)
  }


  test("Price with no items") {
  val price = ShoppingBasket.priceBasket(List())
  assertEquals(price._1, 0.00)
  assertEquals(price._2, 0.00) // No items, no discount
  assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 0.00)
}

  test("Price of two tins of soup and two loafs of bread") {
  val price = ShoppingBasket.priceBasket(List("Soup", "Soup", "Bread", "Bread"))
  assertEquals(price._1, 2.90)
  assertEquals(price._2, 0.40) // Half price on one loaf of bread for buying two soups
  assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 2.50)
}

  test("Price of four tins of soup and two loafs of bread") {
  val price = ShoppingBasket.priceBasket(List("Soup", "Soup", "Soup", "Soup", "Bread", "Bread"))
  assertEquals(price._1, 4.20)
  assertEquals(price._2, 0.80) // Half price on both loafs of bread for buying four soups
  assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 3.40)
}

  test("Price of three tins of soup and one loaf of bread") {
  val price = ShoppingBasket.priceBasket(List("Soup", "Soup", "Soup", "Bread"))
  assertEquals(price._1, 2.75)
  assertEquals(price._2, 0.40) // Half price on bread for buying three soups
  assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 2.35)
}

  test("Price with all items") {
  val price = ShoppingBasket.priceBasket(List("Soup", "Bread", "Milk", "Apples"))
  assertEquals(price._1, 3.75)
  assertEquals(price._2, 0.10) // 10% discount on apples
  assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 3.65)
}

  test("Price with multiple items and all offers") {
  val price = ShoppingBasket.priceBasket(List("Soup", "Soup", "Bread", "Apples", "Apples"))
  assertEquals(price._1, 4.10)
  assertEquals(BigDecimal(price._2).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 0.60) // Half price on bread for buying two soups and 10% discount on each apple
  assertEquals(BigDecimal(price._3).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble, 3.50)
}


  
  
  

}
