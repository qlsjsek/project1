package enjoy.user.service;

import enjoy.user.dto.UserDto;

public interface UserService {

	public UserDto createUser(UserDto userDto) throws Exception;
	
	public void deleteUser(String userId) throws Exception;
	
	public UserDto updateUser(UserDto userDto) throws Exception;
	
	public UserDto loginUser(String userId,String userPw) throws Exception;
	
	
}
