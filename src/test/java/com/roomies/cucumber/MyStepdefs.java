package com.roomies.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {
    
    private int balance;
    private int stock;
    
    @Given("I have {int} beer cans")
    public void iHaveOpeningBalanceBeerCans(int balance) {
        this.balance=balance;
    }
    
    @And("I have drunk {int} beer cans") 
    public void i_have_drunk_beer_cans(int processed){
        this.stock=balance- processed;
    }
    
    @When("I go to my fridge")
    public void iGoToMyFridge() {
    }

    @Then("I should have {int} beer cans")
    public void iShouldHaveInStockBeerCans(int stock) {
        assertEquals(this.stock,stock);
    }
}
