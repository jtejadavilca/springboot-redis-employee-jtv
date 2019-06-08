package pe.com.pruebas.redisjtv.redisjtv.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.com.pruebas.redisjtv.redisjtv.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
	List<Employee> findByFirstName(String firstName);
}
