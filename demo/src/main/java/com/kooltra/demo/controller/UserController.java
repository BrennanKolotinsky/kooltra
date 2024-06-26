package com.kooltra.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kooltra.demo.dal.UserRepository;
import com.kooltra.demo.model.User;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
		public List<User> getAllUsers() {
        // public void getAllUsers() {
			LOG.info("Getting all users.");
            // System.out.println("Getting all users.");
			return userRepository.findAll();
		}

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
        public User getUser(@PathVariable String userId) {
            LOG.info("Getting user with ID: {}.", userId);
            return userRepository.findById(userId).get();
        }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
        public User addNewUsers(@RequestBody User user) {
            LOG.info("Saving user.");
            return userRepository.save(user);
        }

    @RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
        public Object getAllUserSettings(@PathVariable String userId) {
            User user = userRepository.findById(userId).get();
            if (user != null) {
                return user.getUserSettings();
            } else {
                return "User not found.";
            }
        }

    @RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
        public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
            User user = userRepository.findById(userId).get();
            if (user != null) {
                return user.getUserSettings().get(key);
            } else {
                return "User not found.";
            }
        }

    @RequestMapping(value = "/settings/{userId}/{key}/{value}", method = RequestMethod.GET)
        public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
            User user = userRepository.findById(userId).get();
            if (user != null) {
                user.getUserSettings().put(key, value);
                userRepository.save(user);
                return "Key added";
            } else {
                return "User not found.";
            }
        }
}

