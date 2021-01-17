package com.mutn.sree.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mutn.sree.bean.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Employee> findAll() {
		return mongoTemplate.findAll(Employee.class);
	}

	public Employee save(Employee employee) {
		return mongoTemplate.save(employee);
	}

	public Employee update(Employee employee) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(employee.getId()));

		Update update = new Update();
		update.set("name", employee.getName());
		update.set("city", employee.getCity());

		return mongoTemplate.findAndModify(query, update, Employee.class);
	}

	public void delete(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoTemplate.remove(query, Employee.class);
	}

	public Employee findEmployeeById(String id) {
		return mongoTemplate.findById(id, Employee.class);
	}

}
