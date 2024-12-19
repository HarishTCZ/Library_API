package com.harishtcx.Library.Service;

import com.harishtcx.Library.Entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User saveUser();
}
