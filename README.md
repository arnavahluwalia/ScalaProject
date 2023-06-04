## sbt project compiled with Scala 3

### Usage

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.

For more information on the sbt-dotty plugin, see the
[scala3-example-project](https://github.com/scala/scala3-example-project/blob/main/README.md).

This is an application that prices a basket of goods, taking into account some special offers.

## Overview
The application takes a list of items and outputs the subtotal, the special offer discounts, and the final price. The goods that can be purchased, together with their normal prices are:

Soup – 65p per tin
Bread – 80p per loaf
Milk – £1.30 per bottle
Apples – £1.00 per bag

Current special offers are:

Apples have a 10% discount off their normal price this week
Buy 2 tins of soup and get a loaf of bread for half price

## Pre-requisites
To run this application, you need to have Scala and SBT (Scala Build Tool) installed on your machine. You can download and install them from the following links:

Scala: https://www.scala-lang.org/download/
SBT: https://www.scala-sbt.org/download.html
Building and Running the Application
Clone the repository or download the project's zip file and unzip it into a directory of your choice.

Open a terminal and navigate to the directory containing the cloned or unzipped project files.

To build and run the application, use the following command:
```
sbt "run PriceBasket item1 item2 item3 ..."
```
Replace item1, item2, item3 etc. with the items you want to add to your basket. For example:
```
sbt "run PriceBasket Soup Soup Bread Milk Apples"
```
The application will then output the subtotal, the special offer discounts, and the final price.

## Testing the Application

This application uses the MUnit testing library for Scala. A series of tests have been written to test various scenarios, including no items, single items, multiple of the same item, all items, and various combinations of offers.

To run the tests, use the following command:
```
sbt test
```
The test cases include:

1. Testing price calculations for single and multiple quantities of each item, both with and without applicable discounts.
2. Testing price calculations for an empty shopping basket.
3. Testing price calculations for combinations of items with discounts. For example, buying two tins of soup and a loaf of bread applies a discount on the bread.
4. Testing price calculations for a basket with all items, with and without applicable discounts.
