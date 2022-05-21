package ru.bankApp.servlets.employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/bank_app/employee/reg")
public class EmployeeRegisterServlet extends HttpServlet {/*
    NavBarServlet navBar = new NavBarServlet();
    private String formMessage = "";
    private String valuePhone = "";
    private String valueName = "";
    private  String valueLastName = "";
    private  String valuePostion = "";
    private  String errorPhone = "";
    private  String errorName = "";
    private  String  errorLastName = "";
    private  String errorPosition = "";
    private String errorPassword = "";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies){
            if (c.getName().equals("cName")){
                valueName = c.getValue();
            }
            if (c.getName().equals("cLastName")){
                valueLastName = c.getValue();
            }
            if (c.getName().equals("cPostion")){
                valuePostion = c.getValue();
            }
            if (c.getName().equals("cPhone")){
                valuePhone = c.getValue();
            }
        }

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().append(HtmlPage.START.getHtmlElement());


        navBar.navbar(resp,req);
        resp.getWriter().append("<p>Здравствуйте заполните форму</p>");
        regForm(req,resp);
        resp.getWriter().append(HtmlPage.END.getHtmlElement());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String position = req.getParameter("position");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        if (req.getParameter("cancel")!=null){
            resp.sendRedirect("/bank_app/employee");
        }
        if (req.getParameter("enter")!=null){
            if (req.getParameter("phone")==null|| req.getParameter("phone").length()<=0){errorPhone = "Введите телефон";}
            else {errorPhone = "";
            }
            if (name==null|| name.isEmpty()){errorName = "Введите имя";}
            else {errorName = "";
                Cookie nameCook = new Cookie("cName" , name);
                nameCook.setMaxAge(20);
                resp.addCookie(nameCook);
            }
            if (lastName==null|| lastName.isEmpty()){errorLastName = "Введите фамилию";}
            else {errorLastName = "";
                Cookie lastnameCook = new Cookie("cLastName" , lastName);
                lastnameCook.setMaxAge(20);
                resp.addCookie(lastnameCook);
            }
            if (position==null|| position.isEmpty()){errorPosition = "Введите должность";}
            else {errorPosition = "";
                Cookie positionCook = new Cookie("cPostion" , position);
                positionCook.setMaxAge(20);
                resp.addCookie(positionCook);
            }
            if (password1==null|| password1.isEmpty() || password2==null || password2.isEmpty()){errorPassword = "Введите пароль";}else {errorPassword = "";}

            if (phone!=null&&name!=null&&lastName!=null&&position!=null&&password1!=null&&password2!=null){
                if (password1.equals(password2)){
                    ServletContext context = getServletContext();
                    //ServiceEmployeeCollection serviceEmployee = (ServiceEmployeeCollection) context.getAttribute("serviceEmployee");
                   // Employee e = new Employee.Builder(phone,name, password1).lastName(lastName).position(position).nickName("").build();
                    try {
                        ServiceEmployeeCollection serviceEmployee = (ServiceEmployeeCollection) context.getAttribute("serviceEmployee");
                       // serviceEmployee.putEmployee(e);
                        Cookie user = new Cookie("employee" , phone);
                        user.setMaxAge(1*30*24*60*60);
                        resp.addCookie(user);
                        resp.sendRedirect("/bank_app/employee/main");
                    } catch (EmployNotNullEx ex) {
                        ex.printStackTrace();
                        formMessage = ex.getMessage();
                        doGet(req,resp);
                    }
                }else errorPassword = "неверный пароль";
                doGet(req,resp);

            }else {
                doGet(req,resp);
            }
        }

    }

    private  void regForm(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        resp.getWriter().append("<div>\n" +
                "        <h3>Регистрация</h3><br>\n" +
                "<h5>"+formMessage+"</h5>" +
                "    </div>\n" +
                "    <div >\n" +
                "        <form method=\"post\">\n" +
                "            <label>Name:<br />\n" +
                "                <input type=\"text\"\n" +
                "                       name=\"name\"\n" +
                "                       value=\""+valueName+"\">\n" +errorName+ "<br />\n" +
                "            </label>\n" +
                "            <label>Last Name:<br />\n" +
                "                <input type=\"text\"\n" +
                "                       name=\"lastName\"\n" +
                "                       value=\""+valueLastName+"\">\n" +errorLastName+"<br />\n" +
                "            </label>\n" +
                "            <label>Position:<br />\n" +
                "                <input type=\"text\" name=\"position\"\n" +
                "                       value=\""+valuePostion+"\">\n" +errorPosition+"<br />\n" +
                "            </label>\n" +
                "            <label>Phone :<br />\n" +
                "                <input type=\"text\"\n name=\"phone\"\n+\n" +
                "                value=\""+valuePhone+" \">\n" +errorLastName+"<br />\n" +
                "            </label>\n" +
                "            <label>Password:<br />\n" +
                "                <input type=\"password\" name=\"password1\">\n" + "<br />\n" +
                "                <input type=\"password\" name=\"password2\">\n" +errorPassword+"<br />\n" +
                "        </label>\n"+
                "            <button name=\"enter\"  type=\"submit\">Register</button>\n" +
                "            <button name=\"cancel\" type=\"submit\">Cancel</button>\n" +
                "\n" +
                "        </form>\n" +
                "\n" +
                "        </form>\n" +
                "    </div>");
    }*/
}
