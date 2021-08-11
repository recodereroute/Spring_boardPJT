package service.board;

import org.springframework.beans.factory.annotation.Autowired;

import Model.BoardDTO;
import command.BoardCommand;
import repository.BoardRepository;

public class BoardModifyService {
	@Autowired
	BoardRepository boardRepository;
	public void boardModify(BoardCommand boardCommand) {
		BoardDTO dto = new BoardDTO();
		dto.setNoticeSub(boardCommand.getNoticeSub());
		dto.setNoticeCon(boardCommand.getNoticeCon());
		dto.setNoticeNo(boardCommand.getNoticeNo());
		boardRepository.boardModify(dto);
		
	}
}
