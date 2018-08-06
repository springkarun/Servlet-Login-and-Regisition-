package com.sawan.controller;


import com.sawan.dao.LoginDao;
import com.sawan.model.LoginModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomerLogin extends HttpServlet {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        var out = resp.getWriter();
        var email = req.getParameter("email");
        var password = req.getParameter("password");
        var loginDao = new LoginDao();
        var list = loginDao.loginUser(email, password);

        try {
            if (!(list.isEmpty())) {
                //if list has some values then you are logged in
                out.print("</br> <h1 align='center'>Congrats!You've SuccessFully Logged In Sawan Shoping</h1> </br> </br>");
                out.print("<table align ='center' border='1' cellspacing='7' cellpadding='7'>" +
                        "<tr>" +
                        "<th>ID</th>" +
                        "<th>NAME</th>" +
                        "<th>Mobile</th>"+
                        "<th>Email</th>" +
                        "<th>Age</th>" +
                        "<th>City</th>" +
                        "<th>Address</th>" +

                        "</tr>");
                for (LoginModel i : list) {
                    //printing all the values in the list
                    out.print("<tr><td>" + i.getUser_id() + "</td>");
                    out.print("<td>" + i.getFname() + " " + i.getLname() + "</td>");
                    out.print("<td>" + i.getMobile() + "</td>");
                    out.print("<td>" + i.getEmail() + "</td>");
                    out.print("<td>" + i.getAge() + "</td>");
                    out.print("<td>" + i.getCity() + "</td>");
                    out.print("<td>" + i.getAddress() + "</td></tr>");
                }
                out.print("</table>");

            } else {
                //if no values are found then the User does not exist
                // req.getRequestDispatcher("login.jsp").include(req, resp);
                out.print("<p align='center'>User Does Not Exist! Please Register");
                out.print("<a href='register.html'>Register Here</a></p>");
            }
        } catch (Exception e) {
            // req.getRequestDispatcher("login.jsp").include(req, resp);
            out.print("<p>Please Enter Valid Details To Login</p>");
//executes when user enters invalid details

        }

    }

}




     /* if(userLogin.equals("SUCCESS")) {
         out.println("SUCCESS");
         // req.getRequestDispatcher("/Home.jsp").forward(req, res);
      }else{
         out.println("Faild");
         //req.setAttribute("errMessage", userRegistered);
        // req.getRequestDispatcher("/Register.jsp").forward(req, res);
      }*/


