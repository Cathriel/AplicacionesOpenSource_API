package com.roomies.cucumber.landlordcucumber.landlordbasics;

import com.roomies.cucumber.landlordcucumber.landlordcommon.PostHttpClient;
import com.roomies.roomies.domain.model.Landlord;
import com.roomies.roomies.domain.model.Post;
import com.roomies.roomies.domain.repository.LandlordRepository;
import com.roomies.roomies.domain.service.PostService;
import com.roomies.roomies.resource.PostResource;
import com.roomies.roomies.resource.SavePostResource;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LandlordCucumberStepDefinitions {

    private final Logger log = LoggerFactory.getLogger(LandlordCucumberStepDefinitions.class);

    Landlord landlord = (Landlord) new Landlord().setId(1L);

    @Autowired
    private PostHttpClient postHttpClient;

    @Autowired
    private LandlordRepository landlordRepository;

    @Autowired
    private PostService postService;

    @Given("the landlord want to add a post")
    public void the_landlord_want_to_add_a_post(){
        throw new PendingException();
    }

    @When("the landlord add a post")
    public PostResource the_landlord_add_a_post(){
        SavePostResource post = new SavePostResource().setTitle("A");
        IntStream.range(0,1)
                .peek(n->log.info("Putting a {} int posts",post))
                .map(ignore->postHttpClient.put(post))
                .forEach(statusCode-> assertThat(statusCode).isEqualTo(HttpStatus.CREATED.value()));
        return postHttpClient.getContent();
    }

    @Then("the information of the post added is shown")
    public void the_information_of_the_post_added_is_shown(){
        PostResource post = new PostResource().setTitle("A");
        assertThat(the_landlord_add_a_post().getTitle()).isEqualTo(post.getTitle());
    }
}
