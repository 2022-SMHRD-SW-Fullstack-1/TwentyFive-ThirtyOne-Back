package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Ccomment {
	int ccmt_seq;
	int cmt_seq;
	int board_seq;
	String ccmt_content;	
	String ccmt_date;
	String mb_nick;
	String mb_pic;
}
