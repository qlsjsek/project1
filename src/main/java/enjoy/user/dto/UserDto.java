package enjoy.user.dto;

import enjoy.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userAddress;
	private String userIdentityNo;
	private String userEmail;
	
	public static UserDto toDto(User entity) {
		return UserDto.builder()
						.userId(entity.getUserId())
						.userPw(entity.getUserPw())
						.userAddress(entity.getUserAddress())
						.userEmail(entity.getUserEmail())
						.userIdentityNo(entity.getUserIdentityNo())
						.userName(entity.getUserName())
						.userPhone(entity.getUserPhone())
						.build();
	}
	
	
}
