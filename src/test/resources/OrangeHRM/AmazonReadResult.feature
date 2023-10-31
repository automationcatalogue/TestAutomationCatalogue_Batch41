Feature: Amazon Results Data Reading
  @AmazonSearch
  Scenario: Amazon Application Results
    Given Amazon website is loaded
    When User Selects the Category and Search for an Item and reads result data
          |Category               |SearchItem|
          |Computers & Accessories|Laptops|
          |Books                  |Latest |
          |Electronics            |TVs    |
    Then User performs Search Results in Amazon website