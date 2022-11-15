package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Board;
import com.example.demo.model.Comment;
import com.example.demo.model.Members;
import com.example.demo.service.CommentService;
import com.google.gson.Gson;

@RestController
public class CommentRestController {

	Gson gson = new Gson();

	@Autowired
	private CommentService commentService;

	@ResponseBody
	@RequestMapping(value = "/commentWrite", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String writeCmt(@RequestBody HashMap<String, Object> map) {
		
		commentService.writeCmt(map);
				
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/comment/{board_seq}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public List<Comment> selectCmt(@PathVariable("board_seq") int board_seq, Model model) {
		
		model.addAttribute("cmt", commentService.selectCmt(board_seq));
		
		List<Comment> cmt = commentService.selectCmt(board_seq);
		
		return cmt;	
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/commentDelete", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void cmtDelete(@RequestBody Comment comment) {
		commentService.cmtDelete(comment);		
	}
	
	@ResponseBody
	@RequestMapping(value = "/cmtdel", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void cmtdel(@RequestBody Comment comment) {
		commentService.cmtdel(comment);		
	}
	
	@ResponseBody
	@RequestMapping(value = "/commentNumber", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int cmtNum(@RequestBody Comment  comment) {
		return commentService.cmtNum(comment);
	}
	
//	댓글 업데이트
	
	@ResponseBody
	@RequestMapping(value = "/commentUpdate", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void cmtUpdate(@RequestBody Comment comment) {
		commentService.cmtUpdate(comment);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
