package com.abc.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.usersprint.entity.UserEntity;
import com.abc.usersprint.exception.UserNotFoundException;
import com.abc.usersprint.model.User;
import com.abc.usersprint.repository.UserRepository;
import com.abc.usersprint.service.UserService;
import com.abc.usersprint.service.UserServiceImpl;
import com.abc.usersprint.util.EntityModelUtil;

@SpringBootTest(classes = UserServiceTest.class)
public class UserServiceTest {
	@InjectMocks
	private UserService userService = new UserServiceImpl();

	@Mock
	private UserRepository userRepository;

	@Mock
	private EntityModelUtil entityModelUtil;

	@Test
	public void testGetUserByIdNotFound() {

		int userId = 1;

		when(userRepository.findById(userId)).thenThrow(UserNotFoundException.class);

		assertThrows(UserNotFoundException.class, () -> userService.getUserById(userId));
	}

	@Test
	void testDeleteUser() {

		int userId = 1;
		UserEntity user = new UserEntity();

		user.setCategoryName("medical");
		user.setUserAccountNumber(34567);
		user.setUserAddress("hyderabad");
		user.setUserDescription("cancer");
		user.setUserEmail("rajesh@gmail.com");
		user.setUserFullName("rajeshs");
		user.setUserFundAmount(35000);
		user.setUserId(1);
		user.setUserIdProof("34567");
		user.setUserMobile("9876543211");
		user.setUserName("rajesh");

		Optional<UserEntity> optional = Optional.of(user);
		when(userRepository.findById(1)).thenReturn(optional);
		userService.deleteUser(user.getUserId());
		verify(userRepository, times(1)).deleteById(userId);
	}

	@Test
	public void testSaveUser() {

		UserEntity user = new UserEntity();

		user.setCategoryName("medical");
		user.setUserAccountNumber(34567);
		user.setUserAddress("hyderabad");
		user.setUserDescription("cancer");
		user.setUserEmail("rajesh@gmail.com");
		user.setUserFullName("rajeshs");
		user.setUserFundAmount(35000);
		user.setUserId(1);
		user.setUserIdProof("34567");
		user.setUserMobile("9876543211");
		user.setUserName("rajesh");

		User user1 = new User();
		user1.setCategoryName("medical");
		user1.setUserAccountNumber(34567);
		user1.setUserAddress("hyderabad");
		user1.setUserDescription("cancer");
		user1.setUserEmail("rajesh@gmail.com");
		user1.setUserFullName("rajeshs");
		user1.setUserFundAmount(35000);
		user1.setUserId(1);
		user1.setUserIdProof("34567");
		user1.setUserMobile("9876543211");
		user1.setUserName("rajesh");

		when(entityModelUtil.userModelToEntity(user1)).thenReturn(user);
		when(entityModelUtil.userEntityToModel(user)).thenReturn(user1);
		when(userRepository.save(user)).thenReturn(user);

		assertEquals(user1.getUserFullName(), user.getUserFullName());

	}

	@Test
	public void testGetUserDetails() {

		UserEntity user = new UserEntity();

		user.setCategoryName("medical");
		user.setUserAccountNumber(34567);
		user.setUserAddress("hyderabad");
		user.setUserDescription("cancer");
		user.setUserEmail("rajesh@gmail.com");
		user.setUserFullName("rajeshs");
		user.setUserFundAmount(35000);
		user.setUserId(1);
		user.setUserIdProof("34567");
		user.setUserMobile("9876543211");
		user.setUserName("rajesh");

		User user1 = new User();
		user1.setCategoryName("medical");
		user1.setUserAccountNumber(34567);
		user1.setUserAddress("hyderabad");
		user1.setUserDescription("cancer");
		user1.setUserEmail("rajesh@gmail.com");
		user1.setUserFullName("rajeshs");
		user1.setUserFundAmount(35000);
		user1.setUserId(1);
		user1.setUserIdProof("34567");
		user1.setUserMobile("9876543211");
		user1.setUserName("rajesh");

		when(entityModelUtil.userModelToEntity(user1)).thenReturn(user);
		when(entityModelUtil.userEntityToModel(user)).thenReturn(user1);

		Optional<UserEntity> optionalUser = Optional.of(user);
		int userId = 1;

		when(entityModelUtil.userModelToEntity(user1)).thenReturn(user);
		when(entityModelUtil.userEntityToModel(user)).thenReturn(user1);

		when(userRepository.findById(1)).thenReturn(optionalUser);

		User existingUser = userService.getUserDetails(userId);

		assertEquals(user.getUserName(), existingUser.getUserName());

	}

}