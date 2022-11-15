package com.example.demo.controller;

import com.example.demo.entity.FileEntity;
import com.example.demo.model.Members;
import com.example.demo.repo.FileRepository;
import com.example.demo.service.MemberService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
public class FileController {
	@Autowired
	MemberService memberService;
    private final FileRepository fileRepository;
    String filepath = "C:/Users/smhrd/Desktop/REACT/ittime/public/img/";
    @PostMapping("/upload")
    public String uploadImage(HttpServletRequest request,
                                  @RequestParam(value="file", required = false) MultipartFile[] files,
                                  @RequestParam(value="mb_nick", required = false) String mb_nick,
                                  @RequestParam(value="mb_id", required = false) String mb_id) {

    	
        String FileNames = "";

        String originFileName = files[0].getOriginalFilename();
        long fileSize = files[0].getSize();
        String safeFile = System.currentTimeMillis() + originFileName;//저장 경로

        File f1 = new File(filepath + safeFile);

        try {
            files[0].transferTo(f1);//files[0].transferTo(f1) 부분이 실질적으로 지정한 경로에 파일을 저장하는 부분
           
        } catch (IOException e) {
            e.printStackTrace();
        }

        final FileEntity file = FileEntity.builder()
                .filename(safeFile)
                .build();
        String result =fileRepository.save(file).getFilename();
     
       if(mb_nick!=null) {
      		memberService.updateProfileImg(mb_nick);
      		}
       else if(mb_id!=null) {
			memberService.updateProfileBg(mb_id);
		}
      
        return result;
    }
    
    
 

}