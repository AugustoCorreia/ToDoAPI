package correia.augusto.todorest.controllers;

import correia.augusto.todorest.models.UserModel;
import correia.augusto.todorest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
   @PostMapping(path = "/user")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user){
       try {
           UserModel _user = userRepository
                   .save(new UserModel(user.getEmail(), user.getPassword()));
           return new ResponseEntity<>(_user, HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @GetMapping(path ="/users")
    public ResponseEntity<List<UserModel>> getAllUsers (){
        try {
            List<UserModel> users = new ArrayList<UserModel>();
                userRepository.findAll().forEach(users::add);
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") Integer id) {
        Optional<UserModel> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//
//    @PutMapping("/users/{id}")
//    public ResponseEntity<UserModel> updateUser(@PathVariable("id") Integer id, @RequestBody UserModel user) {
//        Optional<UserModel> userData = userRepository.findById(id);
//
//        if (userData.isPresent()) {
//            UserModel _user = userData.get();
//            _user.setEmail(tutorial.getDescription());
//            _tutorial.setPublished(tutorial.isPublished());
//            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/tutorials/{id}")
//    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
//        try {
//            tutorialRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/tutorials")
//    public ResponseEntity<HttpStatus> deleteAllTutorials() {
//        try {
//            tutorialRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
//
//    @GetMapping("/tutorials/published")
//    public ResponseEntity<List<Tutorial>> findByPublished() {
//        try {
//            List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
//
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//


}

