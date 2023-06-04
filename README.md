# ScalaProject

## Overview
The project takes a list of items and outputs the subtotal, the special offer discounts, and the final price. The items and their prices are:

Soup – 65p per tin 

Bread – 80p per loaf

Milk – £1.30 per bottle

Apples – £1.00 per bag

Discounts: 

Apples have a 10% discount off their normal price this week

Buy 2 tins of soup and get a loaf of bread for half price

## Prerequisites
To run this application, you need to have Scala and SBT (Scala Build Tool) installed on your machine. You can download and install them from the following links:

Scala: https://www.scala-lang.org/download/ 
SBT: https://www.scala-sbt.org/download.html

## Building and Running the Application
Clone the repository or download the project's zip file and unzip it into a directory. 

Open a terminal and navigate to the directory containing the cloned or unzipped project files.

The main file is in src/main/scala
The test file is in src/test/scala

To build and run the application, use the following commands:
```
sbt compile
```
```
sbt "run PriceBasket item1 item2 item3 ..."
```
Replace item1, item2, item3 etc. with the items you want to add to your basket. For example:
```
sbt "run PriceBasket Soup Soup Bread Milk Apples"
```
It will then output the subtotal, the special offer discounts, and the final price.

## Tests
This project uses the MUnit testing library for Scala. A comprehensive series of tests have been written to test many scenarios, including no items, single items, multiple of the same item, all items, and different combinations of discount offers.

To run the tests, use the following command:

```
sbt test
```

The test cases include:

1. Testing price calculations for single and multiple quantities of each item, both with and without applicable discounts.
2. Testing price calculations for an empty shopping basket.
3. Testing price calculations for combinations of items with discounts. For example, buying two tins of soup and a loaf of bread applies a discount on the bread.
4. Testing price calculations for a basket with all items, with and without applicable discounts.

These tests ensure that the application is correctly calculating prices and applying discounts for different combinations of items in the shopping basket.
