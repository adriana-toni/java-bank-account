package pinetree.javabankaccount.service;

import pinetree.javabankaccount.domain.model.User;

import java.util.UUID;

public interface UserService {

    User findById(UUID id);

    User create(User userToCreate);

}
