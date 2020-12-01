package homework4.services;

import homework4.entity.User;

import java.util.List;

public interface UserService {
    User get(Long id);
    List<User> getAll();
    void save(User user);
    void remove(User user);
}
