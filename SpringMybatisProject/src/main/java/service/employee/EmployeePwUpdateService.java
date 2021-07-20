package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeePwUpdateService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	public int empPwUpdate(String empPw, Model model, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		EmployeeDTO dto = employeeRepository.empInfo(authInfo.getGrade());
		if(!bcryptPasswordEncoder.matches(empPw, dto.getEmpPw())) {
			model.addAttribute("errPw", "비밀번호가 틀렸습니다.");
			return 1;
		}else {
			return 0;
		}
	}
}