package Services;

import Entities.RefreshToken;
import Entities.User;
import Repos.RefreshTokenRepository;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class RefreshTokenServices {
    int expireSeconds;
    private RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenServices(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }
    public String createRefreshToken(User user){
        RefreshToken refreshToken = new RefreshToken();
        if (refreshToken==null){
            refreshToken = new RefreshToken();
            refreshToken.setUser(user);
        }
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(Date.from(Instant.now().plusSeconds(expireSeconds)));
        refreshTokenRepository.save(refreshToken);
        return refreshToken.getToken();
    }
    public boolean isRefreshTokenExpired(RefreshToken refreshToken){
        return refreshToken.getExpiryDate().before(new Date());
    }
    public RefreshToken getByUser(int userId){
        return refreshTokenRepository.findByUserid(userId);
}
}
