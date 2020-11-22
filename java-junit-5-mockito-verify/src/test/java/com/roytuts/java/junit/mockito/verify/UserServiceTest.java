package com.roytuts.java.junit.mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserService service;

    @Test
    public void testAutowiredValueField() {
        service.saveUser("1000");
        Mockito.verify(service, Mockito.times(1)).saveUser("1000");
    }

}
