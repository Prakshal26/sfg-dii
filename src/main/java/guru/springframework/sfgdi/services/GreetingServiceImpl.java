package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

//We also have to specify that this is a service. This will be checked By autowired that we have given
//in COntroller. We have created the object of Gretting Servoce there and mentioned autowired i.e specifyng
//that this is a service. But here we are explicitly saying yes this is a service.
@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "HelloWorld";
    }
}
/*
Lets learn how the code will reach here.
1.) It will start from main sfg application. There we have created the bean of PropertyInjectedController.
Controller is playing the role to control the flow.
------System.out.println(propertyInjectedController.getGreeting())------>In main we have given this.

propertyInjectedController is the bean of PropertyInjectedcController class. As we have given
controller annotation in PropertyInjectedcController class it's object will be created automatically
and we will be able to use it's method by bean object i.e propertyInjectedcController.

2.) Now comes PropertyInjectedcController Class there. As above propertyInjectedcController wants
to access getGreeting method of PropertyInjectedcController class it will execute.

-------greetingService.sayGreeting()-----given in PropertyInjectedcController class
But here it is accessing GreetingService object which we have never created.

We have given autowired on it which means that this the object of some service so create the object
internally for us. So it will create the object of GreetingService and we can use the method
of GreetingService easily.

3). Actually greeting service class which will return what we really want.
Just give @Service there so that it creates the object automatically and we can use it's method.
 */