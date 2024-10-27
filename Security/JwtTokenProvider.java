package Security;


import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {

    JwtUserDetails jwt;
    @Value("${app.jwtSecret}")
    private String APP_SECRET;

    @Value("${app.jwtExpirationInMs}")
    private long EXPIRES_IN;

//    public String generateJwtToken(@NotNull Authentication auth) {
//        JwtUserDetails userDetails = (JwtUserDetails) auth.getPrincipal();
//        Date expireDate = new Date(System.currentTimeMillis() + EXPIRES_IN);
//        return jwts.builder().setSubject(Long.toString(userDetails.getId()))
//                .setIssuedAt(new Date()).setExpiration(expireDate)
//                .signWith(SignatureAlgorithm.HS512, APP_SECRET).compact();
//    }
//
//    public String generateJwtTokenByUserId(Long userId) {
//        Date expireDate = new Date(System.currentTimeMillis() + EXPIRES_IN);
//        return Jwts.builder()
//                .setSubject(Long.toString(userId))
//                .setIssuedAt(new Date())
//                .setExpiration(expireDate)
//                .signWith(SignatureAlgorithm.HS512, APP_SECRET)
//                .compact();
//    }
//
//    public Long getUserIdFromJwt(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(APP_SECRET)
//                .parseClaimsJws(token)
//                .getBody();
//        return Long.parseLong(claims.getSubject());
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            // Log exception details if necessary
//            return false;
//        }
    }
//}
