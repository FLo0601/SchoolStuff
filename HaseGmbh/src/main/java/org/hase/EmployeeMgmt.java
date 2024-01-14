package org.hase;


import org.hase.interfaces.IntEmployeeMgmt;
import org.hase.model.Employee;

import java.util.Collection;
import java.util.HashMap;

public class EmployeeMgmt implements IntEmployeeMgmt {
	private HashMap<Integer, Employee> employeeMap;
	private int nextFreeId;

	public EmployeeMgmt() {
		this.employeeMap = new HashMap<>();
		this.nextFreeId = 1;
		initializeWithExampleData();
	}

	@Override
	public boolean add(Employee employee) {
		if (employeeMap.containsKey(employee.getId())) {
			// Employee with the same ID already exists
			return false;
		}
		employeeMap.put(employee.getId(), employee);
		return true;
	}

	@Override
	public Employee get(int id) {
		return employeeMap.get(id);
	}

	@Override
	public Collection<Employee> getAll() {
		return employeeMap.values();
	}

	@Override
	public boolean update(Employee employee) {
		if (employeeMap.containsKey(employee.getId())) {
			employeeMap.put(employee.getId(), employee);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		if (employeeMap.containsKey(id)) {
			employeeMap.remove(id);
			return true;
		}
		return false;
	}

	@Override
	public int getNextFreeId() {
		return nextFreeId++;
	}

	private void initializeWithExampleData() {
		// Realistischere Beispiel-Daten für die Initialisierung der employeeMap
		add(new Employee(getNextFreeId(), "John", "Doe", "john.doe@example.com", "555-1234"));
		add(new Employee(getNextFreeId(), "Jane", "Smith", "jane.smith@example.com", "555-5678"));
		add(new Employee(getNextFreeId(), "Michael", "Johnson", "michael.johnson@example.com", "555-9876"));
		add(new Employee(getNextFreeId(), "Emily", "Williams", "emily.williams@example.com", "555-4321"));
		add(new Employee(getNextFreeId(), "Daniel", "Brown", "daniel.brown@example.com", "555-8765"));
		add(new Employee(getNextFreeId(), "Sophia", "Davis", "sophia.davis@example.com", "555-6543"));
		add(new Employee(getNextFreeId(), "Matthew", "Miller", "matthew.miller@example.com", "555-7890"));
		add(new Employee(getNextFreeId(), "Olivia", "Garcia", "olivia.garcia@example.com", "555-2345"));
		add(new Employee(getNextFreeId(), "Liam", "Martinez", "liam.martinez@example.com", "555-0123"));
		add(new Employee(getNextFreeId(), "Emma", "Lopez", "emma.lopez@example.com", "555-3456"));
	}

}
