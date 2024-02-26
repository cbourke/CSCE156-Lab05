package com.cinco.payroll;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Utility methods for loading employee data.
 * 
 */
public class DataLoader {

	public static final String FILE_PATH = "data/employee.csv";

	/**
	 * Loads employee data from a CSV file (specified by {{@link #FILE_PATH}) and
	 * returns a list of employees.
	 * 
	 * @return
	 */
	public static List<Employee> loadEmployees() {

		List<Employee> result = new ArrayList<Employee>();

		String line = null;

		try (Scanner s = new Scanner(new File(FILE_PATH))) {

			//ignore the header
			s.nextLine();
			while (s.hasNextLine()) {

				line = s.nextLine();
				if (!line.trim().isEmpty()) {
					Employee e = null;
					String tokens[] = line.split(",");
					String id = tokens[1];
					String lastName = tokens[2];
					String firstName = tokens[3];
					String title = tokens[4];
					double annualSalary = 0.0, hourlyPayRate = 0.0, hoursWorked = 0.0;
					if (tokens.length == 7) {
						hourlyPayRate = Double.parseDouble(tokens[5]);
						hoursWorked = Double.parseDouble(tokens[6]);
					} else if (tokens.length == 6) {
						annualSalary = Double.parseDouble(tokens[5]);
					}

					if (tokens[0].equals("E")) {
						// TODO: modify this to create a SalaryEmployee
						e = new Employee();
					} else if (tokens[0].equals("S")) {
						// TODO: modify this to create a Staff employee
						e = new Employee();
					} else if (tokens[0].equals("T")) {
						// TODO: modify this to create a Temporary employee
						e = new Employee();
					}

					result.add(e);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Encountered Error on line " + line, e);
		}

		return result;
	}
}
