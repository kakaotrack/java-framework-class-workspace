package kr.ac.jejunu;

/**
 * Created by hyh0408 on 2017. 3. 24..
 */
public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(new JejuConnectionMaker());
    }
}
