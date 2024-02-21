package Framework;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name = "beans")
public class BeanConfiguration {
    private List<Bean> beanList;

    @XmlElement(name = "bean")
    public List<Bean> getBeanList() {
            return beanList;
        }
    public void setBeanList(List<Bean> beanList) {
            this.beanList = beanList;
        }
    }

