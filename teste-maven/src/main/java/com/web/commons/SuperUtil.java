package com.web.commons;

import org.apache.commons.lang3.StringEscapeUtils;

public class SuperUtil {
	public static String escapeHTML(String html) {
		return StringEscapeUtils.escapeHtml4(html);
	}
}
