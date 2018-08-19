package org.vagrs.english.dao;

import org.vagrs.english.model.db.User;

/**
 * Created by Kirill Zhitelev on 13.05.2018.
 */
public interface UserDao {
    User getUserByName(String name);
}
