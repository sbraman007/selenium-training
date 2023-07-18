package org.code;

import org.base.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void preCondition() {
		launchBrowser();
		windowMaximize();
	}
	@After
	public void postCondition() {
		closeEntireBrowser();
	}

}
