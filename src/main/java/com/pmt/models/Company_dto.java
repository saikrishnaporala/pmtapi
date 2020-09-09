package com.pmt.models;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

/**
 * The persistent class for the companies database table.
 * 
 */
public class Company_dto {

	private UUID id;

	private String companyName;
	private String contactPerson;
	private MultipartFile logo;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String phone;
	private String fax;
	private String email;
	private String website;
	private String legalStatus;// (e.g. Partnership, Private Limited Company, Government Institution)
	private String estdYear;
	private String empcount;
	private String accessempcount;
	private String businessType;// Products: Manufacturer Sole Agent Supplier
	private String aboutme;
	private byte isActive;
	private Date created;
	private Date modified;
	private Set<Department> dept;

	public Company_dto() {
	}

	public Company_dto(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public MultipartFile getLogo() {
		return logo;
	}

	public void setLogo(MultipartFile logo) {
		this.logo = logo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLegalStatus() {
		return legalStatus;
	}

	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}

	public String getEstdYear() {
		return estdYear;
	}

	public void setEstdYear(String estdYear) {
		this.estdYear = estdYear;
	}

	public String getEmpcount() {
		return empcount;
	}

	public void setEmpcount(String empcount) {
		this.empcount = empcount;
	}

	public String getAccessempcount() {
		return accessempcount;
	}

	public void setAccessempcount(String accessempcount) {
		this.accessempcount = accessempcount;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Set<Department> getDept() {
		return dept;
	}

	public void setDept(Set<Department> dept) {
		this.dept = dept;
	}

	public Company_dto(UUID id, String companyName, String contactPerson, MultipartFile logo, String address1,
			String address2, String city, String state, String country, String zip, String phone, String fax,
			String email, String website, String legalStatus, String estdYear, String empcount, String accessempcount,
			String businessType, String aboutme, byte isActive, Date created, Date modified, Set<Department> dept) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.contactPerson = contactPerson;
		this.logo = logo;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
		this.website = website;
		this.legalStatus = legalStatus;
		this.estdYear = estdYear;
		this.empcount = empcount;
		this.accessempcount = accessempcount;
		this.businessType = businessType;
		this.aboutme = aboutme;
		this.isActive = isActive;
		this.created = created;
		this.modified = modified;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", contactPerson=" + contactPerson + ", logo="
				+ logo + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zip=" + zip + ", phone=" + phone + ", fax=" + fax + ", email=" + email
				+ ", website=" + website + ", legalStatus=" + legalStatus + ", estdYear=" + estdYear + ", empcount="
				+ empcount + ", accessempcount=" + accessempcount + ", businessType=" + businessType + ", aboutme="
				+ aboutme + ", isActive=" + isActive + ", created=" + created + ", modified=" + modified + ", dept="
				+ dept + "]";
	}

}