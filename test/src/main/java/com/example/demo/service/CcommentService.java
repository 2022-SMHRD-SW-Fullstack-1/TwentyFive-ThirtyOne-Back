package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CcommentMapper;
import com.example.demo.model.Ccomment;

@Service
public class CcommentService {

	@Autowired
	CcommentMapper ccommentMapper;

	public int writeCcmt(HashMap<String, Object> map) {
		return ccommentMapper.writeCcmt(map);
	}
	
	public List<Ccomment> selectCcmt(int cmt_seq) {
		return ccommentMapper.selectCcmt(cmt_seq);
	}
	
	public void ccmtDelete(Ccomment ccomment) {
		ccommentMapper.ccmtDelete(ccomment);
	}
	
	public int ccmtNum(Ccomment ccomment) {
		return ccommentMapper.ccmtNum(ccomment);
	}

}
