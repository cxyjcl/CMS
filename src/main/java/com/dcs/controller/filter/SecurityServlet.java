/*
 * Copyright 1999-2011 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dcs.controller.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SecurityServlet implements Filter {
	private Log logger = LogFactory.getLog(SecurityServlet.class);
	public static final String PARAM_NAME_EXCLUSIONS = "exclusions";
	private Set<String> excludesPattern;

	private String contextPath;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestURI = getRequestURI(httpRequest);
		logger.info(requestURI);
		System.out.println(requestURI);
		if (isExclusion(requestURI)) {
			System.out.println("exclusion:" + requestURI);

			chain.doFilter(httpRequest, httpResponse);
			return;
		} else {
			System.out.println("inclusion:" + requestURI);
			HttpSession session = httpRequest.getSession();
			Object attribute = session.getAttribute("user");// 登录人角色
			if (attribute == null && requestURI.indexOf("login") < 0) {
				httpRequest.setAttribute("message", "你未登录");
				httpResponse.sendRedirect(contextPath + "/login");
				return;
			}
			chain.doFilter(httpRequest, httpResponse);
		}
		return;
	}

	public boolean isExclusion(String requestURI) {
		if (excludesPattern == null) {
			return false;
		}

		if (contextPath != null && requestURI.startsWith(contextPath)) {
			requestURI = requestURI.substring(contextPath.length());
			if (!requestURI.startsWith("/")) {
				requestURI = "/" + requestURI;
			}
		}

		for (String pattern : excludesPattern) {
			if (matches(pattern, requestURI)) {
				return true;
			}
		}

		return false;
	}

	public String getRequestURI(HttpServletRequest request) {
		return request.getRequestURI();
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		{
			String exclusions = config.getInitParameter(PARAM_NAME_EXCLUSIONS);
			if (exclusions != null && exclusions.trim().length() != 0) {
				excludesPattern = new HashSet<String>(Arrays.asList(exclusions
						.split("\\s*,\\s*")));
			}
		}

		{

			this.contextPath = getContextPath(config.getServletContext());
		}
	}

	public static String getContextPath(ServletContext context) {
		if (context.getMajorVersion() == 2 && context.getMinorVersion() < 5) {
			return null;
		}

		try {
			return getContextPath_2_5(context);
		} catch (NoSuchMethodError error) {
			return null;
		}
	}

	private static String getContextPath_2_5(ServletContext context) {
		String contextPath = context.getContextPath();

		if (contextPath == null || contextPath.length() == 0) {
			contextPath = "/";
		}

		return contextPath;
	}

	@Override
	public void destroy() {
	}

	public String getContextPath() {
		return contextPath;
	}

	public boolean matches(String pattern, String source) {
		if (pattern == null || source == null) {
			return false;
		}
		pattern = pattern.trim();
		source = source.trim();
		if (pattern.endsWith("*")) {
			// pattern: /dcs* source:/dcs/index.html
			int length = pattern.length() - 1;
			if (source.length() >= length) {
				if (pattern.substring(0, length).equals(
						source.substring(0, length))) {
					return true;
				}
			}
		} else if (pattern.startsWith("*")) {
			// pattern: *.html source:/xx/xx.html
			int length = pattern.length() - 1;
			if (source.length() >= length
					&& source.endsWith(pattern.substring(1))) {
				return true;
			}
		} else {
			// pattern: /dcs/index.html source:/dcs/index.html
			if (pattern.equals(source)) {
				return true;
			}
		}
		return false;
	}
}
