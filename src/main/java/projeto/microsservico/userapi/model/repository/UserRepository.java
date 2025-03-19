package projeto.microsservico.userapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.microsservico.userapi.model.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByCPF(String cpf);

    List<UserEntity> queryByNomeLike(String name);
}
