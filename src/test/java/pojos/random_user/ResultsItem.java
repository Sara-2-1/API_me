package pojos.random_user;

public class ResultsItem{
	private String nat;
	private String gender;
	private String phone;
	private Dob dob;
	private Name name;
	private Registered registered;
	private Location location;
	private Id id;
	private Login login;
	private String cell;
	private String email;
	private Picture picture;

	public String getNat(){
		return nat;
	}

	public String getGender(){
		return gender;
	}

	public String getPhone(){
		return phone;
	}

	public Dob getDob(){
		return dob;
	}

	public Name getName(){
		return name;
	}

	public Registered getRegistered(){
		return registered;
	}

	public Location getLocation(){
		return location;
	}

	public Id getId(){
		return id;
	}

	public Login getLogin(){
		return login;
	}

	public String getCell(){
		return cell;
	}

	public String getEmail(){
		return email;
	}

	public Picture getPicture(){
		return picture;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"nat = '" + nat + '\'' + 
			",gender = '" + gender + '\'' + 
			",phone = '" + phone + '\'' + 
			",dob = '" + dob + '\'' + 
			",name = '" + name + '\'' + 
			",registered = '" + registered + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			",login = '" + login + '\'' + 
			",cell = '" + cell + '\'' + 
			",email = '" + email + '\'' + 
			",picture = '" + picture + '\'' + 
			"}";
		}
}
