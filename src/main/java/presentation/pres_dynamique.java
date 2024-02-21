package presentation;

import dao.IDao;
import metier.Imetier;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pres_dynamique {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();


            String metierClassName = scanner.nextLine();
            Class cMetier = Class.forName(metierClassName);
            Imetier metier = (Imetier) cMetier.getConstructor().newInstance();


            Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);
            System.out.println("presentation dynamique");
            System.out.println("RES : "+metier.calculer());
            scanner.close(); // Fermeture du scanner pour libérer les ressources
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Gestion de l'exception de fichier non trouvé
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace(); // Gestion d'autres exceptions possibles
        }
    }
}

