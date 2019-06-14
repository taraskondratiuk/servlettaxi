package ua.gladiator.controller;

import ua.gladiator.controller.command.Command;
import ua.gladiator.controller.command.Login;
import ua.gladiator.controller.command.Logout;
import ua.gladiator.controller.command.Register;
import ua.gladiator.model.entity.Car;
import ua.gladiator.model.service.impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();

    public void init(){
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("logout", new Logout());

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        System.out.println("servlet work1");
        List<Car> cars = new CarServiceImpl().getAll();
        cars.forEach(System.out::println);
        System.out.println("servlet work2");
        String path = req.getRequestURI();
        System.out.println(path);
        //path = path.replaceAll("\\.jsp" , "");
        path = path.replaceAll(".*/taxi/","");
        path = path.replaceAll("\\.jsp","");
        System.out.println("path " + path);
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp");
        System.out.println(command);
        String page = command.execute(req);
        System.out.println("LSDLKFJLKSDGJ" + page);
        //if(page.contains("redirect")){

            //resp.sendRedirect(page.replace("redirect", ""));
        //}else {
        //ServletOutputStream out = resp.getOutputStream();
        //out.println("<h3>Text of ForwardDemoServlet</h3>");
        //out.println("- servletPath=" + req.getServletPath());
        req.getRequestDispatcher(page).forward(req, resp);
        //}


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}

