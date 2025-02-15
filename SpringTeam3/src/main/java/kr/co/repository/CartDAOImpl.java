package kr.co.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.CartVO;

@Repository
public class CartDAOImpl implements CartDAO{

	@Inject
	private SqlSession sqlSession;
	
	private final String NS = "kr.co.cart";

	@Override
	public int getCartCount(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getCartCount", memberNo);
	}

	@Override
	public List<CartVO> getCartList(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+".getCartList", memberNo);
	}

	@Override
	public int insert(CartVO cartVO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+".insert", cartVO);
	}

	@Override
	public int cartSearch(CartVO cartVO) {
		Integer cartNo = sqlSession.selectOne(NS+".cartSearch", cartVO);
		if(cartNo == null) {
			cartNo = -1;
		}
		return cartNo;
	}


	@Override
	public int delete(int cartNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete(NS+".delete", cartNo);
	}


	@Override
	public int cartUpdate(CartVO cartVO) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+".cartUpdate", cartVO);
	}

	@Override
	public CartVO getCart(int cartNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getCart", cartNo);
	}
}
