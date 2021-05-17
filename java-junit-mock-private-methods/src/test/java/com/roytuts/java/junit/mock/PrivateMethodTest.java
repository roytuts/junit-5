package com.roytuts.java.junit.mock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
//import org.powermock.reflect.Whitebox;

@ExtendWith(MockitoExtension.class)
public class PrivateMethodTest {

	 @Mock
	 private PrivateMethodApp app;

	//@InjectMocks
	//private PrivateMethodApp app = new PrivateMethodApp();

	//@Test
	public void testPrivateMethodUsingReflection() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = PrivateMethodApp.class.getDeclaredMethod("pvMethod", Integer.class);
		method.setAccessible(true);
		method.invoke(app, 10);
	}

	//@Test
	public void testPrivateMethodUsingPowerMock() throws Exception {
		//Whitebox.invokeMethod(app, "pvMethod", 10);
	}

	@Test
	public void testPrivateMethodUsingReflectionUtils() throws Exception {
		ReflectionTestUtils.invokeMethod(app, "pvMethod", 10);
	}
	
}
