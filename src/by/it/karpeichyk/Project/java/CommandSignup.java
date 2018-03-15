package by.it.karpeichyk.Project.java;

import by.it.karpeichyk.Project.java.dao.BEAN.User;
import by.it.karpeichyk.Project.java.dao.DAO.MyDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 02.03.2018.
 */
public class CommandSignup extends AbstractAction {
    @Override

    public AbstractAction execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req))
            return null;
        String login =
                FormUtil.getString(req,"Login", ".+");
        String email =
                FormUtil.getString(req,"E-mail", ".+");
        String password =
                FormUtil.getString(req,"pasword", ".+");
        User user = new User(0, login, email, password, 1);
       //req.setAttribute(Msg.MESSAGE, "POST3. Юзер OK. Пробуем получить DAO");
        MyDAO dao = MyDAO.getMyDAO();
        dao.myUserDAO.create(user);
        if (user.getId() > 0)
            return Action.LOGIN.command;
        else {
            req.setAttribute(Msg.MESSAGE, "Ошибка добавления пользователя");
            return null;
        }
    }}
