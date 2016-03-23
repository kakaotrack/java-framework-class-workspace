package kr.ac.jejunu.userdao;

/**
 * Created by hyh0408 on 2016. 3. 23..
 */
public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(new JejuConnectionMaker());
    }
}
