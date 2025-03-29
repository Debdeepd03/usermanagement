package edu.userdemo;

import edu.userdemo.entity.User;
import edu.userdemo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<User>lu= List.of(
				User.builder().name("debdeep").email("deb@gmail.com").build(),
				User.builder().name("oindrila").email("o@gmail.com").build(),
				User.builder().name("devlina").email("devlina@gmail.com").build(),
				User.builder().name("arpan").email("arpan@gmail.com").build()
		);
		lu.forEach(user-> System.out.println(user.getName()+":"+user.getEmail()+" "+user.getId()));
		userRepository.saveAll(lu);

		System.out.println("all saved------------------");
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
