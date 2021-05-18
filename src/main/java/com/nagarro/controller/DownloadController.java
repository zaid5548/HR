package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.apicaller.ApiCaller;
import com.nagarro.constants.Constant;
import com.nagarro.entities.Employee;

@Controller
public class DownloadController extends Constant {



	@RequestMapping(path = "/downloadEmployee", method = RequestMethod.GET)
	public void downloadEmployeeDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType(CONTENT_TYPE);
		response.addHeader(CONTENT_DEPOSITION, ATTACHMENT);
		try  {
			ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.EXCEL_PREFERENCE);
			ApiCaller apiCaller = new ApiCaller();
			List<Employee> employers = apiCaller.getEmployee();
			csvBeanWriter.writeHeader(CSV_HEADER);
			for (Employee employee : employers) {
				csvBeanWriter.write(employee, CSV_HEADER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
