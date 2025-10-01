import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);


        // HelloWorld twice (should be the same instance: true)
        HelloWorld hw1 = (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld hw2 = (HelloWorld) applicationContext.getBean("helloworld");

        // Cat twice (prototype; should be different instances: false)
        Cat c1 = (Cat) applicationContext.getBean("cat");
        Cat c2 = (Cat) applicationContext.getBean("cat");


        // Comparisons
        System.out.println("HelloWorld pair (expected true): " + (hw1 == hw2));
        System.out.println("Cat pair (expected false): " + (c1 == c2));

    }
}