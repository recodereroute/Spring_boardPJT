package service.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import Model.BoardDTO;
import command.BoardCommand;
import repository.BoardRepository;

public class BoardWriteService {
	@Autowired
	BoardRepository boardRepository;
	public void boardWrite(BoardCommand boardCommand, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String empId = authInfo.getGrade();
		BoardDTO dto = new BoardDTO();
		String noticeNo = boardRepository.counting();
		dto.setEmployeeId(empId);
		dto.setNoticeCon(boardCommand.getNoticeCon());
		dto.setNoticeSub(boardCommand.getNoticeSub());
		dto.setNoticeKind("게시판");
		dto.setNoticeNo(noticeNo);
		boardRepository.write(dto);
	}
}
