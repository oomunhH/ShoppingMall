package com.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderDTO;


public class CartDAO {

	 public List<CartDTO> cartList(SqlSession session, String userid) {
		   List<CartDTO> list = 
				   session.selectList("CartMapper.cartList", userid);
		   return list;
	   }
	public int cartAdd(SqlSession session, CartDTO dto) {
		int n = session.insert("CartMapper.cartAdd", dto);
		return n;
	}
	public int cartDel(SqlSession session, int num) {
		int n = session.delete("CartMapper.cartDel", num);
		return n;
	}
	public int cartUpdate(SqlSession session, HashMap<String, Integer> map) {
		int n = session.update("CartMapper.cartUpdate", map); 
		return n;
	}
	
	public int cartAllDel(SqlSession session, List<String> list) {
		int n = session.delete("CartMapper.cartAllDel", list);
		return n;
	}
	
	public CartDTO cartByNum(SqlSession session,int num) {
		CartDTO dto=session.selectOne("cartByNum",num);
		return dto;
	}
	
	public String orderdone(SqlSession session,OrderDTO dto,int num) {
		int i=session.insert("insertOrderInfo",dto);
		int d=session.delete("deleteByNum",num);
		String str="insert횟수:"+i+"delete횟수:"+d;
		return str;
	}
}
