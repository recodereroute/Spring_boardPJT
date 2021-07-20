package controller.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Model.AuthInfoDTO;
import command.EmployeeCommand;
import service.employee.EmployeeDeleteService;
import service.employee.EmployeeInfoService;
import service.employee.EmployeeModifyService;
import service.employee.EmployeePwModifyService;
import service.employee.EmployeePwUpdateService;

@Controller
@RequestMapping("empEdit")
public class EmployeeMyPageController {
	@Autowired
	EmployeeInfoService employeeInfoService;
	@Autowired
	EmployeeModifyService employeeModifyService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	EmployeePwUpdateService employeePwUpdateService;
	@Autowired
	EmployeePwModifyService employeePwModifyService;
	
	@RequestMapping(value = "empPwUpdateOk", method = RequestMethod.POST)
	public String empPwUpdateOk(EmployeeCommand employeeCommand, Errors errors, HttpSession session) {
		employeePwModifyService.pwUpdateOk(employeeCommand, errors, session);
		if(errors.hasErrors()) {
			return "employee/empPwUpdate";
		}
		return "redirect:empMyPage";
	}
	@RequestMapping(value = "empPwUpdate", method = RequestMethod.POST)
	public String empPwUpdate(@RequestParam(value="empPw")String empPw, Model model,
							HttpSession session) {
		int i = employeePwUpdateService.empPwUpdate(empPw, model, session);
		if(i == 1) {
			return "employee/empPwEdit";
		}else {
			return "employee/empPwUpdate";
		}
	}
	@RequestMapping("empPwEdit")
	public String empPwEdit() {
		return "employee/empPwEdit";
	}
	@RequestMapping("empMyPage")
	public String empMyPage() {
		return "employee/empMyPage";
	}
	@RequestMapping("empDetail")
	public String empDetail(HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String empId = authInfo.getGrade();
		employeeInfoService.empInfo(empId, model);
		return "employee/employeeInfo";
	}
	@RequestMapping("empModify")
	public String empModify(@RequestParam(value = "empId")String empId, Model model) {
		employeeInfoService.empInfo(empId, model);
		return "employee/employeeModify";
	}
	@RequestMapping(value = "empModifyOk", method = RequestMethod.POST)
	public String empModifyOk(EmployeeCommand employeeCommand, HttpSession session) {
		//이미 만든 서비스에 validator 적용하려면 jsp를 앞에서부터 뜯어 고쳐야 함. 일단 생략
//		new EmployeeModifyValidator().validate(employeeCommand, errors);
//		if(errors.hasErrors()) {
//			return "employee/employeeModify";
//		}
		employeeModifyService.empModify(employeeCommand, session);
		return "redirect:empDetail";
	}
	@RequestMapping("empDelete")
	public String empDelete(@RequestParam(value="empId")String empId, HttpSession session) {
		String path = employeeDeleteService.empDelete(empId, session);
		return path;
	}
	@RequestMapping("empMyDelete")
	public String empDelPw() {
		//본인 계정 삭제하는 경우 - 로그아웃 되야함
		//authInfo 초기화
		//메인페이지로 돌아가야함.
		//직원 리스트에서 직원 삭제시키는 거랑 마이페이지에서 탈퇴 하는거랑은 다르게 처리해야됨.
		return "employee/empDelPw";
	}
	@RequestMapping("empDelOk")
	public String empDelOk(@RequestParam(value = "empPw")String empPw,
			HttpSession session, Model model) {
		String path = employeeDeleteService.empMyDelete(empPw, session, model);
		return path;
	}

}
