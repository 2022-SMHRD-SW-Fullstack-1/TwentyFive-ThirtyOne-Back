package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Follow;
import com.example.demo.model.FollowInfo;
import com.example.demo.model.Members;
import com.example.demo.service.MemberService;
import com.google.gson.Gson;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MemberController {

	Gson gson = new Gson();

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public Members login(@RequestBody Members member, HttpSession session) {

		System.out.println(member);

		Members listM = memberService.loginMember(member);

		System.out.println(listM);

		session.setAttribute("listM", listM);

		Members loginM = (Members) session.getAttribute("listM");

		System.out.println(loginM);

		return loginM;

	}

	@ResponseBody
	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String joinMember(@RequestBody Members member) {

		System.out.println(member);

		int cnt = memberService.joinMember(member);

		if (cnt > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String idCheck(@RequestBody Members id) {

		System.out.println(id);

		return memberService.idCheck(id);

	}

	@ResponseBody
	@RequestMapping(value = "/nickcheck", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String nickCheck(@RequestBody Members nick) {

		System.out.println(nick);

		return memberService.nickCheck(nick);

	}

	@RequestMapping(value = "/findid", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String findId(@RequestBody Members param) {

		System.out.println(param);

		return memberService.findId(param.getMb_email());
	}

	@ResponseBody
	@RequestMapping(value = "/findpw", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String findPw(@RequestBody String param) throws Exception {

		System.out.println(param);

		Members json = gson.fromJson(param, Members.class);
		System.out.println(json);

		return memberService.findPw(json);

	}

	@ResponseBody
	@RequestMapping(value = "/profile", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public Members profile(@RequestBody String param) throws Exception {

		System.out.println(param);

		Members mb_nick = gson.fromJson(param, Members.class);

		return memberService.infoProfile(mb_nick);

	}

	@ResponseBody
	@RequestMapping(value = "/quitmember", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void quitmember(@RequestBody Members member) {

		System.out.println(member);

		memberService.quitmember(member);

	}

	@ResponseBody
	@RequestMapping(value = "/checkfollow", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int checkFollow(@RequestBody Follow params) throws Exception {
		return memberService.checkFollow(params);
	}

	@ResponseBody
	@RequestMapping(value = "/follow", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String follow(@RequestBody Follow params) throws Exception {

		int resultCheck = memberService.checkFollow(params);
		if (resultCheck >= 1) {
			memberService.deleteFollow(params);
			return "unfollow";

		} else {
			memberService.follow(params);
			return "follow";
		}

	}

	@ResponseBody
	@RequestMapping(value = "/followinfo", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public List<FollowInfo> followInfo(@RequestBody Follow params) throws Exception {

		return memberService.followInfo(params);

	}

	@ResponseBody
	@RequestMapping(value = "/membercheck", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String membercheck(@RequestBody Members mb_nick) throws Exception {
		return memberService.membercheck(mb_nick);
	}

}
