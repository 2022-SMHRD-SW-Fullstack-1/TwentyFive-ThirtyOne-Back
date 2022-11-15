package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Board;
import com.example.demo.model.Ccomment;
import com.example.demo.model.Comment;

@Mapper
public interface BoardMapper {

	
	@Insert("insert into board (board_title, board_content, board_file, board_type, mb_nick, board_date) values (#{board_title}, #{board_content}, #{board_file}, #{board_type}, #{mb_nick}, now())")
	public void boardWrite(String board_title, String board_content, String board_file, String board_type, String mb_nick);	
	@Insert("insert into board (board_title, board_content, board_type, mb_nick, board_date) values (#{board_title}, #{board_content},#{board_type}, #{mb_nick}, now())")
	public void boardWrites(String board_title, String board_content, String board_type, String mb_nick);
//	select * from board where board_type=#{board_type} ORDER BY board_seq DESC
	@Select("SELECT b.board_seq, b.board_title, b.board_date, b.mb_nick, b.board_file, b.board_type, b.board_content, m.mb_pic FROM board b LEFT JOIN members m	ON m.mb_nick = b.mb_nick where board_type=#{board_type} ORDER BY b.board_seq DESC")
	public List<Board> selectAllBoard(String board_type);
	
	@Select("select * from board where board_seq=#{board_seq}")
	public List<Board> selectOneBoard(int board_seq);
	
	// 홈화면, 마이프로필에 보여줄 게시글, 댓글들
	@Select("SELECT b.board_seq, b.board_title, b.board_date, b.mb_nick, b.board_file, b.board_type, b.board_content, m.mb_pic FROM board b LEFT JOIN members m	ON m.mb_nick = b.mb_nick ORDER BY b.board_seq DESC")
	public List<Board> getposts();
	@Select("SELECT b.board_seq, count(c.cmt_seq) as cmt_count FROM board b LEFT JOIN comment c ON b.board_seq = c.board_seq GROUP BY b.board_seq ORDER BY b.board_seq DESC")
	public List<Board> getComCount();
	@Select("SELECT b.board_seq , count(l.likes_no) as like_count FROM board b LEFT JOIN likes l ON b.board_seq = l.board_seq GROUP BY b.board_seq ORDER BY b.board_seq DESC")
	public List<Board> getlike();
	@Select("SELECT c.cmt_seq, c.board_seq, c.cmt_content, c.cmt_date, m.mb_nick, m.mb_pic FROM comment c LEFT JOIN members m ON m.mb_nick = c.mb_nick")
	public List<Comment> getcomment();
	@Select("SELECT cc.ccmt_seq, cc.cmt_seq, cc.board_seq, cc.ccmt_content, cc.ccmt_date, m.mb_nick, m.mb_pic FROM ccomment cc LEFT JOIN members m ON m.mb_nick = cc.mb_nick")
	public List<Ccomment> getccomment();
	
	@Select("SELECT * FROM board WHERE board_seq=#{board_seq}")
	public Board boardEdit(int board_seq);
	
	@Update("UPDATE board SET board_title=#{board_title}, board_content=#{board_content} WHERE board_seq=#{board_seq}")
	public void boardUpdate(Board board);
	
	@Delete("DELETE FROM board WHERE board_seq=#{board_seq}")
	public void deleteBoard(Board board);
}
