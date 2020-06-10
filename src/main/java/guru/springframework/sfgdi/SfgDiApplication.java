/*
 Previously we were using Same Service for all the three controller(Property,setter and Constructor based.
 BUt here we have created the different service for each of the controller(COnstructorGreetingService,
 PropertyInjectedGrettingService and SetterInjectedGreeting.
 Now we need to give qualifier so that it knows which bean to wire with which service.
*/
/*
Here we will create one service as a primary bean i.e if someone does not give qualifiers in controller
it will by defaul execute service associated with this primary bean
 */

/*We have to specify primary service explicitly using @service. See we have created a PrimaryGreetingService
class which will be our primary service.
 */
/*
Precedence will be given to qualifier and if qualifier is not found that controller will take
as primary service.
 */
//Check MyController class to see how we are running primary bean
//there no need of qualifier and autowired

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


		System.out.println(myController.sayHello());

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		//Do Same for setter based

		SetterInjectedController setterInjectedController= (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		ConstructedInjectedController constructedInjectedController= (ConstructedInjectedController) ctx.getBean("constructedInjectedController");
		System.out.println(constructedInjectedController.getGreeting());

	}

}
