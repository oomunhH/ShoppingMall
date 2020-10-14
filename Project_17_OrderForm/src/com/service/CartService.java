package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dao.GoodsDAO;
import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderDTO;

public class CartService {

	
	 public List<CartDTO> cartList(String userid) {
			SqlSession session = MySqlSessionFactory.getSession();
			List<CartDTO> list = null;
			try {
				CartDAO dao = new CartDAO();
				 list = dao.cartList(session, userid);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				session.close();
			}
			return list;
		}//end idCheck
	public int cartAdd(CartDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.cartAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}// end cartAdd
	
	public int cartDel (int num) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.cartDel(session, num);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}
	public int cartUpdate(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.cartUpdate(session, map);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}
	
	public int cartAllDel(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.cartAllDel(session, list);
			session.commit(); 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public CartDTO cartByNum(int num) {
		SqlSession session = MySqlSessionFactory.getSession();
		CartDTO dto=null;
		try {
			CartDAO dao=new CartDAO();
			dto=dao.cartByNum(session,num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public String orderdone(OrderDTO dto,int num) {
		SqlSession session = MySqlSessionFactory.getSession();
		String str=null;
		try {
			CartDAO dao=new CartDAO();
			str=dao.orderdone(session, dto, num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return str;
	}
	
	
}// end class
