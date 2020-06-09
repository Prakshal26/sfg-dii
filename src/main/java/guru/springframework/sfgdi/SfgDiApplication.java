/*
Here we are not changing the previous code. Just in this main application file only we will
be able to run the program without the need of controllers. It is the additional functionality that
we get from the framework i.e spring framework. i.e how automatically dependency injection is performed
by the spring.
 */

package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		//Run method here run any application context. We are creating a
		//application context ctx
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		//MyController is a class and we are creating a bean using the mycontroller objext
		MyController myController = (MyController) ctx.getBean("myController");

		String greeting = myController.sayHello();

		System.out.println(greeting);
		/*
		HEre we will see automatic dependency injection
		 */

	}

}
