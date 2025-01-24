Feature: Test Amazon search fincionality

    @Cart
    Scenario Outline: As a Customer when I Search for Alexa, I want to see if the third option on the second page is available for purchase and can be added to the cart.
        Given the user navigates to www.amazon.com
        And searches for <Product>
        And navigates to the second page
        And selects the third item
        When I select open the dropdown of the Categoria
        Then the user is able to add it to the cart

        Examples:
            | Product     |
            | Alexa       |
            | Playstation |