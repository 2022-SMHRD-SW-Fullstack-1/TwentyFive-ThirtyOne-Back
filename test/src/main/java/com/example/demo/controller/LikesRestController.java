package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Likes;
import com.example.demo.service.LikesService;
import com.google.gson.Gson;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LikesRestController {

	Gson gson = new Gson();

	@Autowired
	private LikesService likesservice;

//	Board
	@ResponseBody
	@RequestMapping(value = "/boardLikeCheck", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int boardLikeCheck(@RequestBody Likes likes) {
		return likesservice.boardLikeCheck(likes);
			}

	@ResponseBody
	@RequestMapping(value = "/boardLike", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void boardLike(@RequestBody Likes likes) {
		likesservice.boardLike(likes);
	}

	@ResponseBody
	@RequestMapping(value = "/boardLikeOp", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void boardLikeop(@RequestBody Likes likes) {
		likesservice.boardLikeOp(likes);
	}

	@ResponseBody
	@RequestMapping(value = "/boardLikeNum", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int boardLikeNum(@RequestBody Likes likes) {
		return likesservice.boardLikeNum(likes);
	}

//	Comment
	@ResponseBody
	@RequestMapping(value = "/commentLikeCheck", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int commentLikeCheck(@RequestBody Likes likes) {
		return likesservice.commentLikeCheck(likes);
	}

	@ResponseBody
	@RequestMapping(value = "/commentLike", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void commentLike(@RequestBody Likes likes) {
		likesservice.commentLike(likes);
	}

	@ResponseBody
	@RequestMapping(value = "/commentLikeOp", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void commentLikeop(@RequestBody Likes likes) {
		likesservice.commentLikeOp(likes);
	}

	@ResponseBody
	@RequestMapping(value = "/commentLikeNum", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int commentLikeNum(@RequestBody Likes likes) {
		return likesservice.commentLikeNum(likes);
	}

//	Ccomment
	@ResponseBody
	@RequestMapping(value = "/ccommentLikeCheck", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int ccommentLikeCheck(@RequestBody Likes likes) {
		return likesservice.ccommentLikeCheck(likes);
	}

	@ResponseBody
	@RequestMapping(value = "/ccommentLike", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void ccommentLike(@RequestBody Likes likes) {
		likesservice.ccommentLike(likes);
	}

	@ResponseBody
	@RequestMapping(value = "/ccommentLikeOp", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void ccommentLikeOp(@RequestBody Likes likes) {
		likesservice.ccommentLikeOp(likes);
	}

	@ResponseBody
	@RequestMapping(value = "/ccommentLikeNum", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int ccommentLikeNum(@RequestBody Likes likes) {
		return likesservice.ccommentLikeNum(likes);
	}

}
