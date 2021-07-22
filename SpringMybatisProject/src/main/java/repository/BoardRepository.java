package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.BoardDTO;

public class BoardRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.boardMapper";
	String statement;
	
	public String counting() {
		statement = namespace +".counting";
		return sqlSession.selectOne(statement);
	}
	public void write(BoardDTO dto) {
		statement = namespace + ".write";
		sqlSession.insert(statement, dto);
	}
}
