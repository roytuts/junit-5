package com.roytuts.spring.junit.namedparameterjdbctemplate.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.roytuts.spring.junit.namedparameterjdbctemplate.model.User;

@ExtendWith(MockitoExtension.class)
public class NamedParameterJdbcTemplateTest {

	@Mock
	private UserDao dao;

	@InjectMocks
	private UserDao userDao;

	@Mock
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Test
	public void testAddUser() {
		User user = new User(1, "Soumitra", "soumitra@roytuts.com", "1234567890", "Earth");

		dao.addUser(user);

		Mockito.verify(dao, Mockito.times(1)).addUser(user);
	}

	@Test
	public void testAddUserJdbcNamedParameter() {
		final String sql = "insert into user(id, name, email, phone, address) values(:id, :name, :email, :phone, :address)";

		User user = new User(1, "Soumitra", "soumitra@roytuts.com", "1234567890", "Earth");

		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("id", user.getId());
		mapParameters.addValue("name", user.getName());
		mapParameters.addValue("email", user.getEmail());
		mapParameters.addValue("phone", user.getPhone());
		mapParameters.addValue("address", user.getAddress());

		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(), Mockito.any(MapSqlParameterSource.class)))
				.thenReturn(1);

		userDao.addUser(user);

		Assertions.assertEquals(1, namedParameterJdbcTemplate.update(sql, mapParameters));
	}

	@Test
	public void testCountByName() {
		User user = new User(1, "Soumitra", "soumitra@roytuts.com", "1234567890", "Earth");

		Integer integer = new Integer(1);

		Mockito.when(namedParameterJdbcTemplate.queryForObject(Mockito.anyString(),
				Mockito.any(SqlParameterSource.class), Mockito.<Class> any())).thenAnswer(x -> integer);

		int i = userDao.countByName(user);

		Assertions.assertEquals(1, i);
	}

}
