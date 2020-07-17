package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.MemberDTO;
import kr.co.persistence.MemberDAO;

@Service
public class MemberServiceImp1 implements MemberService{

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
	
	
}
