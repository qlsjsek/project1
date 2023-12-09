package enjoy.user.entity;

import enjoy.user.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userAddress;
	private String userIdentityNo;
	private String userEmail;
	
	
	public static User toEntity(UserDto dto) {
		return User.builder()
					.userId(dto.getUserId())
					.userPw(dto.getUserPw())
					.userIdentityNo(dto.getUserIdentityNo())
					.userEmail(dto.getUserEmail())
					.userAddress(dto.getUserAddress())
					.userName(dto.getUserName())
					.userPhone(dto.getUserPhone())
					.build();
	}
}
