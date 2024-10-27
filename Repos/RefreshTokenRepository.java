package Repos;

import Entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    RefreshToken findByToken(int  userId);

    RefreshToken findByUserid(int userId);
}
