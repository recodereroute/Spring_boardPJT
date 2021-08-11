package service.clientLib;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import Model.ClientLibDTO;
import command.ClientLibCommand;
import repository.ClientLibRepository;

public class ClientLibWriteService {
	@Autowired
	ClientLibRepository clientLibRepository;
	public void clientLibWrite(ClientLibCommand clientLibCommand, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String empId = authInfo.getGrade();
		ClientLibDTO dto = new ClientLibDTO();
		String noticeNo = clientLibRepository.counting();
		dto.setNoticeNo(noticeNo);
		dto.setEmployeeId(empId);
		dto.setNoticeCon(clientLibCommand.getNoticeCon());
		dto.setNoticeSub(clientLibCommand.getNoticeSub());
		dto.setNoticeKind("고객의 소리");
		clientLibRepository.write(dto);
	}
}
