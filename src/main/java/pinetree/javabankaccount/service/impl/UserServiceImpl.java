package pinetree.javabankaccount.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pinetree.javabankaccount.domain.model.User;
import pinetree.javabankaccount.domain.repository.UserRepository;
import pinetree.javabankaccount.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This User ID already exists.");
        }
        if (userToCreate.getAccount() != null && userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        if (userToCreate.getAccount() != null && userRepository.existsByCardNumber(userToCreate.getCard().getNumber())) {
            throw new IllegalArgumentException("This Card number already exists.");
        }

        return userRepository.save(userToCreate);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
