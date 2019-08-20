package com.javaavidity.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BaseDao {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	/**
	 * Handling Empty Result Exception using Optional
	 * @param <T>
	 * @param sql
	 * @param args
	 * @param elementType
	 * @return
	 */
	public <T> Optional<T> queryForObject(String sql, Object[] args, Class<T> elementType) {
		try {
			return Optional
					.of(this.jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(elementType)));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}

	}

}
