package enjoy.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.webjars.NotFoundException;

import enjoy.user.dto.UserDto;
import enjoy.user.entity.User;
import enjoy.user.repository.UserRepositoy;

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
				return UserDto.toDto(user);
			}else {
				throw new NotFoundException("비밀번호가 일치하지 않습니다.");
			}
		}else {
			throw new NotFoundException("회원을 찾을 수 없습니다."+userId);
		}
	}

}
