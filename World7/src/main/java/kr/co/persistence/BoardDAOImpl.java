package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private final String NS = "b.o.a";

	@Override
	public void insert(BoardVO vo) {

		Integer bno = session.selectOne(NS + ".getBno");
		if (bno != null) {
			bno += 1;
		} else {
			bno = 1;
		}

		vo.setBno(bno);

		session.insert(NS + ".insert", vo);
	}

	@Override
	public List<BoardVO> list() {

		return session.selectList(NS + ".list");
	}

	@Override
	public BoardVO read(int bno) {
		
		return session.selectOne(NS+".read", bno);
	}

	@Override
	public void increaseViewcnt(int bno) {
		session.update(NS + ".increaseViewcnt", bno);
	}

	@Override
	public BoardVO updateUI(int bno) {
		
		return session.selectOne(NS + ".updateUI", bno);
	}

	@Override
	public void update(BoardVO vo) {
		
		session.update(NS + ".update", vo);
	}

	@Override
	public void delete(int bno) {
		
		session.delete(NS + ".delete", bno);
	}

	@Override
	public PageTO<BoardVO> list(PageTO<BoardVO> to) {
		
		RowBounds rowBounds = new RowBounds(to.getStartNum()-1, to.getPerPage());
		
		List<BoardVO> list = session.selectList(NS + ".list", null, rowBounds);
		
		to.setList(list);
		
		Integer amount = session.selectOne(NS + ".getAmount");
		if (amount != null) {
			to.setAmount(amount);
		} else {
			to.setAmount(0);
		}
		return to;
	}

	@Override
	public List<BoardVO> searchlist(String searchType, String keyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
				
		
		return session.selectList(NS+".searchlist", map);
		
		
	}
	@Override
	   public void addAttach(String fullName, int bno) {
	      Integer id = session.selectOne(NS+".getId");
	      Map<String, Object> map = new HashMap<String, Object>();
	      
	      map.put("id", id);
	      map.put("fullName", fullName);
	      map.put("bno", bno);
	      
	      session.insert(NS+".addAttach", map);
	   }

	@Override
	public List<String> getAttach(Integer bno) {
		// TODO Auto-generated method stub
		return session.selectList(NS+".getAttach", bno);
	}
}
