package presentation;

import metier.Imetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class pres_sprinAnnotation {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext("ext","metier");
        Imetier metier = (Imetier) context.getBean("metier");
        System.out.println("Spring Annotation");
        System.out.println("Res : "+metier.calculer());
    }
}
