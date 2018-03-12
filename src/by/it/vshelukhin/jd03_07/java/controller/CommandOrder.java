package by.it.vshelukhin.jd03_07.java.controller;

import by.it.vshelukhin.jd03_07.java.controller.Action;
import by.it.vshelukhin.jd03_07.java.controller.Actions;
import by.it.vshelukhin.jd03_07.java.controller.FormUtil;
import by.it.vshelukhin.jd03_07.java.controller.Msg;
import by.it.vshelukhin.jd03_07.java.dao.DAO;
import by.it.vshelukhin.jd03_07.java.entity.Student;
import by.it.vshelukhin.jd03_07.java.entity.Work;
import by.it.vshelukhin.jd03_07.java.entity.Zakaz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandOrder extends Action {
    @Override
    public Action execute(HttpServletRequest request) throws SQLException, ParseException {
        DAO dao = DAO.getDAO();
        List<Work> worksAll = dao.workDAO.readAll("");
        request.setAttribute("wrk",worksAll);
        if (!FormUtil.isPost(request)) return Actions.ORDER.actionCommand;

        HttpSession session = request.getSession();
        Object o = session.getAttribute("student");
        Student student;
        if (o != null) {
            student = (Student) o;
        } else
            return Actions.LOGIN.actionCommand;

        String mes = "";
        String zakazName = FormUtil.getString(request.getParameter("zakaz"), ".+");
        if (zakazName.matches("Контрольная.+")) {
            Work zakWork = dao.workDAO.readAll(String.format("WHERE name='%s'", zakazName)).get(0);
            Zakaz zakaz = new Zakaz(0, student.getId(), zakWork.getId());
            dao.zakazDAO.create(zakaz);
            mes = "Вы заказали: " + zakWork.getName();
        }
        else {
            mes = "Вы ничего не выбрали!";
        }

        if (mes != null) request.setAttribute(Msg.MESSAGE,mes);

        return Actions.ORDER.actionCommand;
    }
}
