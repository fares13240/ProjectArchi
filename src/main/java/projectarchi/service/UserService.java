package projectarchi.service;

import org.springframework.stereotype.Service;
import projectarchi.dto.UserDTO;
import projectarchi.model.User;
import projectarchi.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Filtrer uniquement les étudiants
    public List<User> getAllStudents() {
        return userRepository.findAll().stream()
                .filter(user -> "student".equalsIgnoreCase(user.getRole()))
                .collect(Collectors.toList());
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO convertToDTO(User user) {
        List<String> courseTitles = user.getCourses().stream()
                .map(course -> course.getTitle())
                .collect(Collectors.toList());
        return new UserDTO(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                null,  // creationDate si disponible
                user.getRole(),
                courseTitles
        );
    }

    public List<UserDTO> getAllUserDTOs() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
