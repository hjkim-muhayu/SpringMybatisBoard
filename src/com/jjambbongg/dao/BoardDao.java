package com.jjambbongg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import com.jjambbongg.mapper.BoardMapper;
import com.jjambbongg.model.BoardModel;

public class BoardDao {

		private SqlSessionTemplate mysqlSession;
		
		public void setMysqlSession(SqlSessionTemplate mysqlSession) {
			this.mysqlSession = mysqlSession;
		}

		public int getBoardCount() {
			return mysqlSession.getMapper(BoardMapper.class).getBoardCount();
		}
		
		public List<BoardModel> getBoardList(@Param("boardModel") BoardModel boardModel) {
			return mysqlSession.getMapper(BoardMapper.class).getBoardList(boardModel);
		}
		
		public BoardModel getBoardView(@Param("no") int no) {
			return mysqlSession.getMapper(BoardMapper.class).getBoardView(no);
		}		
		 
		public void insertBoard(@Param("boardModel") BoardModel boardModel) {
			try {
				mysqlSession.getMapper(BoardMapper.class).insertBoard(boardModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void updateBoard(@Param("boardModel") BoardModel boardModel) {
			try {
				mysqlSession.getMapper(BoardMapper.class).updateBoard(boardModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void deleteBoard(@Param("no") int no) {
			try {
				mysqlSession.getMapper(BoardMapper.class).deleteBoard(no);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
