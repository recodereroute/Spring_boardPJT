package controller.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.BoardCommand;
import service.board.BoardDeleteService;
import service.board.BoardDetailService;
import service.board.BoardListService;
import service.board.BoardModifyService;
import service.board.BoardUpdateService;
import service.board.BoardWriteService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	@Autowired
	BoardListService boardListService;
	@Autowired
	BoardDetailService boardDetailService;
	@Autowired
	BoardUpdateService boardUpdateService;
	@Autowired
	BoardModifyService boardModifyService;
	@Autowired
	BoardDeleteService boardDeleteService;
	@RequestMapping("boardDel")
	public String boardDel(@RequestParam(value="boardNo")String boardNo) {
		boardDeleteService.boardDelete(boardNo);
		return "redirect:boardList";
	}
	@RequestMapping(value = "boardModify", method = RequestMethod.POST)
	public String boardModify(BoardCommand boardCommand) {
		boardModifyService.boardModify(boardCommand);
		return "redirect:boardList";
	}
	@RequestMapping("boardUpdate")
	public String boardUpdate(@RequestParam(value="boardNo")String boardNo, Model model) {
		boardUpdateService.boardUpdate(boardNo, model);
		return "board/boardModify";
	}
	@RequestMapping("boardDetail")
	public String boardDetail(@RequestParam(value="boardNo")String boardNo, Model model) {
		boardDetailService.boardDetail(boardNo, model);
		return "board/boardView";
	}
	@RequestMapping("boardList")
	public String boardList(Model model) {
		boardListService.boardList(model);
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
