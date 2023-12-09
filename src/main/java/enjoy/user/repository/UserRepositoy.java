package enjoy.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import enjoy.user.entity.User;

public interface UserRepositoy extends JpaRepository<User, String>{

}
