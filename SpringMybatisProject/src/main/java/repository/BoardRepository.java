package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.BoardDTO;

public class BoardRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.boardMapper";
	String statement;
	
	public void boardDelete(String boardNo) {
		statement = namespace + ".delete";
		sqlSession.delete(statement, boardNo);
	}
	public void boardModify(BoardDTO dto) {
		statement = namespace + ".modify";
		sqlSession.update(statement, dto);
	}
	public BoardDTO boardDetail(String boardNo) {
		statement = namespace +".detail";
		return sqlSession.selectOne(statement, boardNo);
	}
	public void count(String boardNo) {
		statement = namespace + ".count";
		sqlSession.update(statement, boardNo);
	}
	public String counting() {
		statement = namespace +".counting";
		return sqlSession.selectOne(statement);
	}
	public void write(BoardDTO dto) {
		statement = namespace + ".write";
		sqlSession.insert(statement, dto);
	}
	public List<BoardDTO> boardList(){
		statement = namespace + ".list";
		return sqlSession.selectList(statement);
	}
	
}
