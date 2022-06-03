package com.waifus.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.waifus.model.User;
import com.waifus.services.PropertiesService;
import com.waifus.services.ResponseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class UserSearchServlet extends HttpServlet {
    private Properties prop;

    @Override
    public void init() throws ServletException {
        super.init();
        // AQUI SE HARIA EL CAMBIO DE IDIOMA
        this.prop = PropertiesService.getProperties("config_es");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseService<User> responseService = new ResponseService<User>();
        User user = new User();
        ArrayList<User> users= new ArrayList<User>();
        int idx = Integer.parseInt(req.getParameter("idx"));
        int pag = Integer.parseInt(req.getParameter("pag"));
        String term = req.getParameter("term");
        try {
            users = user.search(idx, pag, term);
            JsonObject json = new JsonObject();
            json.add("users", new Gson().toJsonTree(users));
            responseService.outputResponse(resp, json.toString(), 200);
        }catch (SQLException e){
            System.out.println(prop.getProperty("error.db"));
            System.out.println(e.getMessage());
            responseService.outputResponse(resp, responseService.errorResponse(prop.getProperty("error.db")), 400);
        }catch (Exception e){
            System.out.println(prop.getProperty("error.generic"));
            System.out.println(e.getMessage());
            responseService.outputResponse(resp, responseService.errorResponse(e.getMessage()), 400);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
