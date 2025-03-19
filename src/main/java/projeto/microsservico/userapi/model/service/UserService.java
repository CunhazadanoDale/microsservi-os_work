package projeto.microsservico.userapi.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.microsservico.simpleuserapi.dto.UserDTO;
import projeto.microsservico.userapi.model.entity.UserEntity;
import projeto.microsservico.userapi.model.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<UserEntity> usuarios = userRepository.findAll();
        return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());
    }

    public UserDTO findById(Long userId) {
        Optional<UserEntity> usuario = userRepository.findById(userId);
        if (usuario.isPresent()) {
            return UserDTO.convert(usuario.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO) {
        UserEntity user = userRepository.save(UserEntity.convert(userDTO));
        return UserDTO.convert(user);
    }

    public UserDTO delete(long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }

    public UserDTO findByCpf(String cpf) {
        UserEntity user = userRepository.findByCPF(cpf);
        if (user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name) {
        List<UserEntity> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }


}
