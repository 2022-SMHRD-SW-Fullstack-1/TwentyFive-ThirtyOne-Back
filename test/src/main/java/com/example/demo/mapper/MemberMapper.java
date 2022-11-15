package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Follow;
import com.example.demo.model.FollowInfo;
import com.example.demo.model.Members;

@Mapper
public interface MemberMapper {

	@Select("SELECT * FROM members WHERE mb_id=#{mb_id} AND mb_pw=#{mb_pw}")
	public Members loginMember(Members member);

	@Insert("INSERT INTO members(mb_id, mb_pw, mb_nick, mb_email, mb_joindate) VALUES (#{mb_id}, #{mb_pw}, #{mb_nick}, #{mb_email}, now())")
	public int joinMember(Members member);

	@Select("SELECT * FROM members WHERE mb_id=#{mb_id}")
	public Members idCheck(Members member);

	@Select("SELECT * FROM members WHERE mb_nick=#{mb_nick}")
	public Members nickCheck(Members member);

	@Select("SELECT * FROM members WHERE mb_email=#{mb_email}")
	public Members findId(String mb_email);

	@Select("SELECT * FROM members WHERE mb_id=#{mb_id} AND mb_email=#{mb_email}")
	public Members findPw(Members member);

	@Update("UPDATE members SET mb_pw=#{code} WHERE mb_id=#{mb_id} AND mb_email=#{mb_email}")
	public void updatePw(String code, String mb_id, String mb_email);

	@Select("SELECT * FROM members WHERE mb_nick=#{nick}")
	public Members getPic(String nick);

	@Select("SELECT * FROM members WHERE mb_nick NOT IN(#{mb_nick}) ORDER BY mb_nick")
	public List<Members> getUser(Members user);

	@Select("SELECT * FROM members WHERE mb_nick=#{mb_nick}")
	public Members getFrnd(String mb_nick);

	@Select("select * from members where mb_nick=#{mb_nick}")
	public Members infoProfile(Members mb_nick);

	@Update("UPDATE members SET mb_pic=(select filename  from file ORDER BY pid DESC LIMIT 1) where mb_nick=#{mb_nick}")
	public void updateProfileImg(String mb_nick);

	@Update("UPDATE members SET mb_bg=(select filename  from file ORDER BY pid DESC LIMIT 1) where mb_id=#{mb_id}")
	public void updateProfileBg(String mb_id);

	@Delete("DELETE FROM members WHERE mb_id=#{mb_id} AND mb_pw=#{mb_pw}")
	public void quitmember(Members member);

	@Insert("insert into follows values (null, #{to_nick}, #{from_nick})")
	public int follow(Follow params);

	@Select("select count(*)  from follows where to_nick= #{to_nick} and from_nick= #{from_nick}")
	public int checkFollow(Follow params);

	@Delete("delete from follows where to_nick=#{to_nick} and from_nick=#{from_nick}")
	public int deleteFollow(Follow params);

	@Select("select mb_pic,from_nick  from followinfo where to_nick=#{to_nick}")
	public List<FollowInfo> followInfo(Follow params);

	@Select("select mb_nick from members where mb_nick=#{mb_nick}")
	public String membercheck(Members mb_nick);
}
