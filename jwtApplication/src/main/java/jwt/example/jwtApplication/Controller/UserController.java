package jwt.example.jwtApplication.Controller;

import jwt.example.jwtApplication.Entity.UserInfo;
import jwt.example.jwtApplication.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/new")
    public ResponseEntity<Map<String, String>> addUser(@RequestBody UserInfo userInfo) {
        String message = userInfoService.addUser(userInfo);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

}
