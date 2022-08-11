package com.signal.jobposting.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.signal.all.dto.JobPostingDTO;
import com.signal.jobposting.dao.JobPostingDAO;

@Service
public class JobPostingService {
	
	@Autowired JobPostingDAO dao;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	//로그인 관련
	public String login(String com_id, String com_pw) {
		logger.info("로그인이 잘 들어왔나?");
		return dao.login(com_id,com_pw);
	}
	
	// 대표자명 받아오기
	public String ComDetail(String id) {
		logger.info("대표자명 요청");
		return dao.ComDetail(id);
		}
	
	//
	public JobPostingDTO infoCom(String id) {
		JobPostingDTO dto =null;
		logger.info("기업정보 등록 시 기업명 가져오기");
		logger.info("받아온 아이디: "+id);
		dto = dao.infoCom(id);
		return dto;
	}
	
	// 기업정보 상세보기
	public JobPostingDTO ComInfoDetail(String id, String ceo,String no) {
		logger.info("기업정보 상세보기 요청");
		JobPostingDTO dto =null;
		logger.info(id+" 기업의 대표자: "+ceo+" / "+no);
		dto = dao.ComInfoDetail(id,ceo,no);
		return dto;
	}
	
	/*
	 	public JobPostingDTO ComInfoDetail(String id, String ceo) {
		JobPostingDTO dto =null;
		logger.info(id+" 기업의 대표자: "+ceo);
		dto = dao.ComInfoDetail(id,ceo);
		return dto;
	}
	  
	 * */
	


	public int infoWrite(MultipartFile[] ci_photo, HashMap<String, String> params) {
		JobPostingDTO dto = new JobPostingDTO();
		logger.info("사진: "+ci_photo);
		
		for (MultipartFile photo : ci_photo) {
			String photo_original = photo.getOriginalFilename(); //3-1파일명 추출
            logger.info("photo name: " + photo.getOriginalFilename());
            if(!photo.getOriginalFilename().equals("")) {
               logger.info("업로드 진행");
               String ext = photo_original.substring(photo_original.lastIndexOf(".")).toLowerCase();
               String photo_copy = System.currentTimeMillis() + ext;
               logger.info(photo_original + photo_copy );   
               try {
                  byte[] arr =photo.getBytes();
                  Path path = Paths.get("C:\\STUDY\\SPRING_ADVENCE\\Signal\\src\\main\\webapp\\resources\\images/" + photo_copy);
                  Files.write(path, arr);
                  logger.info(photo_copy + " 저장 완료");
               } catch (IOException e) {
                     e.printStackTrace();
               }
               dto.setCi_photo(photo_copy);
               logger.info(photo_copy + " 저장 완료");   
            }  
         }
		dto.setCom_id(params.get("com_id"));
		dto.setCi_ceo(params.get("ci_ceo"));
		dto.setCi_web(params.get("ci_web"));
		dto.setCi_intro(params.get("ci_intro"));
		dto.setCi_pass_intro(params.get("ci_pass_intro"));
		dto.setCi_emp(params.get("ci_emp"));
		
		return dao.infoWrite(dto);

	}

	// 기업정보 번호 받아오기
	public String file(String no) {
		logger.info("기업정보 번호 요청");
		return dao.file(no);
	}

	public JobPostingDTO Detail(String id, String ceo, String no) {
		JobPostingDTO dto =null;
		logger.info(id+" 기업의 대표자: "+ceo+" / "+no);
		dto = dao.Detail(id,ceo,no);
		return dto;
	}

	public JobPostingDTO comUpdate(String id) {
		// ArrayList<JobPostingDTO> list = dao.file(id);
		JobPostingDTO dto =new JobPostingDTO();
		dto = dao.comUpdate(id);
		logger.info(id+" 기업정보 수정페이지 요청");
		logger.info("대표자명만 ?"+dto.getCi_ceo());
		
		return dto;
	}

	public int update(MultipartFile[] ci_photo, HashMap<String, String> params, String id) {
		
		HashMap<String, String> map =  new HashMap<String, String>();
		map.put("com_id", id);
		logger.info("기업정보 수정 서비스 요청");
		logger.info("param : {}",params);
		int row = dao.update(params);
		logger.info("row? "+row);
		
		if(row>0) {    
			infoWrite(ci_photo, params);        
      }
		return row;
		   }

	/*
	 * public void comUpdate(String no) { logger.info("기업정보 수정하기 페이지 요청");
	 * 
	 * JobPostingDTO dto = dao.comUpdate(no); ArrayList<JobPostingDTO>list
	 * =dao.Detail(no); logger.info("상세보기 번호?" + no);
	 * 
	 * model.addAttribute("comInfo", dto); model.addAttribute("list", list);
	 * 
	 * }
	 */

}




