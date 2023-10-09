package SWP391.TattooPlatform;

import SWP391.TattooPlatform.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.naming.Context;

@SpringBootApplication
public class TattooPlatformApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(TattooPlatformApplication.class, args);

	}


}
