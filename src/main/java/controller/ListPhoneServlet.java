package controller;

import entity.Phone;
import service.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListPhoneServlet extends HttpServlet {
    private PhoneService phoneService = new PhoneService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Phone> phoneList = phoneService.findAll();
        req.setAttribute("phoneList", phoneList);
        req.getRequestDispatcher("/listphone.jsp").forward(req, resp);
    }
}
