package ua.gladiator.controller.filter;

import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.enums.Role;
import ua.gladiator.model.service.ClientService;
import ua.gladiator.model.service.impl.ClientServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    private ClientService clientService = new ClientServiceImpl();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        final HttpSession session = req.getSession();
      /*  final String sessionLogin = session.getAttribute("login");
        final String sessionPassword = session.getAttribute("password");*/



        String path = req.getRequestURI();
        Client client = (Client) req.getSession().getAttribute("client");

        if(path.contains("user")) {
            if (client != null) {
                if(client.getRole() == Role.ROLE_USER) {
                    chain.doFilter(request,response);
                    return;
                }

            }
            res.sendRedirect("/taxi/deny");
            //req.getRequestDispatcher("deny").forward(req, res);


        }else if(path.contains("admin")){
            if (client != null) {
                if(client.getRole() == Role.ROLE_ADMIN) {
                    chain.doFilter(request,response);
                    return;
                }

            }
            res.sendRedirect("/taxi/deny");
            //req.getRequestDispatcher("deny").forward(req, res);
        } else {
            chain.doFilter(request, response);
        }





        /*if(session != null &&
        session.getAttribute("login") != null &&
        session.getAttribute("password") != null) {
            req.getRequestDispatcher()
            moveToHomepage(req, res,( (Client)session.getAttribute("client")).getRole());
            System.out.println();
        } else if (clientService.isRegistered(login, password)){
            Client client = clientService.getClient(login);
            System.out.println( "got client " + client);
            req.getSession().setAttribute("password", client.getPassword());
            req.getSession().setAttribute("login", client.getLogin());
            req.getSession().setAttribute("role", client.getRole());
            req.getSession().setAttribute("client", client);
            moveToHomepage(req, res, client.getRole());
        }*/
    }

    private void moveToHomepage(HttpServletRequest req, HttpServletResponse res, Role role) throws ServletException, IOException {
        System.out.println("filter work");
        if(role.equals(Role.ROLE_ADMIN)) {
            System.out.println("admin");
            req.getRequestDispatcher("redirect/admin/home").forward(req, res);

        }
        else if(role.equals(Role.ROLE_USER)) {
            System.out.println("user");
            req.getRequestDispatcher("redirect/user/home").forward(req, res);
        } else {

        }
    }

    @Override
    public void destroy() {

    }
}
