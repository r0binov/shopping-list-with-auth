package ee.sdacademy.service;

import ee.sdacademy.models.Users;

import java.security.MessageDigest;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users save(Users user) {
        user.setPassword(encrypt(user.getPassword()));
        Users savedUser = userRepository.save(user);
        savedUser.setPassword(null);
        return savedUser;
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
