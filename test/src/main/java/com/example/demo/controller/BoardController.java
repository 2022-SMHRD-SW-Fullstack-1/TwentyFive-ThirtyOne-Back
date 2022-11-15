package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Board;
import com.example.demo.model.Ccomment;
import com.example.demo.model.Comment;
import com.example.demo.model.Members;
import com.example.demo.service.BoardService;
import com.google.gson.Gson;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BoardController {

	Gson gson = new Gson();
	
	@Autowired
	private BoardService boardService;
		
	@ResponseBody
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void boardWrite(@RequestBody Board board) {
		
		String fileName = board.getBoard_file();
		
		if(fileName=="") {          
			boardService.boardWrites(board.getBoard_title(),board.getBoard_content(),board.getBoard_type(), board.getMb_nick());
		}else {
			boardService.boardWrite(board.getBoard_title(),board.getBoard_content(),fileName,board.getBoard_type(), board.getMb_nick());
            
		}
         
    }
	@ResponseBody
	@RequestMapping(value = "/blog/{board_seq}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public List<Board> selectOneBoard(@PathVariable("board_seq") int board_seq, Model model) {
		
		model.addAttribute("oneBoard", boardService.selectOneBoard(board_seq));
		List<Board> oneBoard = boardService.selectOneBoard(board_seq);
		System.out.println(oneBoard);
		return oneBoard;
	}

	@ResponseBody
	@RequestMapping(value = "/post/{board_type}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public List<Board> selectAllBoard(@PathVariable("board_type") String board_type, Model model) {
		
		String jsonString = gson.toJson(board_type);		
		model.addAttribute("allBoard", boardService.selectAllBoard(board_type));
		List<Board> allBoard = boardService.selectAllBoard(board_type);
		return allBoard;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getposts", method = RequestMethod.GET, produces = "application/json; charset=utf8")
    public List<Board> getposts() {
		
		return boardService.getposts();
	}
	@ResponseBody
	@RequestMapping(value = "/getcomment", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public List<Comment> getcomment() {
		
		return boardService.getcomment();
	}
	@ResponseBody
	@RequestMapping(value = "/getccomment", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public List<Ccomment> getccomment() {
		
		return boardService.getccomment();
	}
	
	@ResponseBody
	@RequestMapping(value = "/board/{board_seq}/edit", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public Board boardEdit(@PathVariable("board_seq") int board_seq) {
		
		System.out.println(board_seq);
		
		return boardService.boardEdit(board_seq);
	}
	
	@ResponseBody
	@RequestMapping(value = "/board/update", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void boardUpdate(@RequestBody Board board) {
		boardService.boardUpdate(board);		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void deleteBoard(@RequestBody Board board) {
		boardService.deleteBoard(board);
	}
}
