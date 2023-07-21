<h1>Spring Security OAuth 2.0 Resource Server</h1>

**Secure REST APIs in Spring Boot using JSON Web Tokens with OAuth 2.0 Resource Server**

## Introduction

**How to secure REST APIs in Spring Boot using JSON Web Tokens?**

We can write a custom filter chain and pulling in a 3rd party library for encoding and decoding JWTs.
But Spring Security has built-in support for JWTs using oAuth2 Resource Server.

## JWT
A JSON Web Token is an open method for representing claims securely between two parties. Contains 3 parts: 
Header, Payload and Signature.

The signature is created using by encrypting the header + payload and a secret (or private key).

## OAuth 2.0 Resource Server
Configure OAuth 2.0 Resource Server by setting `.oauth2ResourceServer()`.

```
http.oauth2ResourceServer(oauth2 -> oauth2
.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()))
);
```

## Signing Json Web Tokens

A JWT can be encrypted using either a symmetric key (shared secret) or asymmetric keys 
(the private key of a private-public pair).
* Symmetric key: The same key is used for both encryption and decryption.
* Asymmetric keys: Different keys are used for encryption (private key) and decryption (public key). We will 
use Asymmetric keys.

## RSA Public & Private keys
We can generate public and private key pair via code or create them manually.

<a href="https://connect2id.com/products/nimbus-jose-jwt/examples/jwk-generation">
    How to create RSA key pair with Nimbus Jose Jwt
</a>

## JWTDecoder
Create a `JwtDecoder` using the public key. One of the dependencies that the resource server brings in for us 
is `spring-security-oauth2-jose` which contains a library called `Nimbus Jose JWT`. We can use and return a
`Nimbus JWT Decoder`.

```
    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(keys.getPublicKey()).build();
    }
```

## JWTEncoder
The encoder will be used to encode the signature into a token and sign it using our private key.
```
    @Bean
    public JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(keys.getPublicKey()).privateKey(keys.getPrivateKey()).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    };
```

Reference sources: Dan Vega
