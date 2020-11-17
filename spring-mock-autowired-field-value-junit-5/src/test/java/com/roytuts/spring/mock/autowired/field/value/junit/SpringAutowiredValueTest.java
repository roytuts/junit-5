package com.roytuts.spring.mock.autowired.field.value.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class SpringAutowiredValueTest {

    @Mock
    private SpringServiceAutowiredField service;

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(service, "securityKey", "It's a security key");
    }

    @Test
    public void testAutowiredValueField() {
        service.getValue();
        Mockito.verify(service, Mockito.times(1)).getValue();
    }

}
