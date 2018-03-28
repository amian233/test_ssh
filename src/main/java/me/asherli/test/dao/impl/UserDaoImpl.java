package me.asherli.test.dao.impl;

import me.asherli.test.dao.UserDao;
import me.asherli.test.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Autowired
    public void setSessionFactory0(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void insertBean(User user) {
        this.getHibernateTemplate().save(user);
    }

    public void deleteBean(User user) {
        this.getHibernateTemplate().delete(user);
    }

    public void updateBean(User user) {
        this.getHibernateTemplate().update(user);
    }

    public List<User> selectBean(User user) {
        return this.getHibernateTemplate().findByExample(user);
    }


    public int selectBeanCount(User user) {
        long count = this.getHibernateTemplate().findByExample(user).size();
        return (int) count;
    }


}