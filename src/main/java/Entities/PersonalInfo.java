package Entities;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PersonalInfo {
    private int id;
    private String firstName;
    private String secondName;
    private Date birthDate;
    private String phoneNumber;
    private String email;
    private String address;

    public PersonalInfo(int id, String firstName, String secondName, Date birthDate, String phoneNumber, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
    public PersonalInfo( String firstName, String secondName, Date birthDate, String phoneNumber, String email, String address) {

        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
