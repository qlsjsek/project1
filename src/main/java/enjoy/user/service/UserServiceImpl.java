package enjoy.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import enjoy.user.dto.UserDto;
import enjoy.user.entity.User;
import enjoy.user.repository.UserRepositoy;

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepositoy userRepositoy;
	
	@Override
	public UserDto createUser(UserDto userDto) throws Exception {
		UserDto user = new UserDto();
		user.setUserId(null);
		
		
		return null;
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDto updateUser(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto loginUser(String userId, String userPW) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
