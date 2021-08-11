package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.ClientLibDTO;

public class ClientLibRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.clientLibMapper";
	String statement;
	public List<ClientLibDTO> clientLibList(){
		statement = namespace + ".clientLibList";
		return sqlSession.selectList(statement);
	}
	public String counting() {
		statement = namespace + ".counting";
		return sqlSession.selectOne(statement);
	}
	public void write(ClientLibDTO dto) {
		statement = namespace + ".write";
		sqlSession.insert(statement, dto);
	}
}
