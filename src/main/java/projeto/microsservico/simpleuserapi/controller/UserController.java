package projeto.microsservico.simpleuserapi.controller;

import org.springframework.web.bind.annotation.*;
import projeto.microsservico.simpleuserapi.dto.UserDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    public void initiateList() {
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setNome("Gabriel");
        userDTO1.setCpf("123");
        userDTO1.setEmail("cunhazada@gmail.com");
        userDTO1.setEndereco("José Mesquita");
        userDTO1.setTelefone("8888888");
        userDTO1.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Laura");
        userDTO2.setCpf("321");
        userDTO2.setEmail("laurex@gmail.com");
        userDTO2.setEndereco("Selton moura");
        userDTO2.setTelefone("222222222");
        userDTO2.setDataCadastro(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Caio");
        userDTO3.setCpf("213");
        userDTO3.setEmail("caium@gmail.com");
        userDTO3.setEndereco("Louro José");
        userDTO3.setTelefone("1111111111");
        userDTO3.setDataCadastro(new Date());

        usuarios.add(userDTO1);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);

    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf) {
        for(UserDTO userFilter:usuarios) {
            if (userFilter.getCpf().equals(cpf)) {
                return userFilter;
            }
        }
        return null;
    }

    @PostMapping("/newUser")
    UserDTO inserir (@RequestBody UserDTO userDTO) {
        userDTO.setDataCadastro(new Date());
        usuarios.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/removeUser/{cpf}")
    public boolean remover(@PathVariable String cpf) {
        for (UserDTO userFilter : usuarios) {
            if (userFilter.getCpf().equals(cpf)) {
                usuarios.remove(userFilter);
                return true;
            }
        }
        return false;
    }

}
