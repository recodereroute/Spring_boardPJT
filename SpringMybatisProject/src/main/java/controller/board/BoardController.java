package controller.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.BoardCommand;
import service.board.BoardWriteService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	
	@RequestMapping("boardList")
	public String boardList() {
		return "board/boardList";
	}
	@RequestMapping("boardPost")
	public String posting() {
		return "board/boardPost";
	}
	@RequestMapping(value = "boardWrite", method = RequestMethod.POST)
	public String boardWrite(BoardCommand boardCommand, HttpSession session) {
		boardWriteService.boardWrite(boardCommand, session);
		return "redirect:boardList";
	}
}
