import Entities.PersonalInfo;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        DBManager dbm = DBManager.getInstance();

        for (var el : dbm.getAllPersonalInfo()) {
            System.out.println(el);
        }

        dbm.insertPersonalInfo(new PersonalInfo("Name1", "Name2", new Date(2000, 2,1)
        ,"+380684437462", "abasfsaf@gmail.com", "New york"));

        for (var el : dbm.getAllPersonalInfo()) {
            System.out.println(el);
        }
    }
}
