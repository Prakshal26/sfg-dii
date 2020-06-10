/*
 Previously we were using Same Service for all the three controller(Property,setter and Constructor based.
 BUt here we have created the different service for each of the controller(COnstructorGreetingService,
 PropertyInjectedGrettingService and SetterInjectedGreeting.
 Now we need to give qualifier so that it knows which bean to wire with which service.
*/

package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructedInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class git SfgDiApplication {

	public static void main(String[] args) {

		//Run method here run any application context. We are creating a
		//application context ctx
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		//MyController is a class and we are creating a bean using the mycontroller objext
		MyController myController = (MyController) ctx.getBean("myController");

		String greeting = myController.sayHello();

		System.out.println(greeting);

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		//Do Same for setter based

		SetterInjectedController setterInjectedController= (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		ConstructedInjectedController constructedInjectedController= (ConstructedInjectedController) ctx.getBean("constructedInjectedController");
		System.out.println(constructedInjectedController.getGreeting());

	}

}
