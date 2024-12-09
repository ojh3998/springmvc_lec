package com.min.app07.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.app07.dto.BoardDto;

// import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository  // DAO 에서 사용하는 @Component입니다. Spring Container에 IBoardDao 타입의 bean이 생성됩니다.
public class BoardDaoImpl implements IBoardDao {
	
	private final SqlSessionTemplate template;
	
    /* 
	public BoardDaoImpl(@NonNull SqlSessionTemplate template) { //bean  을가져올땐 type 으로 가져온다. (생성자 주입은 @Autowired생략가능)
		super();
		this.template = template;
	}
	*/
	
	/*
	 * 매퍼의 SQL 구문 호출하는 방식
	 * 
	 * selectList(SQL의 id[, Parameter])
	 *  selectOne(SQL의 id[, Parameter])
	 *     insert(SQL의 id[, Parameter])
	 *     update(SQL의 id[, Parameter])
	 *     delete(SQL의 id[, Parameter])
	 */

	@Override
	public List<BoardDto> selectBoardList() {
		 List<BoardDto> boardList = template.selectList("mybatis.mappers.boardMapper.selectBoardList");
		return boardList;
	}

	@Override
	public int selectBoardCount() {
		int boardCount = template.selectOne("mybatis.mappers.boardMapper.selectBoardCount");
		return boardCount;
	}

	@Override
	public BoardDto selectBoardById(int boardId) {
		BoardDto boardDto = template.selectOne("mybatis.mappers.boardMapper.selectBoardById", boardId);
		return boardDto;
	}

	@Override
	public int insertBoard(BoardDto boardDto) {
		int result = template.insert("mybatis.mappers.boardMapper.insertBoard", boardDto);
		return result;
	}

	@Override
	public int updateBoard(BoardDto boardDto) {
       int result = template.update("mybatis.mappers.boardMapper.updateBoard", boardDto);
	   return result;
	}

	@Override
	public int deleteBoard(int boardDto) {
		int result = template.delete("mybatis.mappers.boardMapper.deleteBoard", template);
		return result;
	}

}
