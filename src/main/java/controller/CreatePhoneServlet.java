package controller;

import entity.Phone;
import service.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CreatePhoneServlet extends HttpServlet {
    private PhoneService phoneService = new PhoneService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("errors", new HashMap<String, String>());
        req.getRequestDispatcher("/addphone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String price = req.getParameter("price");
        String description = req.getParameter("description");

        Phone phone = new Phone(name, brand, price, description);

        HashMap<String, String> errors = phone.validPhone();
        if (errors.size()>0){
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/addphone.jsp").forward(req, resp);
            return;
        }

        if(phoneService.save(phone)){
            resp.sendRedirect("/listphone.jsp");
        }else{
            resp.getWriter().println("ERROR: có lỗi xảy ra vui lòng thử lại");
        }
    }
}
