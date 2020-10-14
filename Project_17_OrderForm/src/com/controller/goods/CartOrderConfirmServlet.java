package com.controller.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.MemberService;

/**
 * Servlet implementation class CartOrderConfirmServlet
 */
@WebServlet("/CartOrderConfirmServlet")
public class CartOrderConfirmServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		CartService cservice=new CartService();
		CartDTO cart=cservice.cartByNum(num);
		System.out.println(cart);
		MemberService mservice=new MemberService();
		MemberDTO user=mservice.mypage(cart.getUserid());
		System.out.println(user);
		String nextpage=null;
		if(cart!=null&&user!=null) {
			request.setAttribute("login", user);
			request.setAttribute("cart", cart);
			nextpage="orderConfirm.jsp";
		}else {
			nextpage="LoginUIServlet";
		}
		RequestDispatcher dis=request.getRequestDispatcher(nextpage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
