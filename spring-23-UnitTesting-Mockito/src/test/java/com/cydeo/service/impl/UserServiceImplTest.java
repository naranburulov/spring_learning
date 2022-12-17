package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)         //enabling Mockito in junit
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void findByUserName_Test(){

        //We are calling the real method inside the main, which we are testing:
        userService.findByUserName("harold@manager.com");

        // Checking if this method is run or not:
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);


        //Checking how many times this method is run. If we pass - 2(times), we expect it to fail.
        // To make sure it is run only once, as we need it to, we can pass 1(times).
        verify(userRepository, times(2)).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atMost(10)).findByUserNameAndIsDeleted("harold@manager.com", false);

        InOrder inOrder = inOrder(userRepository, userMapper);

        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);
        inOrder.verify(userMapper).convertToDto(null);


    }


}
