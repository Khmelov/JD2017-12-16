package by.it.karpeichyk.Project.java;

import by.it.karpeichyk.Project.java.dao.BEAN.Ad;
import by.it.karpeichyk.Project.java.dao.BEAN.User;
import by.it.karpeichyk.Project.java.dao.DAO.MyDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 04.03.2018.
 */
public class CommandCreateAd implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req))
            return Action.CreateAd.jsp;
        req.setAttribute(Msg.MESSAGE, "POST OK. Начинаем проверку полей.");
        String login =
                FormUtil.getString(req.getParameter("Login"), ".+");
        String description =
                FormUtil.getString(req.getParameter("Description"), ".+");
        String carrying =
                FormUtil.getString(req.getParameter("Carrying"), ".+");
        String volume =
                FormUtil.getString(req.getParameter("Volume"), ".+");
        String tariff =
                FormUtil.getString(req.getParameter("Tariff"), ".+");
        req.setAttribute(Msg.MESSAGE, "POST2. Поля OK. Пробуем создать объявление.");
        Ad ad = new Ad(0,login,description,carrying,volume,tariff);
        req.setAttribute(Msg.MESSAGE, "POST3. Объявление OK. Пробуем получить DAO");
        MyDAO dao = MyDAO.getMyDAO();
        req.setAttribute(Msg.MESSAGE, "POST4. DAO OK. Пробуем выполнить команду create (если завершается, то вы не скопировали библиотеку mysql-connector-java.jar в lib-local");
        dao.myAdDAO.create(ad);
        req.setAttribute(Msg.MESSAGE, "POST5. SQL OK. Проверьте объявление в базе.");
        if (ad.getId() > 0)
            return Action.CreateAd.jsp;
        else {
            req.setAttribute(Msg.MESSAGE, "Ошибка добавления объявления");
            return Action.CreateAd.jsp;
        }
    }}



