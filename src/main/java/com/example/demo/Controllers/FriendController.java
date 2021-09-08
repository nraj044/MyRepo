package com.example.demo.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Friend;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repo.FriendsRepo;

@RestController
@RequestMapping("/myapplication/friends")
public class FriendController {
	
	Logger logger=LoggerFactory.getLogger(FriendController.class);

	@Autowired
	private FriendsRepo friendRepository;

	// get all friends
	@GetMapping
	public List<Friend> getAllFriends() {
		logger.info("In Get Method");
		return this.friendRepository.findAll();
	}

	// get friend by id
	@GetMapping("/{id}")
	public Friend getFriendById(@PathVariable(value = "id") long id) {
		logger.info("In getById method");
		return this.friendRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Friend Not Found with id: " + id));
	}

	// create friend
	@PostMapping
	public Friend createFriend(@Valid @RequestBody Friend friend) {
		logger.info("In post Method");
		return this.friendRepository.save(friend);
	}

	// update friend
	@PutMapping("/{id}")
	public Friend updateFriend(@RequestBody Friend friend, @PathVariable("id") long id) {
		logger.info("In Put method");
		Friend oldFriend = this.friendRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Friend Not Found with id: " + id));
		oldFriend.setName(friend.getName());
		oldFriend.setEmail(friend.getEmail());
		oldFriend.setMobNumber(friend.getMobNumber());
		oldFriend.setAge(friend.getAge());
		oldFriend.setDob(friend.getDob());
		return this.friendRepository.save(oldFriend);
	}

	// delete friend by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Friend> deleteFriend(@PathVariable(value = "id") long id) {
		logger.info("In Delete method");
		Friend oldFriend = this.friendRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Friend Not Found with id: " + id));
		this.friendRepository.delete(oldFriend);
		return ResponseEntity.ok().build();
	}

}
