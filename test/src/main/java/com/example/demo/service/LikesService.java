package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.LikesMapper;
import com.example.demo.model.Likes;

@Service
public class LikesService {

	@Autowired
	private LikesMapper likesMapper;

	public int boardLikeCheck(Likes likes) {
		return likesMapper.boardLikeCheck(likes);
	}
	
	public void boardLike(Likes likes) {
		likesMapper.boardLike(likes);
	}
	
	public void boardLikeOp(Likes likes) {
		likesMapper.boardLikeOp(likes);
	}
	
	public int boardLikeNum(Likes likes) {
		return likesMapper.boardLikeNum(likes);
	}
	
	public int commentLikeCheck(Likes likes) {
		return likesMapper.commentLikeCheck(likes);
	}
	
	public void commentLike(Likes likes) {
		likesMapper.commentLike(likes);
	}
	
	public void commentLikeOp(Likes likes) {
		likesMapper.commentLikeOp(likes);
	}
	
	public int commentLikeNum(Likes likes) {
		return likesMapper.commentLikeNum(likes);
	}
	
	public int ccommentLikeCheck(Likes likes) {
		return likesMapper.ccommentLikeCheck(likes);
	}
	
	public void ccommentLike(Likes likes) {
		likesMapper.ccommentLike(likes);
	}
	
	public void ccommentLikeOp(Likes likes) {
		likesMapper.ccommentLikeOp(likes);
	}
	
	public int ccommentLikeNum(Likes likes) {
		return likesMapper.ccommentLikeNum(likes);
	}

}
