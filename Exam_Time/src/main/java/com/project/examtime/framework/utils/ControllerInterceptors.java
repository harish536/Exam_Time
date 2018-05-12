package com.project.examtime.framework.utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.project.examtime.framework.logging.AppLogger;
import com.project.examtime.framework.logging.Log;



public class ControllerInterceptors extends HandlerInterceptorAdapter {

		private static @Log AppLogger logger;

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {

			if (handler instanceof HandlerMethod) {
				HandlerMethod method = (HandlerMethod) handler;
				if (method.getMethod().isAnnotationPresent(AuthorizationPrivilage.class)) {

				}
			}
			return true;
		}

	}

