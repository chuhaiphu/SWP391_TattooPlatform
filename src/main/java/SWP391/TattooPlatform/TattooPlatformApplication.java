package SWP391.TattooPlatform;

import SWP391.TattooPlatform.Repository.Studio_Tattoo_ManagerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TattooPlatformApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TattooPlatformApplication.class, args);
	}


}
