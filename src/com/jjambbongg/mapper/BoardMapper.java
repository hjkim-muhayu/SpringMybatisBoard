package com.jjambbongg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jjambbongg.model.BoardModel;

public interface BoardMapper {
	
	int getBoardCount();
	
	List<BoardModel> getBoardList(@Param("boardModel") BoardModel boardModel);
	
	BoardModel getBoardView(@Param("no") int no);
	
	void insertBoard(@Param("boardModel") BoardModel boardModel);
	
	void updateBoard(@Param("boardModel") BoardModel boardModel);
	
	void deleteBoard(@Param("no") int no);
	
}
