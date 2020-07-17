package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO bDao;
	
	@Override
	public void insert(BoardVO vo) {
		bDao.insert(vo);
		
	}

	@Override
	public List<BoardVO> list() {
		
		return bDao.list();
	}

	@Override
	public BoardVO read(int bno) {
		bDao.increaseViewcnt(bno);
		
		return bDao.read(bno);
	}

	@Override
	public BoardVO updateUI(int bno) {
		
		return bDao.updateUI(bno);
	}

	@Override
	public void update(BoardVO vo) {
		
		bDao.update(vo);
	}

	@Override
	public void delete(int bno) {
		bDao.delete(bno);
	}

	@Override
	public PageTO<BoardVO> list(PageTO<BoardVO> to) {
		
		return bDao.list(to);
	}

	@Override
	public List<BoardVO> searchlist(String searchType, String keyword) {
		
		return bDao.searchlist(searchType, keyword);
	}


}
