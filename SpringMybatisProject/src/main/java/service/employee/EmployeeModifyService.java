package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import command.EmployeeCommand;
import repository.EmployeeRepository;

public class EmployeeModifyService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empModify(EmployeeCommand employeeCommand, HttpSession session) {
		//ID 같은 경우는 세션에서 받아오는게 안전 - 해킹방지(홈페이지에 있는 값은 변경되기가 쉬움)
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String empId = authInfo.getGrade();
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeId(empId);
		dto.setJobId(employeeCommand.getJobId());
		dto.setPhNumber(employeeCommand.getPhNumber());
		dto.setOfficeNumber(employeeCommand.getOfficeNumber());
		dto.setEmail(employeeCommand.getEmail());
		dto.setEmpAddress(employeeCommand.getEmpAddress());
		employeeRepository.empModify(dto);
	}
}
