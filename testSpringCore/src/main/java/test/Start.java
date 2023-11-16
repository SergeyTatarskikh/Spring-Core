package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ConsoleApplication consoleApplication = context.getBean(ConsoleApplication.class);
        consoleApplication.run();



    }
}
