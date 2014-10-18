package test_online.modol;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
private int id_st;
private int id_number;
private String name;
private String password;
private String college;
private String major;
private int grade;
private int manger;//是否为管理员，默认为0
private int speak;//是否能够发言，默认为1


public int getId_number() {
	return id_number;
}
@Id
@GeneratedValue
public int getId_st() {
	return id_st;
}
public void setId_st(int id_st) {
	this.id_st = id_st;
}
public void setId_number(int id_number) {
	this.id_number = id_number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public int getManger() {
	return manger;
}
public void setManger(int manger) {
	this.manger = manger;
}
public int getSpeak() {
	return speak;
}
public void setSpeak(int speak) {
	this.speak = speak;
}


}
