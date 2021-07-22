package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

public class FileDownLoad {
	public void fileDownLoad(String path, String store, String original,
							HttpServletRequest request, HttpServletResponse response) {
		String RealPath = request.getServletContext().getRealPath(path);
		String originalFileName = "";
		try {
			originalFileName = URLEncoder.encode(original, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("application/octet-stream; charset=utf-8");
		//originalFileName로 파일을 받기위해 이름 설정
		response.setHeader("Content-Disposition", "attachment;filename=\"" + originalFileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//다운로드 하기위한 파일명
		File file = new File(RealPath + "/" + store);
		// 파일이 웹 브라우저에서 다운로드 되도록 하기위한 객체
		ServletOutputStream out1 = null;
		//파일을 웹 브라우저에 전송
		FileInputStream fis = null;
		try {
			out1 = response.getOutputStream();
			fis = new FileInputStream(file);
			//파일 전송
			FileCopyUtils.copy(fis, out1);
			response.flushBuffer();
			out1.flush();
			out1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {}
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
