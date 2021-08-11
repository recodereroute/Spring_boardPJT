package service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.BoardDTO;
import repository.BoardRepository;

public class BoardListService {
	@Autowired
	BoardRepository boardRepository;
	public void boardList(Model model) {
		List<BoardDTO> list = boardRepository.boardList();
		model.addAttribute("lists", list);
	}
}
