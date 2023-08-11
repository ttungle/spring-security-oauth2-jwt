package site.thanhtungle.springsecurityoauth2rs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import site.thanhtungle.springsecurityoauth2rs.model.entity.ApplicationUser;
import site.thanhtungle.springsecurityoauth2rs.model.entity.Role;
import site.thanhtungle.springsecurityoauth2rs.repository.RoleRepository;
import site.thanhtungle.springsecurityoauth2rs.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityOauth2RsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauth2RsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			RoleRepository roleRepository,
			UserRepository userRepository,
			PasswordEncoder passwordEncoder
	) {
		return args -> {
			if (roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			Role userRole = roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			roles.add(userRole);

			ApplicationUser admin = new ApplicationUser(
					1,
					"admin",
					passwordEncoder.encode("admin"),
					roles
			);

			userRepository.save(admin);
		};
	}

}
