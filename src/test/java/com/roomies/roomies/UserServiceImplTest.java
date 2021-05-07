package com.roomies.roomies;

import com.roomies.roomies.domain.model.User;
import com.roomies.roomies.domain.repository.UserRepository;
import com.roomies.roomies.domain.service.UserService;
import com.roomies.roomies.service.UserServiceImpl;
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
public class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @TestConfiguration
    static class UserServiceImplTestConfiguration{
        @Bean
        public UserService userService(){
            return new UserServiceImpl();
        }
    }


    @Test
    @DisplayName("When getUserByName With Valid Name Then Returns User")
    public void whenGetUserByNameWithValidNameThenReturnsUser(){

        //Arrange
        String name= "Te odio IntelIJ >:c";
        User user=new User().setId(1L).setName(name);

        userRepository.save(user);

        when(userRepository.findByName(name)).thenReturn(Optional.of(user));

        //Act
        User foundUser=userService.getUserByName(name);

        //Assert
        assertThat(foundUser.getName()).isEqualTo(name);
    }


}
