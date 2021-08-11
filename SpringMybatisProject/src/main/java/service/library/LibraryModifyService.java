package service.library;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Model.LibraryDTO;
import command.LibraryCommand;
import repository.LibraryRepository;

public class LibraryModifyService {
	@Autowired
	LibraryRepository libraryRepository;
	public void libModify(LibraryCommand libraryCommand, HttpSession session) {
		LibraryDTO dto = new LibraryDTO();
		dto.setNoticeSub(libraryCommand.getNoticeSub());
		dto.setNoticeCon(libraryCommand.getNoticeCon());
		dto.setNoticeNo(libraryCommand.getNoticeNo());
		
		LibraryDTO fdto = libraryRepository.libraryInfo(libraryCommand.getNoticeNo());
		
		String original = fdto.getNoticeOrgFile();
		String store = fdto.getNoticeFile();
		String fileSize = fdto.getNoticeFileSize();
		String realPath = session.getServletContext().getRealPath("WEB-INF/view/library/upload");
		
		String [] fileNames = libraryCommand.getFileDel().split("/");
		if(!fileNames[0].equals("")) {
			String org = "";
			String str = "";
			String fSize = "";
			for(String s : fileNames) {
			org += s.split(",")[0] +",";
			str += s.split(",")[1] +",";
			fSize += s.split(",")[2] +",";
			}
			int i = 0;
			if(!fileNames[0].equals("")) {
				for(String o : org.split(",")) {
					String or = o + ",";
					String sr = str.split(",")[i]+",";
					String fs = fSize.split(",")[i] +",";
					
					// 왜 replace가 original한테만 적용되고 있는지? 앞에 공백문자가 붙어서 넘어오고 있음 - trim 적용해줘야 함
					original = original.replace(or.trim(), "" );
					store = store.replace(sr.trim(), "");
					fileSize = fileSize.replace(fs.trim(), "");
					
					File file = new File(realPath+"/"+str.split(",")[i]);
					if(file.exists())file.delete();
					i++;
				}
			}
		}
		//파일 추가
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal ="";
		if(libraryCommand.getNoticeFile()[0].getOriginalFilename()!= "") {
			for(MultipartFile mf : libraryCommand.getNoticeFile()) {
				String original1 = mf.getOriginalFilename();
				String originalExt = original1.substring(original1.lastIndexOf("."));
				String store1 = UUID.randomUUID().toString().replace("-","") + originalExt;
				String fileSize1 = Long.toString(mf.getSize()/1024);//KB단위
				originalTotal += original1 + ",";
				storeTotal += store1 + ",";
				fileSizeTotal += fileSize1 + ",";
				File file = new File(realPath + "/" + store);
				try {mf.transferTo(file);}catch(Exception e) {}
			}
			dto.setNoticeOrgFile((original+originalTotal).replace("null", ""));
			dto.setNoticeFile((store+storeTotal).replace("null", ""));
			dto.setNoticeFileSize((fileSize+fileSizeTotal).replace("null", ""));
		}else {
			dto.setNoticeOrgFile(original);
			dto.setNoticeFile(store);
			dto.setNoticeFileSize(fileSize);
		}	
		libraryRepository.libModify(dto);
	}
}
