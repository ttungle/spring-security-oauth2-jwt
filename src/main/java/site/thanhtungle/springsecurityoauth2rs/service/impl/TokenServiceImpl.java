package site.thanhtungle.springsecurityoauth2rs.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import site.thanhtungle.springsecurityoauth2rs.service.TokenService;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

    private JwtEncoder jwtEncoder;

    private JwtDecoder jwtDecoder;

    public String generateJwt(Authentication authentication) {

        Instant now = Instant.now();

        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .subject(authentication.getName())
                .claim("roles", scope)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
