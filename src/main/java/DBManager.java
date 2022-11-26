import Entities.PersonalInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static DBManager dbm;

    private DBManager() {
    }

    synchronized public static DBManager getInstance() {
        if (dbm != null) {
            return dbm;
        }
        dbm = new DBManager();
        return dbm;
    }


    public List<PersonalInfo> getAllPersonalInfo() {
        List<PersonalInfo> personalInfosList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(Config.CONNECTION_URL, Config.LOGIN, Config.PASSWORD);
             Statement st = con.createStatement()) {

            var rs = st.executeQuery(SQL_Queries.GET_ALL_PERSONAL_INFO);

            while (rs.next()) {
                personalInfosList.add(new PersonalInfo(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("second_name"),
                        rs.getDate("birth_date"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getString("address")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personalInfosList;
    }

    public void insertPersonalInfo(PersonalInfo personalInfo) {
        try (Connection con = DriverManager.getConnection(Config.CONNECTION_URL, Config.LOGIN, Config.PASSWORD);
             PreparedStatement st = con.prepareStatement(SQL_Queries.INSERT_INTO_PERSONAL_INFO)) {
            int k = 1;
            st.setString(k++, personalInfo.getFirstName());
            st.setString(k++, personalInfo.getSecondName());
            st.setDate(k++, personalInfo.getBirthDate());
            st.setString(k++, personalInfo.getPhoneNumber());
            st.setString(k++, personalInfo.getEmail());
            st.setString(k, personalInfo.getAddress());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
