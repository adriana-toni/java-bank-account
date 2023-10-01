package pinetree.javabankaccount.service;

import pinetree.javabankaccount.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User create(User userToCreate);
    User findById(UUID id);

    List<User> findAll();

    User update(UUID id, User userToUpdate);

    void deleteById(UUID id);
}
