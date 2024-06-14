package com.crudapplication.crudapp.model;

public class User {
	 private long id;
	    private String firstname;
	    private String lastname;
	    private String email;
	    private String department;
	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getFirstname() {
	        return firstname;
	    }

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public User(long id, String firstname, String lastname, String email, String department) {
	        this.id = id;
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.email = email;
	        this.department=department;
	    }

	    
		public User() {
			super();
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
					+ ", department=" + department + "]";
		}
		
}
