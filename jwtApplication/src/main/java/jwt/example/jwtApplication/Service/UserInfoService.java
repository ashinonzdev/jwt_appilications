package jwt.example.jwtApplication.Service;

import jwt.example.jwtApplication.Entity.UserInfo;
import jwt.example.jwtApplication.Repository.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepo userInfoRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepo.save(userInfo);
        return "User added to the system";
    }

}

