package com.roomies.roomies;

import com.roomies.roomies.domain.model.Leaseholder;
import com.roomies.roomies.domain.repository.*;
import com.roomies.roomies.domain.repository.LeaseholderRepository;
import com.roomies.roomies.domain.service.LandlordService;
import com.roomies.roomies.domain.service.LeaseholderService;
import com.roomies.roomies.domain.service.PostService;
import com.roomies.roomies.exception.ResourceNotFoundException;
import com.roomies.roomies.service.LandlordServiceImpl;
import com.roomies.roomies.service.LeaseholderServiceImpl;
import com.roomies.roomies.service.LeaseholderServiceImpl;
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

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class LeaseholderServiceImplTest {
    @MockBean
    private LeaseholderRepository leaseholderRepository;

    @MockBean
    private PostRepository postRepository;

    @MockBean
    private LandlordRepository landlordRepository;

    @Autowired
    private LeaseholderService leaseholderService;

    @TestConfiguration
    static class LeaseholderServiceImplTestConfiguration {
        @Bean
        public LeaseholderService leaseholderService(){
            return new LeaseholderServiceImpl();
        }

        @Bean
        public PostService postService(){
            return new PostServiceImpl();
        }

        @Bean
        public LandlordService landlordService(){
            return new LandlordServiceImpl();
        }

        
    }

    @Test
    @DisplayName("When getLeaseholderByName With Valid Name Then Returns Leaseholder")
    public void whenGetLeaseholderByNameWithValidNameThenReturnsName(){

        //Arrange
        String name= "Te odio IntelIJ >:c";
        Leaseholder leaseholder= (Leaseholder) new Leaseholder().setId(1L).setName(name);

        when(leaseholderRepository.findByName(name)).thenReturn(Optional.of(leaseholder));

        //Act
        Leaseholder foundLeaseholder= (Leaseholder) leaseholderService.getLeaseholderByName(name);

        //Assert
        assertThat(foundLeaseholder.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("When getLeaseholderByName With Invalid Name Then Returns Resource Not Found Exception")
    public void whenGetLeaseholderByNameWithInvalidNameThenReturnsResourceNotFoundException(){
        //Arrange
        String name= "Te odio IntelIJ >:c";
        String template="Resource %s not found for %s with value %s";
        when(leaseholderRepository.findByName(name)).thenReturn(Optional.empty());
        String expectedMessage=String.format(template,"Leaseholder","Name",name);

        //Act
        Throwable exception= catchThrowable(()->{
            Leaseholder foundLeaseholder=leaseholderService.getLeaseholderByName(name);
        });

        //Assert
        assertThat(exception).isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }

}
