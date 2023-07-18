package org.pojo;




import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo extends BaseClass{

	public Pojo() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[text()='Create new account']")
	private WebElement cna;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement fname;

	@FindBy(name="lastname")
	private WebElement lName;
	
	@FindBy(name="reg_email__")
	private WebElement mob;
	
	@FindBy(id="password_step_input")
	private WebElement pass;

	public WebElement getCna() {
		return cna;
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getlName() {
		return lName;
	}

	public WebElement getMob() {
		return mob;
	}

	public WebElement getPass() {
		return pass;
	}
	
	 
}
