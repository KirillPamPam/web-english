package org.vagrs.english.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vagrs.english.common.Constants;
import org.vagrs.english.dao.UserDao;
import org.vagrs.english.model.db.User;

import javax.persistence.NoResultException;
import java.util.Collections;

/**
 * Created by Kirill Zhitelev on 13.05.2018.
 */
@Service
public class UserServiceImpl implements UserDetailsService {
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            final User user = userDao.getUserByName(username);

            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                    Collections.emptyList());
        } catch (NoResultException e) {
            throw new BadCredentialsException(Constants.BAD_CRED, e);
        }
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
