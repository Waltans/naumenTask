package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Task3 {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Иванов Иван Иванович", 28, "A", 95000.0));
		employees.add(new Employee("Петров Петр Петрович", 35, "B", 105000.0));
		employees.add(new Employee("Сидоров Сидор Сидорович", 45, "C", 120000.0));
		employees.add(new Employee("Кузнецов Николай Николаевич", 30, "D", 85000.0));
		employees.add(new Employee("Федоров Федор Федорович", 29, "E", 70000.0));
		
		Optional<Employee> hightSalaryEmployee = employees.stream()
				.filter(employee -> employee.getSalary() > 100000.00)
				.findAny();
		
		if (hightSalaryEmployee.isPresent()) {
			System.out.println(hightSalaryEmployee.get());
		} else {
			System.out.println("Нет сотрудников с зарплатой более 100000.00");
		}
	}
	
}
