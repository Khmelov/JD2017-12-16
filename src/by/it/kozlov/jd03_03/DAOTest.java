package by.it.kozlov.jd03_03;

import by.it.kozlov.jd03_03.beans.Role;
import by.it.kozlov.jd03_03.beans.User;
import by.it.kozlov.jd03_03.dao.DAO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;


public class DAOTest {

    @Test
    public void userDAO() throws SQLException {
        DAO dao = DAO.getDAO();
        User user = dao.user.read(1);
        String test = "User{id=1, login='bayernkraft.by', email='bmw.service@bayernkraft.by', password='bayernkraft', cityID=7, address='ул. Панченко, 9', phoneNumber='+375447730077', rilesID=2}";
        Assert.assertEquals("Error read", test, user.toString());

        user.setPassword("12345678");
        dao.user.create(user);
        user = dao.user.read(user.getId());
        test = String.format("User{id=%d, login='bayernkraft.by', email='bmw.service@bayernkraft.by', password='12345678', cityID=7, address='ул. Панченко, 9', phoneNumber='+375447730077', rilesID=2}", user.getId());
        Assert.assertEquals("Error create", test, user.toString());

        user.setPassword("qwerty");
        dao.user.update(user);
        user = dao.user.read(user.getId());
        test = String.format("User{id=%d, login='bayernkraft.by', email='bmw.service@bayernkraft.by', password='qwerty', cityID=7, address='ул. Панченко, 9', phoneNumber='+375447730077', rilesID=2}", user.getId());
        Assert.assertEquals("Error update", test, user.toString());
        int id = user.getId();
        dao.user.delete(user);
        user = dao.user.read(id);
        Assert.assertNull("Error delete", user);
        Assert.assertNotNull("Error getAll", dao.user.getAll().get(0));
    }

    @Test
    public void roleDAO() throws SQLException {
        DAO dao = DAO.getDAO();
        Role role = dao.role.read(1);
        String test = "Role{id=1, role='admin'}";
        Assert.assertEquals("Error read", test, role.toString());

        Assert.assertFalse("Error create", dao.role.create(role));
        Assert.assertFalse("Error update", dao.role.update(role));
        Assert.assertFalse("Error delete", dao.role.delete(role));
        Assert.assertNotNull("Error getAll", dao.role.getAll().get(0));
    }

}