package ee.sdacademy.service;

import ee.sdacademy.models.Users;
import ee.sdacademy.repository.UsersRepository;

import java.security.MessageDigest;
import java.util.List;

public class UserService {
    private final UsersRepository userRepository;

    public UserService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(Users user) {
        user.setPassword(encrypt(user.getPassword()));
        userRepository.createUser(user);
    }

    public List<Users> getAll() {
        return userRepository.getAllUsers();
    }

    public void deleteUser(Users users) {
        userRepository.deleteUser(users);
    }

    public Users findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public Users updateUser(Users users) {
        return userRepository.updateUser(users);
    }

    public static String encrypt(String str) {
        try {
            var md = MessageDigest.getInstance("SHA-512");
            var data = md.digest(str.getBytes());
            var sb = new StringBuilder();
            for (byte datum : data) {
                sb.append(Integer.toString((datum & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Encryption failed");
        }
    }
}
