package jwt.example.jwtApplication.Repository;

import jwt.example.jwtApplication.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Long> {
    Optional<UserInfo> findByName( String username);

}
