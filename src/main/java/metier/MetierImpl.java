package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements Imetier{
    @Autowired
    private IDao dao;
    @Override
    public double calculer() {
        double d=dao.getData();
        double resultat=d*11.4;
        return resultat;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
