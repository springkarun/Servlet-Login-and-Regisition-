package com.sawan.controller;


import com.sawan.dao.RegisterDao;
import com.sawan.model.RegisterModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomerRegister extends HttpServlet {


   public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
      res.setContentType("text/html");
      var out = res.getWriter();

      var id=(int)(Math.random()* 10000);
      var registerBean=  new RegisterModel("UR"+String.valueOf(id),
              req.getParameter("fname"),
              req.getParameter("lname"),
              req.getParameter("email"),
              req.getParameter("mobile"),
              req.getParameter("age"),
              req.getParameter("sex"),
              req.getParameter("password"),
              req.getParameter("city"),
              req.getParameter("address"));

      var registerDao = new RegisterDao();
      var userRegistered = registerDao.registerUser(registerBean);
      if(userRegistered.equals("SUCCESS")) {
         out.println("SUCCESS");
         req.getRequestDispatcher("/login.html").forward(req, res);
      }else{
         out.println("Faild");
         //req.setAttribute("errMessage", userRegistered);
        // req.getRequestDispatcher("/Register.jsp").forward(req, res);
      }
   }

}