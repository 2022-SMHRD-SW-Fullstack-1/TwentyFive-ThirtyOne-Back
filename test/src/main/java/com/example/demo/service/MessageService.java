package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.model.ChatRoom;
import com.example.demo.model.Members;
import com.example.demo.model.Message;



@Service
public class MessageService {

	@Autowired
	private MessageMapper messageMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	public List<ChatRoom> getChatRoom(String nick){
		return messageMapper.getChatRoom(nick);
	}
	
	public List<Message> getMessage(int cr) {
		return messageMapper.getMessage(cr);
	}
	
	public ChatRoom checkRoom(String to_nick, String from_nick) {
		return messageMapper.checkRoom(to_nick, from_nick);
	}
	
	public int createRoom(ChatRoom createR) {
		return messageMapper.createRoom(createR);
	}
	
	public int sendMessage(Message message) {
		return messageMapper.sendMessage(message);
	}

	public Members getNick(ChatRoom cr) {
		System.out.println("Service cr : " + cr);

		ChatRoom result = messageMapper.getNick(cr.getCr_seq());
		System.out.println("result cr : " + result);

		
		if(result.getFrom_nick().equals(cr.getTo_nick())) {
			System.out.println("to Nick : " + memberMapper.getFrnd(result.getTo_nick()));
			System.out.println();
			return memberMapper.getFrnd(result.getTo_nick());
		}else {
			System.out.println("from nick : " + memberMapper.getFrnd(result.getFrom_nick()));
			System.out.println();
			return memberMapper.getFrnd(result.getFrom_nick());
		}		
	}
	
}
