package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.NoticeDTO;

public class NoticeRepository {
	@Autowired
	SqlSession sqlsession;
	String namespace = "mappers.noticeMapper";
	String statement;
	public void noticeDel(String noticeNo) {
		statement = namespace + ".noticeDel";
		sqlsession.delete(noticeNo);
	}
	public void noticeModify(NoticeDTO dto) {
		statement = namespace + ".noticeModify";
		sqlsession.update(statement, dto);
	}
	public void noticeReadUpdate(String noticeNo) {
		statement = namespace + ".noticeCount";
		sqlsession.update(statement, noticeNo);
	}
	public NoticeDTO noticeDetail(String noticeNo) {
		statement = namespace + ".noticeDetail";
		return sqlsession.selectOne(statement, noticeNo);
	}
	public List<NoticeDTO> noticeList(){
		statement = namespace +".noticeList";
		return sqlsession.selectList(statement);
	}
	public void noticeWrite(NoticeDTO dto) {
		statement = namespace + ".noticeWrite";
		sqlsession.insert(statement, dto);
	}
}
