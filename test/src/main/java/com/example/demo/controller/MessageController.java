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

import com.example.demo.model.ChatRoom;
import com.example.demo.model.Members;
import com.example.demo.model.Message;
import com.example.demo.service.MemberService;
import com.example.demo.service.MessageService;
import com.google.gson.Gson;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MessageController {
	
	Gson gson = new Gson();

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private MemberService memberService;
	
	
	@ResponseBody
	@RequestMapping(value = "/getChatRoom", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public List<ChatRoom> getChatRoom(@RequestBody Members nick) {
			
		String user = nick.getMb_nick();
		
		List<ChatRoom> cr = messageService.getChatRoom(user);			
		
		for(int i=0; i<cr.size(); i++) {
			
		Members from = (Members)memberService.getPic(cr.get(i).getFrom_nick());		
		cr.get(i).setFrom_pic(from.getMb_pic());

		Members to = (Members)memberService.getPic(cr.get(i).getTo_nick());		
		cr.get(i).setTo_pic(to.getMb_pic());	
		
		}
		
		return cr;			
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String sendMessage(@RequestBody Message message) {
		
		System.out.println("보낸메세지 : " + message);
		
		while(true){
	
			ChatRoom cr = messageService.checkRoom(message.getTo_nick(), message.getFrom_nick());
			System.out.println(cr);		
			
			if(cr != null) { // 방이 있으면
				message.setCr_seq(cr.getCr_seq());
				messageService.sendMessage(message);
				break;
			}else { // 방이 없으면
				String jsonStr = gson.toJson(message);
				System.out.println("방생성 tojson : " + jsonStr);
				ChatRoom createR = gson.fromJson(jsonStr, ChatRoom.class);
				System.out.println("방생성 fromjson : " + createR);
				messageService.createRoom(createR);			
			}
		}
		
		return "success";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getMessage", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public List<Message> getMessage(@RequestBody Message message) {
	
		return messageService.getMessage(message.getCr_seq());
								
	}
	
	@ResponseBody
	@RequestMapping(value = "/getUser", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public List<Members> getUser(@RequestBody Members user) {
		
		return memberService.getUser(user);
			
	}
	
	@ResponseBody
	@RequestMapping(value = "/getNick", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public Members getNick(@RequestBody ChatRoom cr) {
		
		return messageService.getNick(cr);	
	}
	
	@ResponseBody
	@RequestMapping(value = "/newRoom", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int newRoom(@RequestBody ChatRoom cr) {
		System.out.println(cr);
		
		ChatRoom crCk = messageService.checkRoom(cr.getTo_nick(), cr.getFrom_nick());
		
		if(crCk == null) {
			messageService.createRoom(cr);
			ChatRoom createR = messageService.checkRoom(cr.getTo_nick(), cr.getFrom_nick());
			return createR.getCr_seq();
		}else {
			return 	crCk.getCr_seq();			
		}		
	}		
}
