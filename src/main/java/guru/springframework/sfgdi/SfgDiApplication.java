/*
Here we are not changing the previous code. Just in this main application file only we will
be able to run the program without the need of Test Files. It is the additional functionality that
we get from the framework i.e spring framework. i.e how automatically dependency injection is performed
by the spring.
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
		In PropertyInjectedControler we have specified it to be as Controller
		We need to explicitly say that that particular class is a controller.
		 */
		//In Greeting Service Class we have mentioned Greeting service to be a service.
		// Now whenever we are using Greeting Service Class object we are giving it as Autowired i.e
		//explicitly saying this is a service.
		// This will be checked By autowired that we have given it as as Service.
		/*
		Autowired: It seels the object it is looking is a service
		Service : It is used to make that class as Service class.
		What does it mean that i am service class: For service class we need not object. NEither we
		dont need to create object of controllers like we were doing in test.
		Automatically object is created
		 */

		/*
		Only These two lines of code is needed for Automatic Dependency Injection. No need of test
		class. Everything handled by framework, We have just given Cntroller,Service and Autowired.
		The Major difference is that in manual dependency injection we were creating a test class
		and there we were creating a object using new keyword.Here no need of test class and creating
		object as it will be done by spring.
		 */
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		//Do Same for setter based

		SetterInjectedController setterInjectedController= (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		ConstructedInjectedController constructedInjectedController= (ConstructedInjectedController) ctx.getBean("constructed	InjectedController");
		System.out.println(constructedInjectedController.getGreeting());

	}

}
