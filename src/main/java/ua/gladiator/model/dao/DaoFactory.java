package ua.gladiator.model.dao;

import ua.gladiator.model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {
    private static volatile DaoFactory daoFactory;

    public abstract CarDao createCarDao();
    public abstract ClientDao createClientDao();
    public abstract DiscountDao createDiscountDao();
    public abstract OrderDao createOrderDao();
    public abstract TimeDao createTimeDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
