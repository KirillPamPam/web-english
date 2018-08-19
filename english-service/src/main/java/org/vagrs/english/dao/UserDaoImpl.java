package org.vagrs.english.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vagrs.english.model.db.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Kirill Zhitelev on 13.05.2018.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Override
    public User getUserByName(String name) {
        final Session session = sessionFactory.getCurrentSession();
        final CriteriaBuilder builder = session.getCriteriaBuilder();
        final CriteriaQuery<User> query = builder.createQuery(User.class);
        final Root<User> rootUser = query.from(User.class);
        query.select(rootUser).where(builder.equal(rootUser.get("userName"), name));

        return session.createQuery(query).getSingleResult();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
