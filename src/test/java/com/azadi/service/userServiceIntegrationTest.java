package com.azadi.service;

import com.azadi.model.entity.UserEntity;
import com.azadi.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class userServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void signup(){
            Optional<UserEntity> optional=userService.signup("dummyUsername","dummypassword","john","doe");
            assertThat(optional.get().getPassword(),not("dummypassword"));
            System.out.println(optional.get().getPassword());
    }
}
