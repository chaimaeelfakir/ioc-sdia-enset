package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("daov2")
public class DaoImplv2 implements IDao {
    @Override
    public double getData() {
        System.out.println("version web service");
        double data=99;
        return data;
    }
}
