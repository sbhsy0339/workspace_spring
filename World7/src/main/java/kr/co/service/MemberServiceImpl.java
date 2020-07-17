package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;
import kr.co.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO memberDao;

	@Override
	public void insert(MemberDTO dto) {

		memberDao.insert(dto);
	}

	@Override
	public List<MemberDTO> list() {

		return memberDao.list();
	}

	@Override
	public MemberDTO read(String id) {

		return memberDao.read(id);
	}

	@Override
	public MemberDTO updateui(String id) {

		return memberDao.updateui(id);
	}

	@Override
	public void update(MemberDTO dto) {
		memberDao.update(dto);
	}

	@Override
	public void delete(String id) {
		memberDao.delete(id);
	}

	@Override
	public MemberDTO loginpost(LoginDTO login) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public MemberDTO loginpost(LoginDTO login) { // TODO Auto-generated
	 * method stub return session.selectOne(NS+".loginpost", login); }
	 */
}
