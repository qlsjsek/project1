package enjoy.user.service;


import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import enjoy.EnjoyApplicationTest;
import enjoy.user.dto.UserDto;
import enjoy.user.entity.User;
import enjoy.user.repository.UserRepositoy;
import jakarta.transaction.Transactional;

public class UserServiceImplTest extends EnjoyApplicationTest {
	@Autowired
	UserService userService;
	@Autowired
	UserRepositoy userRepositoy;

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void createUser() throws Exception {
		UserDto userDto = new UserDto();
		userDto.setUserId("test1");
		userDto.setUserPw("1234");
		userDto.setUserAddress("서울시 관악구");
		userDto.setUserEmail("test1@naver.com");
		userDto.setUserIdentityNo("111111");
		userDto.setUserName("테스트1");
		userDto.setUserPhone("010-1111-1111");
		UserDto userDto2 = new UserDto();
		userDto2.setUserId("test2");
		userDto2.setUserPw("1234");
		userDto2.setUserAddress("서울시 관악구");
		userDto2.setUserEmail("test2@naver.com");
		userDto2.setUserIdentityNo("211111");
		userDto2.setUserName("테스트2");
		userDto2.setUserPhone("010-2111-1111");
		userService.createUser(userDto);
		userService.createUser(userDto2);
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void deleteUser() throws Exception {
		Optional<User> findUser = userRepositoy.findById("test3");
		if (findUser.isPresent()) {
			userService.deleteUser(findUser.get().getUserId());
		} else {
			System.out.println("id를 찾을 수 없습니다.");
		}
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void updateUser() throws Exception {
		UserDto userDto = new UserDto();
		userDto.setUserId("test1");
		userDto.setUserPhone("010-1111-1111");
		userDto.setUserPw("3333");
		userService.updateUser(userDto);
	}
	
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void login() throws Exception {
		String userId = "test1";
		String userPw = "3333";
		userService.loginUser(userId, userPw);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findUserIdByIdentityNoAndUserName() throws Exception {
		String userIdentityNo = "111111";
		String userName = "테스트1";
		userService.findUserIdByIdentityNoAndUserName(userIdentityNo,userName);
			
	}
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findUserPwByUserIdAndUserPhone() throws Exception {
		String userId = "test1";
		String userPhone = "010-1111-1111";
		userService.findUserPwByUserIdAndUserPhone(userId, userPhone);
		
	}
}
