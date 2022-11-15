package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Comment {
	int cmt_seq;
	int board_seq;
	String cmt_content;
	String cmt_date;
	String mb_nick;
	String mb_pic;

}
