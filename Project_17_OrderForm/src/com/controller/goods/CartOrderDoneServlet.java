package com.controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.OrderDTO;
import com.service.CartService;

/**
 * Servlet implementation class CartOrderDoneServlet
 */
@WebServlet("/CartOrderDoneServlet")
public class CartOrderDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("orderNum"));
		System.out.println("주문할때 파싱해온 num값:"+num);
		request.setCharacterEncoding("utf-8");

		String userid=request.getParameter("userid");
		String gCode=request.getParameter("gCode");
		String gName=request.getParameter("gName");
		int gPrice=Integer.parseInt(request.getParameter("gPrice"));
		String gSize=request.getParameter("gSize");
		String gColor=request.getParameter("gColor");
		int gAmount=Integer.parseInt(request.getParameter("gAmount"));
		String gImage=request.getParameter("gImage");
		String orderName=request.getParameter("orderName");
		String post=request.getParameter("post");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String phone=request.getParameter("phone");
		String payMethod=request.getParameter("payMethod");
		
		OrderDTO dto=new OrderDTO();
		dto.setUserid(userid);
		dto.setgCode(gCode);
		dto.setgName(gName);
		dto.setgPrice(gPrice);
		dto.setgSize(gSize);
		dto.setgColor(gColor);
		dto.setgAmount(gAmount);
		dto.setgImage(gImage);
		dto.setOrderName(orderName);
		dto.setPost(post);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setPhone(phone);
		dto.setPayMethod(payMethod);
		System.out.println("주문하는사람의 정보들 출력============"+dto);
		CartService service=new CartService();
		String str=service.orderdone(dto, num);
		System.out.println("장바구니 제거, 주문완료==="+str);
		String nextpage="orderConfirm.jsp";
		if(str!=null) {
			request.setAttribute("order", dto);
			nextpage="orderDone.jsp";
		}
		RequestDispatcher dis=request.getRequestDispatcher(nextpage);
		dis.forward(request, response);
		
		//data 파싱해오기
		//ordernum받아와서 장바구니 삭제
		//orderdone한테 orderdto(저장용), ordernum(삭제용)
		//transaction exception session.rollback() 성공시 commit()
		//request orderDTO 저장, orderDone.jsp로 이동
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
