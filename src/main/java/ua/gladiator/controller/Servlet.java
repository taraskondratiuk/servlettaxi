package ua.gladiator.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import ua.gladiator.controller.command.*;
import ua.gladiator.model.entity.Car;
import ua.gladiator.model.service.ClientService;
import ua.gladiator.model.service.impl.CarServiceImpl;
import ua.gladiator.model.service.impl.ClientServiceImpl;

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
        commands.put("user/home", new UserHome());
        commands.put("admin/home", new AdminHome());
        commands.put("index", new Index());
        commands.put("user/history", new OrderHistory());
        commands.put("admin/deny", new Deny());
        commands.put("user/deny", new Deny());
        commands.put("deny", new Deny());
        commands.put("user/order", new MakeOrder());
        commands.put("user/changepw", new ChangePassword());
        commands.put("admin/changepw", new ChangePassword());
        commands.put("admin/clients", new ClientDetails());
        commands.put("admin/cars", new CarDetails());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
ClientService clientService = new ClientServiceImpl();
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        System.out.println("servlet work1");
        /*List<Car> cars = new CarServiceImpl().getAll();
        cars.forEach(System.out::println);*/


        String path = req.getRequestURI();
        System.out.println(path);
        //path = path.replaceAll("\\.jsp" , "");
        path = path.replaceAll(".*/taxi/","");
        path = path.replaceAll("\\.jsp","");
        System.out.println("path " + path);
        Command command = commands.getOrDefault(path ,
                (r)->"redirect/index");
        System.out.println(command);
        String page = command.execute(req);
        System.out.println("LSDLKFJLKSDGJ" + page);
        if(page.contains("redirect")){

            resp.sendRedirect(page.replace("redirect", "/taxi"));
        }else {
        //ServletOutputStream out = resp.getOutputStream();
        //out.println("<h3>Text of ForwardDemoServlet</h3>");
        //out.println("- servletPath=" + req.getServletPath());
            req.getRequestDispatcher(page).forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}

