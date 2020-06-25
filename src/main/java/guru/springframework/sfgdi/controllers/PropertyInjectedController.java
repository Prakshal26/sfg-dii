package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;

//We have to manually specify this as controller so that automatic Dependecy Injection is done so
//automatically object of this class will be created when we had made bean of this calss in
//main sfg application run. With that bean only we will be able to access the method of this class.
@Controller
public class PropertyInjectedController {

    //Autowired tells Spring that we want the injection of GrettingServices.
    /*
    Again it is kind of same, it means i want to access the method of Greeting Service class so
    create it's object whereever you want and just allow me to use it's methods.
    SO we can access the methods of greeting servcice class even without creating the object.
     */
    @Autowired
    public GreetingService greetingService;

    public String getGreeting(){

        return greetingService.sayGreeting();
    }
}
