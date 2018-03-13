package by.it.vshelukhin.jd03_06.java.controller;

import by.it.vshelukhin.jd03_06.java.dao.DAO;
import by.it.vshelukhin.jd03_06.java.entity.Student;
import by.it.vshelukhin.jd03_06.java.entity.Work;
import by.it.vshelukhin.jd03_06.java.entity.Zakaz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandAllOrders extends Action {
    @Override
    public Action execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("student");
        Student student;
        if (o != null) {
            student = (Student) o;
        } else return Actions.LOGIN.actionCommand;
        DAO dao = DAO.getDAO();
        String zakazNameDel = request.getParameter("zakazDel");
        if (zakazNameDel != null && !zakazNameDel.equals("Выберете заказ для удаления")){
            Work work = dao.workDAO.readAll(String.format("WHERE name='%s'",zakazNameDel)).get(0);
            Zakaz zakazDel = dao.zakazDAO.readAll(String.format("WHERE students_id=%d and works_id=%d",student.getId(),work.getId())).get(0);
            dao.zakazDAO.delete(zakazDel);
        }

        List<Zakaz> zakazAll = dao.zakazDAO.readAll(String.format("WHERE students_id=%d",student.getId()));
        List<Work> workAll = new ArrayList<>();
        double priceTotal = 0.0;
        for (Zakaz zakaz : zakazAll) {
            Work curWork = dao.workDAO.read(zakaz.getWorks_id());
            priceTotal = priceTotal + curWork.getPrice();
            workAll.add(curWork);
        }
        student.setPrice(priceTotal);
        dao.studentDAO.update(student);
        request.setAttribute("wrk",workAll);
        request.setAttribute("priceAll",Double.toString(priceTotal));

        return null;
    }
}
