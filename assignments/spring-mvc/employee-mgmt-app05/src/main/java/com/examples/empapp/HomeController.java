package com.examples.empapp;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	EmployeeService empService = new EmployeeService();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@ModelAttribute("employee")
	public Employee emp()
	{
		return new Employee();
	}
	
	
	@RequestMapping(value= "/add", method = RequestMethod.GET)
	public String showRegisterForm() throws SQLException {

		return "add";
	}
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addDetails(@ModelAttribute("employee") Employee emp1) throws SQLException {
		System.out.println(emp1);
		int x = empService.add(emp1);
		System.out.println(x);
		return "home";
	}
	@RequestMapping(value= "/delete", method = RequestMethod.GET)
	public String showdDetails() {
		
		return "delete";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteDetails(@RequestParam("empId") int id) throws SQLException {	
		
		empService.delete(id);
		return "home";
	}
	@RequestMapping(value= "/update", method = RequestMethod.GET)
	public String showuDetails() {
		
		return "update";
	}
	
	@RequestMapping(value= "/update", method = RequestMethod.POST)
	public String updateDetails(@RequestParam("empId") int id,@ModelAttribute("employee") Employee emp1) throws SQLException {	
		
		empService.update(id,emp1);
		return "home";
	}
	@RequestMapping(value= "/view", method = RequestMethod.GET)
	public String view(Model e) {
		List<Employee> empList = null;
		empList = empService.viewAll();
		
		e.addAttribute("elist", empList);
		
		return "view";
	
	}
	
	
}
