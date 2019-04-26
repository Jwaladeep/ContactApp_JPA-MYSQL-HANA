package com.sap.ca;
import javax.persistence.*;

@Entity
/*@Table (name="Person")*/
public class PersonalDetails
{
private String Name;
@Id
private String PhoneNo;

public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getPhoneNo() {
	return PhoneNo;
}
public void setPhoneNo(String phoneNo) {
	PhoneNo = phoneNo;
}

}