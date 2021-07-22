package service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.LibraryDTO;
import repository.LibraryRepository;

public class LibraryInfoService {
	@Autowired
	LibraryRepository libraryRepository;
	public void libraryInfo(String noticeNo, Model model) {
		//인포서비스를 여기저기서 쓰면 조회수가 비정상적으로 올라간다.
		//새로고침 할때마다 조회수가 올라가서 조금 손 볼 필요가 있다.->세션당 한번? 한 아이디당 한번? 생각해 봐야 할듯
		libraryRepository.libCount(noticeNo);
		LibraryDTO dto = libraryRepository.libraryInfo(noticeNo);
		model.addAttribute("dto", dto);
	}
}