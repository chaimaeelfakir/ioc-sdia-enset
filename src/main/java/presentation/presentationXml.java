package presentation;

import Framework.Container;
import metier.Imetier;

public class presentationXml {
        public static void main(String[] args) {
            System.out.println("probleme ");
            Container container = new Container();
             container.loadBeansFromXml("src/main/resources/config.xml");
             Imetier metier = (Imetier) container.getBean("metier");
            System.out.println("RES : "+metier.calculer());
        }
    }






