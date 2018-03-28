package me.asherli.test.dao;



import me.asherli.test.model.User;

import java.util.List;

public interface UserDao {
    public void insertBean(User user);

    public void deleteBean(User user);

    public void updateBean(User user);

    public List<User> selectBean(User user);

    public int selectBeanCount(User user);
}
