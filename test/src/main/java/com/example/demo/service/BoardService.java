package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.Board;
import com.example.demo.model.Ccomment;
import com.example.demo.model.Comment;
import com.example.demo.model.Members;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public void boardWrite(String board_title, String board_content, String board_file, String board_type, String mb_id) {
		
		 boardMapper.boardWrite(board_title, board_content, board_file, board_type, mb_id);	     
	}	
	public void boardWrites(String board_title, String board_content, String board_type, String mb_id) {
		 boardMapper.boardWrites(board_title, board_content, board_type, mb_id);	
	}
	
	public List<Board> selectOneBoard(int board_seq) {
		return boardMapper.selectOneBoard(board_seq);
	}

	public List<Board> selectAllBoard(String board_type) {
		return boardMapper.selectAllBoard(board_type);
	}
	
	public List<Board> getposts() {	
		List<Board> count = boardMapper.getComCount();
		
		List<Board> like = boardMapper.getlike();
		
		List<Board> result = boardMapper.getposts();	

		for(int i=0; i<result.size(); i++) {
			result.get(i).setCmt_count(count.get(i).getCmt_count());
			result.get(i).setLike_count(like.get(i).getLike_count());
		}
		
		return result;
	}
	public List<Comment> getcomment() {	
		return boardMapper.getcomment();	
	}
	public List<Ccomment> getccomment() {		
		return boardMapper.getccomment();	
	}
	
	public Board boardEdit(int board_seq) {
		return boardMapper.boardEdit(board_seq);
	}
	
	public void boardUpdate(Board board) {
		boardMapper.boardUpdate(board);
	}
	
	public void deleteBoard(Board board) {
		boardMapper.deleteBoard(board);
	}
}
