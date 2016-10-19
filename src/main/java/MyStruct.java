
public class MyStruct
{
	private String name = "";
	private int age = 0;
	private int phone = 0;
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getPhone()
	{
		return phone;
	}
	
	public void setPhone(int phone)
	{
		this.phone = phone;
	}
	
	@Override
	public String toString()
	{
		return "MyStruct [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}

	public MyStruct()
	{
		this("wkkim", 25, 88430631);
	}
	
	public MyStruct(Object name, Object age, Object phone)
	{
		this.name = name.toString();
		this.age = Integer.parseInt(age.toString());
		this.phone = Integer.parseInt(phone.toString());
	}

}
