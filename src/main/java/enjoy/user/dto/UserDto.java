package enjoy.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userAddress;
	private String userIdentityNo;
	private String userEmail;
	
	
	
}
