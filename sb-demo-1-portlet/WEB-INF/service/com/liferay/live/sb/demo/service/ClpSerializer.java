/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.live.sb.demo.service;

import com.liferay.live.sb.demo.model.CourseCatalogClp;
import com.liferay.live.sb.demo.model.CourseClp;
import com.liferay.live.sb.demo.model.CourseStudentClp;
import com.liferay.live.sb.demo.model.InstructorClp;
import com.liferay.live.sb.demo.model.StudentClp;
import com.liferay.live.sb.demo.model.StudentGPAClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"sb-demo-1-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"sb-demo-1-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "sb-demo-1-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CourseClp.class.getName())) {
			return translateInputCourse(oldModel);
		}

		if (oldModelClassName.equals(CourseCatalogClp.class.getName())) {
			return translateInputCourseCatalog(oldModel);
		}

		if (oldModelClassName.equals(CourseStudentClp.class.getName())) {
			return translateInputCourseStudent(oldModel);
		}

		if (oldModelClassName.equals(InstructorClp.class.getName())) {
			return translateInputInstructor(oldModel);
		}

		if (oldModelClassName.equals(StudentClp.class.getName())) {
			return translateInputStudent(oldModel);
		}

		if (oldModelClassName.equals(StudentGPAClp.class.getName())) {
			return translateInputStudentGPA(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCourse(BaseModel<?> oldModel) {
		CourseClp oldClpModel = (CourseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseCatalog(BaseModel<?> oldModel) {
		CourseCatalogClp oldClpModel = (CourseCatalogClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseCatalogRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCourseStudent(BaseModel<?> oldModel) {
		CourseStudentClp oldClpModel = (CourseStudentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCourseStudentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInstructor(BaseModel<?> oldModel) {
		InstructorClp oldClpModel = (InstructorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInstructorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStudent(BaseModel<?> oldModel) {
		StudentClp oldClpModel = (StudentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStudentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStudentGPA(BaseModel<?> oldModel) {
		StudentGPAClp oldClpModel = (StudentGPAClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStudentGPARemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.live.sb.demo.model.impl.CourseImpl")) {
			return translateOutputCourse(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.live.sb.demo.model.impl.CourseCatalogImpl")) {
			return translateOutputCourseCatalog(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.live.sb.demo.model.impl.CourseStudentImpl")) {
			return translateOutputCourseStudent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.live.sb.demo.model.impl.InstructorImpl")) {
			return translateOutputInstructor(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.live.sb.demo.model.impl.StudentImpl")) {
			return translateOutputStudent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.live.sb.demo.model.impl.StudentGPAImpl")) {
			return translateOutputStudentGPA(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.liferay.live.sb.demo.NoSuchCourseException")) {
			return new com.liferay.live.sb.demo.NoSuchCourseException();
		}

		if (className.equals(
					"com.liferay.live.sb.demo.NoSuchCourseCatalogException")) {
			return new com.liferay.live.sb.demo.NoSuchCourseCatalogException();
		}

		if (className.equals(
					"com.liferay.live.sb.demo.NoSuchCourseStudentException")) {
			return new com.liferay.live.sb.demo.NoSuchCourseStudentException();
		}

		if (className.equals(
					"com.liferay.live.sb.demo.NoSuchInstructorException")) {
			return new com.liferay.live.sb.demo.NoSuchInstructorException();
		}

		if (className.equals("com.liferay.live.sb.demo.NoSuchStudentException")) {
			return new com.liferay.live.sb.demo.NoSuchStudentException();
		}

		if (className.equals(
					"com.liferay.live.sb.demo.NoSuchStudentGPAException")) {
			return new com.liferay.live.sb.demo.NoSuchStudentGPAException();
		}

		return throwable;
	}

	public static Object translateOutputCourse(BaseModel<?> oldModel) {
		CourseClp newModel = new CourseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseCatalog(BaseModel<?> oldModel) {
		CourseCatalogClp newModel = new CourseCatalogClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseCatalogRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCourseStudent(BaseModel<?> oldModel) {
		CourseStudentClp newModel = new CourseStudentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCourseStudentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInstructor(BaseModel<?> oldModel) {
		InstructorClp newModel = new InstructorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInstructorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStudent(BaseModel<?> oldModel) {
		StudentClp newModel = new StudentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStudentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStudentGPA(BaseModel<?> oldModel) {
		StudentGPAClp newModel = new StudentGPAClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStudentGPARemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}