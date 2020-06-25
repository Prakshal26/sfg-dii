/*
Here we are not changing the previous code. Just in this main application file only we will
be able to run the program without the need of Test Files. It is the additional functionality that
we get from the framework i.e spring framework. i.e how automatically dependency injection is performed
by the spring.

Previously we have seen that we were manual creating the controllers in test folder which was creating thr
object of PropertyInjectedController etc. But here we dont need to create controller by ourself.
we can just give @controller annotation and that will automatically create the object of
the class where we have given that annotation. Here we will give @controller annotation on the classes
like PropertyInjectedController etc.
As a result we do not have to create the object of those classes explicity using new keyword, spring will
create that for us.
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
		System.out.println("My Controller");
		String greeting = myController.sayHello();

		System.out.println(greeting);
		/*
		HEre we will see automatic dependency injection
		In PropertyInjectedControler we have specified it to be as Controller
		We need to explicitly say that that particular class is a controller.
		 */
		//In Greeting Serviceimpl Class we have mentioned Greeting service to be a service.
		// Now whenever we are using Greeting Service Class object we are giving it as Autowired i.e
		//explicitly saying this is a service.
		// This will be checked By autowired that we have given it as as Service.
		/*
		Autowired: It seeks the object it is looking is a service
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
		/*
		We have created the object of PROPERTYINJECTEDCONTROLLER but wee have not given new. Earlier we were using
		PropertyInjectedControllerTest in test folder where we were given the new keyword to create object.
		Here we are not doing this, We have called getGreeting(). If we will open propertyInjectedController class
		we will see it is using GreetingService data member and calling sayGreeting function.
		How does PropertyInjectedController Class know where is the implememntation of saygreeeting function.
		This is done by Service and Autowired.
		In GreetingServiceImpl class we have given it to be a service and in propertyInjectedControllerClass we
		are giveing autowired and that's how it knows it has to call that service.
		 */
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println("PropertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		//Do Same for setter based

		SetterInjectedController setterInjectedController= (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println("SetterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		ConstructedInjectedController constructedInjectedController= (ConstructedInjectedController) ctx.getBean("constructedInjectedController");
		System.out.println("ConstructedInjectedController");
		System.out.println(constructedInjectedController.getGreeting());

	}

}
