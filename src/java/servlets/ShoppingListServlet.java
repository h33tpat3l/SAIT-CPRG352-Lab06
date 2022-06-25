/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Item;

/**
 *
 * @author heetk
 */
public class ShoppingListServlet extends HttpServlet {
    
    private ArrayList<Item> itemList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String redirectionPath = session.getAttribute("userName") != null ? "/WEB-INF/shoppingList.jsp" : "/WEB-INF/register.jsp";
        getServletContext().getRequestDispatcher(redirectionPath).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String redirectionPath = "/WEB-INF/register.jsp";
        switch(action) {
            case "register" : {
                String userName = request.getParameter("username");
                if(Objects.nonNull(userName) && !userName.equals("")) {
                    session.setAttribute("userName", userName);
                    redirectionPath = "/WEB-INF/shoppingList.jsp";
                } else {
                    session.setAttribute("message", "Enter valid username!");
                }
                break;
            } 
            case "logout" : {
                if(session.getAttribute("userName") != null) {
                    redirectionPath = "/WEB-INF/register.jsp";
                    itemList.clear();
                    session.invalidate();
                }
                break;
            }
            case "delete" : {
                String itemToDelete = request.getParameter("itemlist");
                itemList.removeIf(e->e.getName().equals(itemToDelete));
                session.setAttribute("items", itemList);
                redirectionPath = "/WEB-INF/shoppingList.jsp";
                break;
            }
            case "add" : {
                if(session.getAttribute("items")!=null) {
                   itemList = (ArrayList<Item>) session.getAttribute("items");
                }
                String itemName = request.getParameter("itemname");
                Item item = new Item(itemName);
                itemList.add(item);
                session.setAttribute("items", itemList);
                redirectionPath = "/WEB-INF/shoppingList.jsp";
                break;
            }
        }
        getServletContext().getRequestDispatcher(redirectionPath).forward(request, response); 
    }

}
