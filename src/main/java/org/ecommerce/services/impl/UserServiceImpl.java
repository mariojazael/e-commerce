package org.ecommerce.services.impl;

import org.ecommerce.enums.Error;
import org.ecommerce.models.Customer;
import org.ecommerce.models.User;
import org.ecommerce.repositories.UserRepository;
import org.ecommerce.services.PasswordService;
import org.ecommerce.services.UserService;
import org.ecommerce.util.validators.impl.Validators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserServiceImpl implements UserService<User> {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public UserServiceImpl(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    public Map<String, String> generateCustomer(Customer customer) {
        Map<String, String> result = new HashMap<>();
        if (!Validators.isValidEmail(customer.getEmail()))
            result.put("error", Error.INVALID_EMAIL.getDescription());
        if (!Validators.isValidPassword(customer.getPassword()))
            result.put("error", Error.PASSWORD_FORMAT.getDescription());
        if (result.isEmpty())
            result.put("generatedCustomer", String.valueOf(save(customer)));
        return result;
    }

    @Override
    public User save(User entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<User> findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Long id, User entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
