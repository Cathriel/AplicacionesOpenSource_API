package com.roomies.cucumber.landlordcucumber.landlordcommon;


import com.roomies.roomies.resource.PostResource;
import com.roomies.roomies.resource.SavePostResource;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class PostHttpClient {

    private final String SERVER_URL = "http://localhost";
    private final String POST_ENDPOINT = "/landlords/1/posts";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    private String postEndpoint(){return SERVER_URL + ":" + port + POST_ENDPOINT;}

    public int put(final SavePostResource resource){
        return restTemplate.postForEntity(postEndpoint(),resource, PostResource.class).getStatusCodeValue();
    }

    public PostResource getContent(){return restTemplate.getForEntity(postEndpoint(),PostResource.class).getBody();}

    public void clean(){restTemplate.delete(postEndpoint());}

}
