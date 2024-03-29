package pe.com.pruebas.redisjtv.redisjtv.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.pruebas.redisjtv.redisjtv.model.Employee;
import pe.com.pruebas.redisjtv.redisjtv.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck() {
		return "{ \"todoOk\" : true }";
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		Iterable<Employee> result = employeeRepository.findAll();
		List<Employee> employeesList = new ArrayList<Employee>();
		result.forEach(employeesList::add);
		return employeesList;
	}

	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable String id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		return emp;
	}
	
	@GetMapping("/employee/firstName/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable String firstName) {
		List<Employee> employeesList = employeeRepository.findByFirstName(firstName);
		return employeesList;
	}

	@PutMapping("/employee/{id}")
	public Optional<Employee> updateEmployee(@RequestBody Employee newEmployee, @PathVariable String id) {
		Optional<Employee> optionalEmp = employeeRepository.findById(id);
		if (optionalEmp.isPresent()) {
			Employee emp = optionalEmp.get();
			emp.setFirstName(newEmployee.getFirstName());
			emp.setLastName(newEmployee.getLastName());
			emp.setEmail(newEmployee.getEmail());
			employeeRepository.save(emp);
		}
		return optionalEmp;
	}

	@DeleteMapping(value = "/employee/{id}", produces = "application/json; charset=utf-8")
	public String deleteEmployee(@PathVariable String id) {
		Boolean result = employeeRepository.existsById(id);
		employeeRepository.deleteById(id);
		return "{ \"operacionExitosa\" : " + (result ? "true" : "false") + " }";
	}
	@DeleteMapping(value = "/employee/delete", produces = "application/json; charset=utf-8")
	public String deleteAllEmployees() {
		employeeRepository.deleteAll();
		return "{ \"operacionExitosa\" : true }";
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		String id = String.valueOf(new Random().nextInt());
		Employee emp = new Employee(id, newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getEmail(), newEmployee.getActive() == null ? false : newEmployee.getActive());
		employeeRepository.save(emp);
		return emp;
	}
}
