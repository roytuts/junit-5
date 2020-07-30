package com.roytuts.java.junit.mockito.donothing.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.roytuts.java.junit.mockito.donothing.dao.ActivityDao;
import com.roytuts.java.junit.mockito.donothing.model.ActivityModel;

@ExtendWith(MockitoExtension.class)
public class ActivityServiceTest {

	@Mock
	private ActivityService service;
	@Mock
	private ActivityDao dao;
	@Mock
	private ActivityModel activity;

	@Test
	public void testDaoCreateActivity() {
		Mockito.lenient().doNothing().when(dao).createActivity(activity);
	}

	@Test
	public void testServiceCreateActivity() {
		Mockito.lenient().doNothing().when(service).createActivity(activity);
	}

}
