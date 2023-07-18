package org.code;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Challenge3 extends BaseClass{

	@Before
	public void launchbrowser() {
		launchBrowser();
		windowMaximize();
	}
	@Test
	public void tc1() {
		System.out.println("Gmail Assert Passing");
		launchUrl("https://accounts.google.com/InteractiveLogin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&ffgf=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv=Af_xneEhmDK_JRmatLmF6_q4Uo911M4dr4NdWz3LNJKQ8Y_YOfeC7nwIDPVtS0HNjQQ5_JCl2dHijA&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		String k = pageUrl();
		Pojoaa q = new Pojoaa();
		passText("bala11082000",q.getEmail() );
		Assert.assertEquals("Cheak the Title", k, k.contains("google"));
		click(q.getLog());
	}
}
