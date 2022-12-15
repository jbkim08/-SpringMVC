package com.demo.service;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.beans.ContentBean;
import com.demo.beans.LoginUserBean;
import com.demo.mapper.BoardMapper;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Resource(name = "loginUserBean")
	private LoginUserBean loginUserBean;

	@Value("${path.upload}")
	private String path_upload;
	
	//서버로 업로드 된 파일을 업로드 폴더에 저장하고 파일의 이름을 리턴하는 메소드
	private String saveUploadFile(MultipartFile upload_file) {
		
		//현재 시간(밀리세컨드)을 이용해서 파일의 이름이 중복되지 않게 설정
		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();
		
		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return file_name;
	}
	

	public void addContentInfo(ContentBean writeContentBean) {
		
		MultipartFile upload_file = writeContentBean.getUpload_file();
		
		if(upload_file.getSize() > 0) {
			//위의 메서드로 파일을 저장하고 그 이름을 가져옴
			String file_name = saveUploadFile(upload_file);
			//파일의 이름을 저장한다
			writeContentBean.setContent_file(file_name);
		}
		//글쓴이는 현재 로그인 된 유저
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());

		boardMapper.addContentInfo(writeContentBean);

	}

}
