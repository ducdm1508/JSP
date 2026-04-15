package com.app.servlet;
import com.app.service.ExamService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ExamServlet extends HttpServlet {
ExamService service=new ExamService();

protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
String action=req.getParameter("action");
if(action==null) action="list";
if(action.equals("delete")){
int id=Integer.parseInt(req.getParameter("id"));
service.delete(id);
resp.sendRedirect("exam");
return;
}
req.setAttribute("list",service.getAll());
req.getRequestDispatcher("views/list.jsp").forward(req,resp);
}

protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
String name=req.getParameter("name");
String duration=req.getParameter("duration");
String description=req.getParameter("description");

boolean error=false;
if(name==null||name.isEmpty()){req.setAttribute("nameErr","required");error=true;}
if(duration==null||duration.isEmpty()||Integer.parseInt(duration)<=0){req.setAttribute("durErr","invalid");error=true;}
if(description==null||description.isEmpty()){req.setAttribute("desErr","required");error=true;}

if(error){
req.getRequestDispatcher("views/new.jsp").forward(req,resp);
return;
}

service.create(name,Integer.parseInt(duration),description);
resp.sendRedirect("exam");
}
}