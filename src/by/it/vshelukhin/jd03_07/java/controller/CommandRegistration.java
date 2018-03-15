package by.it.vshelukhin.jd03_07.java.controller;

import by.it.vshelukhin.jd03_07.java.controller.Action;
import by.it.vshelukhin.jd03_07.java.controller.Actions;
import by.it.vshelukhin.jd03_07.java.controller.FormUtil;
import by.it.vshelukhin.jd03_07.java.controller.Msg;
import by.it.vshelukhin.jd03_07.java.dao.DAO;
import by.it.vshelukhin.jd03_07.java.entity.Student;

import javax.servlet.http.HttpServletRequest;

public class CommandRegistration extends Action {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        if (!FormUtil.isPost(request)) return Actions.REGISTRATION.actionCommand;
        request.setAttribute(Msg.MESSAGE,"POST OK. Начинаем проверку полей.");
        String login =
                FormUtil.getString(request.getParameter("Login"), ".+");
        String password =
                FormUtil.getString(request.getParameter("Password"), ".+");
        request.setAttribute(Msg.MESSAGE,"POST2. Поля OK. Пробуем создать юзера.");
        Student stud=new Student(0,login,password,"",0, "",0.0,1);
        request.setAttribute(Msg.MESSAGE,"POST3. Юзер OK. Пробуем получить DAO");
        DAO dao=DAO.getDAO();
        request.setAttribute(Msg.MESSAGE,"POST4. DAO OK. Пробуем выполнить команду create (если завершается, то вы не скопировали библиотеку mysql-connector-java.jar в lib-local");
        dao.studentDAO.create(stud);
        request.setAttribute(Msg.MESSAGE,"POST5. SQL OK. Проверьте пользователя в базе.");
        if (stud.getId()>0)
            return Actions.LOGIN.actionCommand;
        else
        {
            request.setAttribute(Msg.MESSAGE,"Ошибка добавления пользователя");
            return Actions.REGISTRATION.actionCommand;
        }

    }
}
