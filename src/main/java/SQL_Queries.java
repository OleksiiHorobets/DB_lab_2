public interface SQL_Queries {
    String GET_ALL_PERSONAL_INFO = "SELECT * FROM Personal_info";
    String INSERT_INTO_PERSONAL_INFO = "INSERT INTO Personal_info(first_name, second_name, birth_date, phone_number, email, [address])" +
            "VALUES (?, ?, ?, ?, ?, ?)";

}
