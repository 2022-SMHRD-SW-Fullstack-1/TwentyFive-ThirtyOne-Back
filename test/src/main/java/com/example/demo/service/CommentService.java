package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.model.Comment;

@Service
public class CommentService {

	@Autowired
	CommentMapper commentMapper;

	public int writeCmt(HashMap<String, Object> map) {
		return commentMapper.writeCmt(map);
	}
	
	public List<Comment> selectCmt(int board_seq) {
		return commentMapper.selectCmt(board_seq);
	}
	
	public void cmtDelete(Comment comment) {
		commentMapper.cmtDelete(comment);
	}
	public void cmtdel(Comment comment) {
		commentMapper.cmtdel(comment);
	}
	
	public int cmtNum(Comment comment) {
		return commentMapper.cmtNum(comment);
	}
	
	public void cmtUpdate(Comment comment) {
		commentMapper.cmtUpdate(comment);
	}

}
