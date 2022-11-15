package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Members {
	
	private String mb_id;
	private String mb_pw;
	private String mb_nick;
	private String mb_email;
	private String mb_joindate;
	private String mb_pic;
	private String mb_bg;
	
	public Members(String mb_id, String mb_pw) {
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
	}
	

}
