package service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.LibraryDTO;
import command.LibraryCommand;
import repository.LibraryRepository;

public class LibraryModifyService {
	@Autowired
	LibraryRepository libraryRepository;
	public void libModify(LibraryCommand libraryCommand, Model model) {
		LibraryDTO dto = new LibraryDTO();
		dto.setNoticeSub(libraryCommand.getNoticeSub());
		dto.setNoticeCon(libraryCommand.getNoticeCon());
		dto.setNoticeNo(libraryCommand.getNoticeNo());
		libraryRepository.libModify(dto);
	}
}
