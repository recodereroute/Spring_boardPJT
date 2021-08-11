package service.board;

import org.springframework.beans.factory.annotation.Autowired;

import repository.BoardRepository;

public class BoardDeleteService {
	@Autowired
	BoardRepository boardRepository;
	public void boardDelete(String boardNo) {
		boardRepository.boardDelete(boardNo);
	}
}
