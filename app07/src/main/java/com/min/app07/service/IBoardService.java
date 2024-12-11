package com.min.app07.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.min.app07.dto.BoardDto;

public interface IBoardService {
  Map<String, Object> getBoardList(HttpServletRequest repuest); // BoardController 로 부터 받아옴
  BoardDto getBoardById(int boardId);
  String modifyBoard(BoardDto boardDto);
  String removeBoard(int boardId);
  String remobeBoardList(String[] numbers);
  String registerBoard(BoardDto boardDto);
  Map<String, Object> getSearchList(HttpServletRequest request);
}
