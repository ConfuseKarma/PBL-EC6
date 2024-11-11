package br.edu.fesa.TotalMedia.service;

import br.edu.fesa.TotalMedia.model.User;
import br.edu.fesa.TotalMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Salvar ou atualizar um usuário
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Recuperar todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Recuperar um usuário pelo ID
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    // Recuperar um usuário pelo email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Deletar um usuário pelo ID
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    // Atualizar o status de ativação de um usuário
    public User toggleUserActiveStatus(UUID id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setActive(!user.isActive());
            return userRepository.save(user);
        }
        return null;
    }
}
