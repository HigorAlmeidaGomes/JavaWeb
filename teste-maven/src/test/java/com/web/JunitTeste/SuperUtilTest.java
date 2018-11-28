package com.web.JunitTeste;

import org.junit.Test;

import com.web.commons.SuperUtil;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SuperUtilTest {

	@Test
	public void escapeHTMLTeste() {
		String escapedHTML = SuperUtil.escapeHTML("<script>alert(1);</script>");
		String expected = "&lt;script&gt;alert(1);&lt;/script&gt;";
		Assert.assertEquals(expected, escapedHTML);
	}

}
