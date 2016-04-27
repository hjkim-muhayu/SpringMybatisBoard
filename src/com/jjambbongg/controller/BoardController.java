package com.jjambbongg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jjambbongg.dao.BoardDao;
import com.jjambbongg.model.BoardModel;
import com.jjambbongg.util.PageNavigator;

@Controller
public class BoardController {
	
	private BoardDao dao;
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value={"/boardList.do", "/"}) 
	public ModelAndView boardList(@RequestParam(value="pageNum", required=false) String pageNum, 
			                      @RequestParam(value="searchText", required=false) String searchText) {		
		if(pageNum==null) {
			pageNum = "1";
		}
		if(searchText==null) {
			searchText = "";
		}
		int totalCount = dao.getBoardCount();
		BoardModel boardModel = new BoardModel();
		boardModel.setPageNum(pageNum);
		boardModel.setSearchText(searchText);
		boardModel.setStartIndex((Integer.parseInt(pageNum) - 1)* boardModel.getListCount());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardModel", boardModel);
		mav.addObject("boardList", dao.getBoardList(boardModel));
		mav.addObject("totalCount", totalCount);
		mav.addObject("PageNavigator", new PageNavigator().getPageNavigator(
				totalCount,  
				boardModel.getListCount(), 
				boardModel.getPagePerBlock(), 
				Integer.parseInt(boardModel.getPageNum()), 
				boardModel.getSearchText())
				);
		mav.setViewName("boardList");
		return mav;
	}
			
	@RequestMapping(value="/boardView.do")
	public ModelAndView boardView(@RequestParam int no, @RequestParam String pageNum, @RequestParam String searchText) {
		BoardModel boardModel = new BoardModel();
		boardModel.setPageNum(pageNum);
		boardModel.setSearchText(searchText);
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardModel", boardModel);
		mav.addObject("boardView", dao.getBoardView(no));
		mav.setViewName("boardView");
		return mav;
	}
	
	@RequestMapping(value="/boardWrite.do", method=RequestMethod.GET)
	public ModelAndView boardWriteForm(@RequestParam String pageNum, @RequestParam String searchText) {
		BoardModel boardModel = new BoardModel();
		boardModel.setPageNum(pageNum);
		boardModel.setSearchText(searchText);
		ModelAndView mav = new ModelAndView();
		mav.addObject(boardModel);
		mav.setViewName("boardWrite");
		return mav;
	}
	
	@RequestMapping(value="/boardWrite.do", method=RequestMethod.POST)
	public ModelAndView boardWrite(@RequestParam String title, @RequestParam String contents, @RequestParam String pageNum, @RequestParam String searchText) {
		BoardModel boardModel = new BoardModel();
		boardModel.setTitle(title);
		boardModel.setContents(contents);
		dao.insertBoard(boardModel);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/boardList.do?pageNum="+pageNum+"&searchText="+searchText);
		return mav;
	}	
	
	@RequestMapping(value="/boardUpdate.do", method=RequestMethod.GET)
	public ModelAndView boardUpdateForm(@RequestParam("no") int no, @RequestParam String pageNum, @RequestParam String searchText) {
		BoardModel boardModel = new BoardModel();
		boardModel.setPageNum(pageNum);
		boardModel.setSearchText(searchText);	
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardUpdate", dao.getBoardView(no));
		mav.addObject("boardModel", boardModel);	
		mav.setViewName("boardUpdate");
		return mav;	
	}
	
	@RequestMapping(value="/boardUpdate.do", method=RequestMethod.POST)
	public ModelAndView boardUpdate(@RequestParam int no, @RequestParam String title, @RequestParam String contents, @RequestParam String pageNum, @RequestParam String searchText) {
		BoardModel boardModel = new BoardModel();
		boardModel.setNo(no);
		boardModel.setTitle(title);
		boardModel.setContents(contents);
		dao.updateBoard(boardModel);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/boardList.do?pageNum="+pageNum+"&searchText="+searchText);
		return mav;
	}	
	
	@RequestMapping(value="/boardDelete.do")
	public ModelAndView boardDelete(@RequestParam int no, @RequestParam String pageNum, @RequestParam String searchText) {
		dao.deleteBoard(no);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/boardList.do?pageNum="+pageNum+"&searchText="+searchText);
		return mav;
	}
			
			
}
