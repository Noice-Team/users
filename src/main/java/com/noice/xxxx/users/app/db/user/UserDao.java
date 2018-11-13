package com.noice.xxxx.users.app.db.user;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.noice.xxxx.users.app.execeptions.DatabaseException;
import com.noice.xxxx.users.app.execeptions.UserNotFoundException;
import com.noice.xxxx.users.app.resources.users.v1.dto.UserDto;

@Service
public class UserDao {
	private static final String USER_COLLECTION =  "Users";
	
	@Autowired
	Firestore db;
	
	public UserDto getUser(String id) throws UserNotFoundException, DatabaseException{
		DocumentReference docRef = db.collection(USER_COLLECTION). document (id);
		
		DocumentSnapshot snapshot;
		try {
			snapshot = docRef.get().get();
		} catch (InterruptedException | ExecutionException e) {
			throw new DatabaseException();
		}
		if(!snapshot.exists()) {
			throw new UserNotFoundException();
		}
		UserDto model = snapshot.toObject(UserDto.class);
		return model;
    }
}
