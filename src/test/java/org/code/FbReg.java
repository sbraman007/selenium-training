package org.code;





import java.util.List;
import java.util.Map;

import org.base.BaseClass;
import org.pojo.Pojo;
import io.cucumber.datatable.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FbReg extends BaseClass {

	Pojo s;
	@Given("To launch the browser and maximise it")
	public void to_launch_the_browser_and_maximise_it() {
	   launchBrowser();
	   windowMaximize();
	}

	@When("To launch the facebook application")
	public void to_launch_the_facebook_application() {
	    launchUrl("https://en-gb.facebook.com/");
	}

	@When("To click the create new account button")
	public void to_click_the_create_new_account_button() {
		s = new Pojo();
	   click(s.getCna());
	}

	@When("To pass the first name in first name box")
	public void to_pass_the_first_name_in_first_name_box(DataTable d) throws InterruptedException {
		Thread.sleep(5000);
		Map<Object, Object> l = d.asMap(String.class, String.class);
		s = new Pojo();
	   passText("ksdjkd", s.getFname());
	}

	@When("to pass the second name in second name box")
	public void to_pass_the_second_name_in_second_name_box() {
		s = new Pojo();
	    passText("Raman", s.getlName());
	}

	@When("To pass mobile no or email id in mobile number box")
	public void to_pass_mobile_no_or_email_id_in_mobile_number_box(DataTable t) {
		List<Map<String, String>> l = t.asMaps();
		s = new Pojo();
	    passText(l.get(1).get("password2"), s.getMob());
	}

	@When("To create new password using new password box")
	public void to_create_new_password_using_new_password_box() {
		s = new Pojo();
		passText("jashglasj", s.getPass());
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
//	    closeEntireBrowser();
	}


}
