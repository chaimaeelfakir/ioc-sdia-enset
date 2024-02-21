package Framework;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<String, Object> beans = new HashMap<>();
    public void registerBean(String id, Object instance) {
        beans.put(id, instance);
    }
    public Object getBean(String id) {
        return beans.get(id);
    }
    public void loadBeansFromXml(String xmlFilePath) {
        try {

                // Chargement du fichier depuis les ressources du classloader
            File file = new File(xmlFilePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(BeanConfiguration.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            BeanConfiguration beanConfig = (BeanConfiguration) jaxbUnmarshaller.unmarshal(file);

            for (Bean bean : beanConfig.getBeanList()) {
                Class<?> clazz = Class.forName(bean.getClassName());
                Object instance = clazz.newInstance();

                for (Property property : bean.getPropertyList()) {
                    Object dependency = getBean(property.getRef());
                    clazz.getMethod("set" + property.getName(), dependency.getClass()).invoke(instance, dependency);
                }

                registerBean(bean.getId(), instance);
            }
        } catch (JAXBException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException |
                 InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("probleme de Container");
        }
    }
}

