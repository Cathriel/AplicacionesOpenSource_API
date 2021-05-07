package com.roomies.roomies;

import com.roomies.roomies.domain.model.Landlord;
import com.roomies.roomies.domain.model.Review;
import com.roomies.roomies.domain.model.User;
import com.roomies.roomies.domain.repository.*;
import com.roomies.roomies.domain.repository.ReviewRepository;
import com.roomies.roomies.domain.service.*;
import com.roomies.roomies.exception.ResourceNotFoundException;
import com.roomies.roomies.service.*;
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

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ReviewServiceImplTest {
    @MockBean
    private ReviewRepository reviewRepository;

    @MockBean
    private PostRepository postRepository;

    @MockBean
    private UserRepository userRepository;


    @TestConfiguration
    static class ReviewServiceImplTestConfiguration {
        @Bean
        public ReviewService reviewService(){
            return new ReviewServiceImpl();
        }

        @Bean
        public PostService postService(){return new PostServiceImpl();}

        @Bean
        public UserService userService(){return new UserServiceImpl();}
    }



}
