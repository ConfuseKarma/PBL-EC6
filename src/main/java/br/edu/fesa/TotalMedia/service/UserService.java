package br.edu.fesa.TotalMedia.service;

import br.edu.fesa.TotalMedia.model.User;
import br.edu.fesa.TotalMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;

    // Salvar ou atualizar um usuário
    public User saveUser(User user) {
        // Encriptar a senha antes de salvar
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }
    
    public User updateUser(User user) {
        // Verifica se a senha foi fornecida
        User existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        // Preserve a registrationDate original
        user.setRegistrationDate(existingUser.getRegistrationDate());
        
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            // Encripta a nova senha antes de salvar
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
        } else {
            // Caso a senha não tenha sido fornecida, mantém a senha atual
            user.setPassword(existingUser.getPassword()); // Mantém a senha antiga
        }

        // Atualiza os outros campos (nome, email, etc.)
        return userRepository.save(user);
    }

    // Recuperar todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Recuperar um usuário pelo ID
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    // Recuperar um usuário pelo email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Deletar um usuário pelo ID
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    // Atualizar o status de ativação de um usuário
    public User toggleUserActiveStatus(int id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setActive(!user.getActive());
            return userRepository.save(user);
        }
        return null;
    }
}
