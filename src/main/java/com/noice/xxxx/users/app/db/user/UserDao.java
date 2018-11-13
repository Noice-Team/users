package com.noice.xxxx.users.app.db.user;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.noice.xxxx.users.app.execeptions.DatabaseException;
import com.noice.xxxx.users.app.execeptions.UserNotFoundException;
import com.noice.xxxx.users.app.resources.users.v1.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDao {
	private static final String USER_COLLECTION =  "Users";
	
	@Autowired
	Firestore db;
	
	public List<UserDto> getUsers() throws DatabaseException{
		ApiFuture<QuerySnapshot> future = db.collection(USER_COLLECTION).get();
		List<QueryDocumentSnapshot> documents;
		try {
			documents = future.get().getDocuments();
		} catch (InterruptedException | ExecutionException e) {
			log.error("Error load", e);
			throw new DatabaseException(e);
		}
		
		return documents.stream()
				.map(doc -> doc.toObject(UserDto.class)).collect(Collectors.toList());
	}
	
	
	public UserDto getUser(String id) throws UserNotFoundException, DatabaseException{
		DocumentReference docRef = db.collection(USER_COLLECTION).document(id);
		
		DocumentSnapshot snapshot;
		try {
			snapshot = docRef.get().get();
		} catch (InterruptedException | ExecutionException e) {
			log.error("Error load", e);
			throw new DatabaseException(e);
		}
		if(!snapshot.exists()) {
			throw new UserNotFoundException();
		}
		UserDto model = snapshot.toObject(UserDto.class);
		return model;
    }
}
