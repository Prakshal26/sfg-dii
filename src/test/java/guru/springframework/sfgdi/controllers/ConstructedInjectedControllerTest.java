package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructedInjectedControllerTest {

    ConstructedInjectedController controller;

    @BeforeEach
    void setUp() {
        //Passed the vlaue to the constructor
        controller = new ConstructedInjectedController(new GreetingServiceImpl());

    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}