package com.roytuts.java.junit.mockito.donothing.service;

import com.roytuts.java.junit.mockito.donothing.dao.ActivityDao;
import com.roytuts.java.junit.mockito.donothing.model.ActivityModel;

public class ActivityService {

	private ActivityDao activityDao;

	public ActivityService(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	public void createActivity(final ActivityModel activity) {
		activityDao.createActivity(activity);
	}

}
