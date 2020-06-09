/* If Framework does not do the dependency injection then how it will look like, we will see this in
this code.
There are 3 ways for Dependency Injection so to demonstrate each way we have made a controller namely
PropertyInjectedController: Using just a variable(Not used generally)
SetterInjectedController: It used set methods for injection
ConstructedInjectedController: It used Constructer.

We have created a greeting service( It can be any service i.e the real task we want to perform.)
Here our service is just Printing Hello World. In service folder we have created a Interface GettingService
And we implmented the Interface in GettingServiceImpl Class.
It is just prining hello world for us.

Check the PropertyInjectedController.
Controller variable is just to control our services.
We have created a object of GreetingService Interface and using it to run our service.
//To run the service open TEst folder where seprate controller to run each service.

SetterInjectedController:
We Have use set method to get the vlaue and then running in SetterInjectedControllerTest

ConstructedInjectedController
Used Paramitrized Constructor to get the value

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
	}

}
