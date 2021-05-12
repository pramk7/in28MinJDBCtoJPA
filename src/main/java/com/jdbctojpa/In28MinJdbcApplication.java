package com.jdbctojpa;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdbctojpa.entity.Person;
import com.jdbctojpa.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class In28MinJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO personJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(In28MinJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Persons -> {}",personJdbcDao.FindAll());	
		logger.info("Person By Userid 10001 -> {}",personJdbcDao.FindById(10001));	
		logger.info("Deleting Userid 10002, Number of rows deleted-> {}",personJdbcDao.DeleteById(10002));	
		logger.info("Inserting new person:"+personJdbcDao.insert(new Person(10005, "Ganesh", "Mumbai", LocalDateTime.of(2001, 4, 15, 12, 11, 10))));
		logger.info("update 10003:"+personJdbcDao.update(new Person(10003,"suresh","beed",LocalDateTime.now())));
		logger.info("All Persons -> {}",personJdbcDao.FindAll());
	}

}
