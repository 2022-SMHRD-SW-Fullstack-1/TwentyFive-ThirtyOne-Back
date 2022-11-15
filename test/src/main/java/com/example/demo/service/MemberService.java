package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.Follow;
import com.example.demo.model.FollowInfo;
import com.example.demo.model.Members;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private EmailService emailService;

	public Members loginMember(Members member) {
		return memberMapper.loginMember(member);
	}

	public int joinMember(Members member) {
		return memberMapper.joinMember(member);
	}

	public String idCheck(Members member) {
		Members listM = memberMapper.idCheck(member);

		if (listM == null) {

			return "사용가능한 아이디 입니다";

		} else {

			return "이미 사용중인 아이디 입니다";
		}
	}

	public String nickCheck(Members member) {
		Members listM = memberMapper.nickCheck(member);

		if (listM == null) {

			return "사용가능한 닉네임 입니다";

		} else {

			return "이미 사용중인 닉네임 입니다";
		}
	}

	public String findId(String mb_email) {

		Members user = (Members) memberMapper.findId(mb_email);

		if (user == null) {
			return "가입된 아이디가 없습니다";
		} else {

			return "찾으시는 아이디는 '" + user.getMb_id() + "' 입니다";
		}

	}

	public String findPw(Members member) throws Exception {

		Members user = (Members) memberMapper.findPw(member);

		if (user != null) {
			String code = emailService.sendSimpleMessage(user.getMb_email());
			System.out.println("코드 : " + code);

			memberMapper.updatePw(code, user.getMb_id(), user.getMb_email());

			return "가입하신 메일로 임시비밀번호를 발송해 드렸습니다";
		} else {
			return "아이디나 이메일정보를 다시 확인해 주세요";
		}
	}

	public Members getPic(String nick) {
		return memberMapper.getPic(nick);
	}

	public List<Members> getUser(Members user) {

		System.out.println("반환해줄 거 : " + memberMapper.getUser(user));

		return memberMapper.getUser(user);
	}

	public Members infoProfile(Members mb_nick) {
		return memberMapper.infoProfile(mb_nick);
	}

	public void updateProfileImg(String mb_nick) {
		memberMapper.updateProfileImg(mb_nick);
	}

	public void updateProfileBg(String mb_id) {
		memberMapper.updateProfileBg(mb_id);
	}

	public void quitmember(Members member) {
		memberMapper.quitmember(member);
	}

	public int follow(Follow params) {
		return memberMapper.follow(params);
	}

	public int checkFollow(Follow params) {
		return memberMapper.checkFollow(params);
	}

	public int deleteFollow(Follow params) {
		return memberMapper.deleteFollow(params);
	}

	public List<FollowInfo> followInfo(Follow params) {
		return memberMapper.followInfo(params);
	}

	public String membercheck(Members mb_nick) {
		return memberMapper.membercheck(mb_nick);
	}
}
