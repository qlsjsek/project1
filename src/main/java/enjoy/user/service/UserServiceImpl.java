package enjoy.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import enjoy.user.dto.UserDto;
import enjoy.user.entity.User;
import enjoy.user.repository.UserRepositoy;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepositoy userRepositoy;
	
	@Override
	public UserDto createUser(UserDto userDto) throws Exception {
		User user = User.builder()
						.userId(userDto.getUserId())
						.userPw(userDto.getUserPw())
						.userAddress(userDto.getUserAddress())
						.userEmail(userDto.getUserEmail())
						.userIdentityNo(userDto.getUserIdentityNo())
						.userName(userDto.getUserName())
						.userPhone(userDto.getUserPhone())
						.build();
		userRepositoy.save(user);
		UserDto createdUser = UserDto.toDto(user);
		return createdUser;
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		Optional<User> findUser = userRepositoy.findById(userId);
		if (findUser.isPresent()) {
			userRepositoy.delete(findUser.get());
		}else {
			throw new NotFoundException("회원을 찾을 수 없습니다."+userId);
		}
	}

	@Override
	public UserDto updateUser(UserDto userDto) throws Exception {
		Optional<User> findUser = userRepositoy.findById(userDto.getUserId());
		if (findUser.isPresent()) {
			User user = findUser.get();
			user.setUserPw(userDto.getUserPw());
			user.setUserEmail(userDto.getUserEmail());
			user.setUserPhone(userDto.getUserPhone());
			user.setUserAddress(userDto.getUserAddress());
			userRepositoy.save(user);
			return UserDto.toDto(user);
		}else {
			throw new NotFoundException("회원을 찾을 수 없습니다."+userDto.getUserId());
		}
	}

	@Override
	public UserDto loginUser(String userId, String userPw) throws Exception {
		Optional<User> findUser = userRepositoy.findById(userId);
		if (findUser.isPresent()) {
			User user = findUser.get();
			if (userPw.equals(user.getUserPw())) {
				System.out.println("로그인 성공");
				return UserDto.toDto(user);
			}else {
				throw new NotFoundException("비밀번호가 일치하지 않습니다.");
			}
		}else {
			throw new NotFoundException("회원을 찾을 수 없습니다."+userId);
		}
	}

	@Override
	public String findUserIdByIdentityNoAndUserName(String userIdentityNo, String userName) throws Exception {
		Optional<User> findUser = userRepositoy.findByUserIdentityNoAndUserName(userIdentityNo,userName);
		if (findUser.isPresent()) {
			User user = findUser.get();
			UserDto userDto = UserDto.toDto(user);
			String userId = userDto.getUserId();
			System.out.println("아이디: "+userId);
			return userId;
		}else {
			throw new NotFoundException("해당 주민번호에 일치하는 아이디가 없습니다");
		}
	}

	@Override
	public String findUserPwByUserIdAndUserPhone(String userId, String userPhone) throws Exception {
		Optional<User> findUser = userRepositoy.findByUserIdAndUserPhone(userId, userPhone);
		if (findUser.isPresent()) {
			User user = findUser.get();
			UserDto userDto = UserDto.toDto(user);
			String userPw = userDto.getUserPw();
			System.out.println("비밀번호: "+userPw);
			return userPw;
		}else {
			throw new NotFoundException("일치하는 정보가 없습니다");
		}
	}

}
