package com.roomies.cucumber;

import com.roomies.roomies.domain.model.Post;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostFilterSteps {

    Post post = new Post().setBathQuantity(2);
    Post post1 = new Post().setBathQuantity(3);
    Post post2 = new Post().setBathQuantity(3);
    int bathroomQuantity;

    @Given("I choose a filter of a feature")
    public void IChooseAFilterOfAFeature(){

    }

    @Given("I select number bathrooms")
    public void iSelectNumberBathrooms() {

    }

    @When("I click on search")
    public void iClickOnSearch() {
    }


    @Then("I should see posts with that feature")
    public void iShouldSeePostsWithThatFeature() {
            }
}
