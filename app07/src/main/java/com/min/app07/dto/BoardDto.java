package com.min.app07.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class BoardDto {
	private int boardId;
	private String titile;
	private String contents;
	private Timestamp createDt;
	private int usrId;

}
