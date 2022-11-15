package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Likes {
	private int likes_no;
	private String mb_nick;
	private int board_seq;	
	private int cmt_seq;	
	private int ccmt_seq;	
}
