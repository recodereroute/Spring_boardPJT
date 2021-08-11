package service.library;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Model.AuthInfoDTO;
import Model.LibraryDTO;
import command.LibraryCommand;
import repository.LibraryRepository;

public class LibraryWriteService {
	@Autowired
	LibraryRepository libraryRepository;
	public void libWrite(LibraryCommand libraryCommand, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String empId = authInfo.getGrade();
		
		LibraryDTO dto = new LibraryDTO();
		dto.setNoticeCon(libraryCommand.getNoticeCon());
		dto.setNoticeSub(libraryCommand.getNoticeSub());
		dto.setNoticeKind("자료실");
		dto.setEmployeeId(empId);
		String noticeNo = libraryRepository.libNo();
		dto.setNoticeNo(noticeNo);
		
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal = "";
		if(libraryCommand.getNoticeFile()[0].getOriginalFilename() != null) {
			for(MultipartFile mf : libraryCommand.getNoticeFile()) {
				String original = mf.getOriginalFilename();
				//확장자
				String originalExt = original.substring(original.lastIndexOf("."));
				//저장되는 파일 이름
				String store = UUID.randomUUID().toString().replace("-", "") + originalExt;
				//KB 단위 - 왜 안나눠지는지 ?
				System.out.println("mf size : "+ mf.getSize());
				System.out.println("mf size / 1024 : "+mf.getSize()/1024);
				System.out.println("mf size / 1024**2 : "+mf.getSize()/(1024*1024));
				String fileSize = Long.toString(mf.getSize()/1024);
				originalTotal += original +",";
				storeTotal += store + ",";
				fileSizeTotal += fileSize + ",";
				String path = "WEB-INF/view/library/upload";
				String realPath = session.getServletContext().getRealPath(path);
				File file = new File(realPath + "/" + store);
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				dto.setNoticeOrgFile(originalTotal);
				dto.setNoticeFile(storeTotal);
				dto.setNoticeFileSize(fileSizeTotal);
			}
		}
		libraryRepository.libWrite(dto);
	}
}
