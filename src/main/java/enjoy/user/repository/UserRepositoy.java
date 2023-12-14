package enjoy.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import enjoy.user.entity.User;

public interface UserRepositoy extends JpaRepository<User, String>{
	Optional<User> findByUserIdentityNoAndUserName(String userIdentityNo, String userName); 
	Optional<User> findByUserIdAndUserPhone(String userId, String userPhone); 
}
