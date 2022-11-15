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

import com.example.demo.model.Ccomment;
import com.example.demo.model.Comment;
import com.example.demo.model.Members;
import com.example.demo.service.CcommentService;
import com.example.demo.service.CommentService;
import com.google.gson.Gson;

@RestController
public class CcommentRestController {

	Gson gson = new Gson();

	@Autowired
	CcommentService ccommentService;

	@ResponseBody
	@RequestMapping(value = "/ccommentWrite", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String writeCcmt(@RequestBody HashMap<String, Object> map) {

		ccommentService.writeCcmt(map);

		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("result", "success");

		String result = gson.toJson(resultMap);

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/ccomment/{cmt_seq}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public List<Ccomment> selectCcmt(@PathVariable("cmt_seq") int cmt_seq, Model model) {

		model.addAttribute("ccmt", ccommentService.selectCcmt(cmt_seq));

		List<Ccomment> ccmt = ccommentService.selectCcmt(cmt_seq);

		return ccmt;

	}

	@ResponseBody
	@RequestMapping(value = "/ccommentDelete", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void ccmtDelete(@RequestBody Ccomment ccomment) {
		ccommentService.ccmtDelete(ccomment);
	}

	@ResponseBody
	@RequestMapping(value = "/ccommentNumber", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int ccmtNum(@RequestBody Ccomment ccomment) {
		return ccommentService.ccmtNum(ccomment);
	}

}
