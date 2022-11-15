package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Likes;

@Mapper
public interface LikesMapper {

//	Board 좋아요 판별	
	@Select("select count(*) from likes where board_seq=#{board_seq} and mb_nick=#{mb_nick}")
	public int boardLikeCheck(Likes likes);

//	Board 좋아요 하기
	@Insert("insert into likes (likes_no, mb_nick, board_seq) values (null, #{mb_nick}, #{board_seq})")
	public void boardLike(Likes likes);
	
//	Board 좋아요 취소
	@Delete("delete from likes where board_seq=#{board_seq} and mb_nick=#{mb_nick}")
	public void boardLikeOp(Likes likes);

//	Board 좋아요 보기
	@Select("select count(*) from likes where board_seq=#{board_seq}")
	public int boardLikeNum(Likes likes);
	
//	Comment 좋아요 판별	
	@Select("select count(*) from likes where cmt_seq=#{cmt_seq} and mb_nick=#{mb_nick}")
	public int commentLikeCheck(Likes likes);

//	Comment 좋아요 하기
	@Insert("insert into likes (likes_no, mb_nick, cmt_seq) values (null, #{mb_nick}, #{cmt_seq})")
	public void commentLike(Likes likes);
	
//	Comment 좋아요 취소
	@Delete("delete from likes where cmt_seq=#{cmt_seq} and mb_nick=#{mb_nick}")
	public void commentLikeOp(Likes likes);

//	Comment 좋아요 보기
	@Select("select count(*) from likes where cmt_seq=#{cmt_seq}")
	public int commentLikeNum(Likes likes);
	
//	Ccomment 좋아요 판별	
	@Select("select count(*) from likes where ccmt_seq=#{ccmt_seq} and mb_nick=#{mb_nick}")
	public int ccommentLikeCheck(Likes likes);

//	Ccomment 좋아요 하기
	@Insert("insert into likes (likes_no, mb_nick, ccmt_seq) values (null, #{mb_nick}, #{ccmt_seq})")
	public void ccommentLike(Likes likes);
	
//	Ccomment 좋아요 취소
	@Delete("delete from likes where ccmt_seq=#{ccmt_seq} and mb_nick=#{mb_nick}")
	public void ccommentLikeOp(Likes likes);

//	Ccomment 좋아요 보기
	@Select("select count(*) from likes where ccmt_seq=#{ccmt_seq}")
	public int ccommentLikeNum(Likes likes);

}
