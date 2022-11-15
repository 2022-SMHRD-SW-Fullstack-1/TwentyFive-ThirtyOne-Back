package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Comment;

@Mapper
public interface CommentMapper {
	
	@Insert("insert into comment values(null, #{board_seq}, #{cmt_content}, now(), #{mb_nick})")
	public int writeCmt(HashMap<String, Object> map);
	
	@Select("select * from comment where board_seq=#{board_seq}")
	public List<Comment> selectCmt(int board_seq);

	@Delete("delete from comment where mb_nick=#{mb_nick} and cmt_seq=#{cmt_seq}")
	public void cmtDelete(Comment comment);
	@Delete("DELETE FROM comment WHERE cmt_seq=#{cmt_seq}")
	public void cmtdel(Comment comment);

	@Select("select count(*) from comment where board_seq=#{board_seq}")
	public int cmtNum(Comment comment);
	
	@Update("update comment set cmt_content=#{cmt_content} where cmt_seq=#{cmt_seq}")
	public void cmtUpdate(Comment comment);
	
}
