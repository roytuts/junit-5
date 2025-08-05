package com.roytuts.spring.junit.mock.method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class PrivateMethodTest {

	@Mock
	private PrivateMethodApp app;

	//@InjectMocks
	//private PrivateMethodApp app = new PrivateMethodApp();

	@Test
	public void testPrivateMethodUsingReflectionUtils() throws Exception {
		ReflectionTestUtils.invokeMethod(app, "pvMethod", 10);
	}

}
