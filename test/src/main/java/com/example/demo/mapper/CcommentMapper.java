package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Ccomment;
import com.example.demo.model.Comment;

@Mapper
public interface CcommentMapper {

	@Insert("insert into ccomment values(null, #{cmt_seq}, #{ccmt_content}, now(), #{mb_nick})")
	public int writeCcmt(HashMap<String, Object> map);

	@Select("select * from ccomment where cmt_seq=#{cmt_seq}")
	public List<Ccomment> selectCcmt(int cmt_seq);

	@Delete("delete from ccomment where mb_nick=#{mb_nick} and ccmt_seq=#{ccmt_seq}")
	public void ccmtDelete(Ccomment ccomment);
	
	@Select("select count(*) from ccomment where cmt_seq=#{cmt_seq}")
	public int ccmtNum(Ccomment ccomment);
}
