package com.xbhog.annotationscaffold;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @author xbhog
 */
@Slf4j
@SpringBootApplication
@RestController
public class AnnotationScaffoldApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnotationScaffoldApplication.class, args);
    }

    /**
     * get url：{{local}}/hello
     */
    @GetMapping(value = "/hello")
    public  ResponseEntity<String> hello(){
        return new ResponseEntity<>("hello world!", HttpStatus.OK);
    }

    /**
     *get url:{{local}}/user/22
     * @param userId
     * @return
     */
    @RequestMapping(value="/user/{userId}",method = RequestMethod.GET)
    public ResponseEntity<String> getLogin(@PathVariable("userId") String userId){
        System.out.println("User Id : " + userId);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    /**
     * get {{local}}/user?username=xbhog&pass=111111
     * @param username
     * @return
     */
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public ResponseEntity<String> getLogin2(@RequestParam("username") String username,
                                            @RequestParam("pass") String pass){
        System.out.println("User name : " + username);
        System.out.println("User pass : " + pass);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    /**
     * get {{local}}/userMap?name=xbhog&pass=111111
     * @param user
     * @return
     */
    @RequestMapping(value="/userMap",method = RequestMethod.GET)
    public ResponseEntity<String> getLogin3(@RequestParam Map<String,String> user){
        System.out.println("User name : " + user.get("name"));
        System.out.println("User pass : " + user.get("pass"));
        return new ResponseEntity<>(JSON.toJSONString(user), HttpStatus.OK);
    }

    /**
     *post {{local}}/user?username=xbhog
     * @param username
     */
    @RequestMapping(value="/user",method = RequestMethod.POST)
    public ResponseEntity<String> getLogin4(@RequestBody String username){
        System.out.println("User name : " + username);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    /**
     *post :{{local}}/userMap
     * {
     *     "name":"xbhog",
     *     "pass":"111111"
     * }
     * @param user
     * @return
     */
    @RequestMapping(value="/userMap",method = RequestMethod.POST)
    public ResponseEntity<String> getLogin5(@RequestBody Map<String,String> user){
        System.out.println("User name : " + user.get("name"));
        System.out.println("User pass : " + user.get("pass"));
        return new ResponseEntity<>(JSON.toJSONString(user), HttpStatus.OK);
    }

    /**
     *post {{local}}/userPojo
     * {
     *     "name":"xbhog",
     *     "pass":"111111"
     * }
     * @param user
     * @return
     */
    @RequestMapping(value="/userPojo",method = RequestMethod.POST)
    public ResponseEntity<String> getLogin6(@RequestBody User user){
        System.out.println("User name : " + user.getName());
        System.out.println("User pass : " + user.getPass());
        return new ResponseEntity<>(JSON.toJSONString(user), HttpStatus.OK);
    }

    /**
     * get {{local}}/userPojo?name=xbhog&pass=111111
     * @param user
     * @return
     */
    @RequestMapping(value="/userPojo",method = RequestMethod.GET)
    public ResponseEntity<String> getLogin7(User user){
        System.out.println("User name : " + user.getName());
        System.out.println("User pass : " + user.getPass());
        return new ResponseEntity<>(JSON.toJSONString(user), HttpStatus.OK);
    }

    static class User{
        private String name;
        private String pass;

        public User() {
        }

        public User(String name, String pass) {
            this.name = name;
            this.pass = pass;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", pass='" + pass + '\'' +
                    '}';
        }
    }

}
