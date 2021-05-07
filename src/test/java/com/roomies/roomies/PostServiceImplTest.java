package com.roomies.roomies;

import com.roomies.roomies.domain.model.Post;
import com.roomies.roomies.domain.model.User;
import com.roomies.roomies.domain.repository.PostRepository;
import com.roomies.roomies.domain.repository.ReviewRepository;
import com.roomies.roomies.domain.service.PostService;
import com.roomies.roomies.service.PostServiceImpl;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PostServiceImplTest {
    @MockBean
    private PostRepository postRepository;
    @MockBean
    private ReviewRepository reviewRepository;

    @Autowired
    private PostService postService;

    @TestConfiguration
    static class PostServiceImplTestConfiguration {
        @Bean
        public PostService postService(){
            return new PostServiceImpl();
        }
    }


}
