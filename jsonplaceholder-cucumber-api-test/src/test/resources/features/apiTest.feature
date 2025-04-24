Feature: JSONPlaceholder API testing

  Scenario: Get user, validate email, verify posts and create post
    Given I retrieve a random user
    Then I print the user's email
    And I get posts for that user and validate Post IDs
    And I create a new post for that user
