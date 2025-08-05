package com.roytuts.java.junit.mock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrivateMethodTest {

	 @Mock
	 private PrivateMethodApp app;

	//@InjectMocks
	//private PrivateMethodApp app = new PrivateMethodApp();

	@Test
	public void testPrivateMethodUsingReflection() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = PrivateMethodApp.class.getDeclaredMethod("pvMethod", Integer.class);
		method.setAccessible(true);
		method.invoke(app, 10);
	}

	@Test
	public void testPrivateMethodUsingReflectionUtils() throws Exception {
		Method method = PrivateMethodApp.class.getDeclaredMethod("pvMethod", Integer.class);
		ReflectionUtils.invokeMethod(method, app, 10);
	}

}
