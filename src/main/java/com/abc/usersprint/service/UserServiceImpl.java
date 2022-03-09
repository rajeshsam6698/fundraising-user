package com.abc.usersprint.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.usersprint.entity.UserEntity;
import com.abc.usersprint.exception.UserNotFoundException;
import com.abc.usersprint.model.Category;
import com.abc.usersprint.model.Details;
import com.abc.usersprint.model.User;
import com.abc.usersprint.repository.UserRepository;
import com.abc.usersprint.util.EntityModelUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private EntityModelUtil entityModelUtil;
	
	@Override
	public User addUser(User user) {
		UserEntity userEntity = userRepository.save(entityModelUtil.userModelToEntity(user));
		return entityModelUtil.userEntityToModel(userEntity);
	}

	@Override
	public Details getUserById(int userId) throws UserNotFoundException {
		Optional<UserEntity> optionalUser = userRepository.findById(userId);

		Details details = new Details();

		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("Sorry ! User is not available with id :" + userId);

		}

		UserEntity userEntity = optionalUser.get();
		details.setUser(entityModelUtil.userEntityToModel(userEntity));
		Category category = categoryService.getCategoryDetails(userEntity.getCategoryName());
		details.setCategory(category);

		return details;
	}

	@Override
	public void deleteUser(int userId) {
		Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);

		if (optionalUserEntity.isPresent()) {
		 
			userRepository.deleteById(userId);
			System.out.println("Deleted the user with Id" +userId);
		}
		else {

		throw new UserNotFoundException("Sorry! User is not existing with id: " + userId);
	}
	}		

	@Override
	public User updateUser(User user) {
		Optional<UserEntity> optionalUserEntity = userRepository.findById(user.getUserId());

		if (optionalUserEntity.isEmpty()) {
			throw new UserNotFoundException("Sorry! User is not existing with id: " + user.getUserId());
		}

		UserEntity updatedUserEntity = userRepository.save(entityModelUtil.userModelToEntity(user));
		System.out.println("Updated the user details");

		return entityModelUtil.userEntityToModel(updatedUserEntity);
	}

	@Override
	public User getUserByIdproof(String idProof) throws UserNotFoundException {
	Optional<UserEntity> optionalUser = userRepository.findByUserIdProof(idProof);
	if (optionalUser.isEmpty()) {
	throw new UserNotFoundException("Sorry ! User is not available with id proof :" + idProof);



	}
	UserEntity userEntity = optionalUser.get();
	return entityModelUtil.userEntityToModel(userEntity);
	}

	
	public Category getCategoryDetails(String categoryName) {
		
		Category category = categoryService.getCategoryDetails(categoryName);
		return category;	
		
	}

	@Override
	public User getUserDetails(int userId) throws UserNotFoundException{
		
		Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
		if(optionalUserEntity.isEmpty()) {
			throw new UserNotFoundException("Sorry User is not found with id" +userId);
		}
		return entityModelUtil.userEntityToModel(optionalUserEntity.get());
	}

	

}
