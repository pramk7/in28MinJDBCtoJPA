package com.jdbctojpa.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jdbctojpa.entity.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person p=new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setLocation(rs.getString("location"));
				Date date = rs.getDate("birth_date");
				p.setBirthDate(LocalDateTime.of(date.getYear()+1900,date.getMonth()+1,date.getDay()+1,0,0,0));
				return p;
		}
		
	}
	
	public List<Person> FindAll() {
		//BeanPropertyRowMapper was used previously
		return jdbcTemplate.query("select * from person", 
				new PersonRowMapper());
	}
	
	public Person FindById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id},
				new PersonRowMapper());
	}
	

	public int DeleteById(int id) {
	 return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public int insert(Person p) {
		 return jdbcTemplate.update("insert into person values(?,?,?,?)",
				 new Object[] {p.getId(),p.getName(),p.getLocation(),p.getBirthDate()});
		}
	public int update(Person p) {
		 return jdbcTemplate.update("update person set name=?,location=?,birth_date=? "
		 		+ "where id=?",
				 new Object[] {p.getName(),p.getLocation(),p.getBirthDate(),p.getId()});
		}
}
