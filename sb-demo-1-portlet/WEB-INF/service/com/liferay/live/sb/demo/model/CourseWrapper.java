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

package com.liferay.live.sb.demo.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Course}.
 * </p>
 *
 * @author    dnebinger
 * @see       Course
 * @generated
 */
public class CourseWrapper implements Course, ModelWrapper<Course> {
	public CourseWrapper(Course course) {
		_course = course;
	}

	public Class<?> getModelClass() {
		return Course.class;
	}

	public String getModelClassName() {
		return Course.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("courseId", getCourseId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("instructorId", getInstructorId());
		attributes.put("courseCatalogId", getCourseCatalogId());
		attributes.put("creditHours", getCreditHours());
		attributes.put("semester", getSemester());
		attributes.put("year", getYear());
		attributes.put("name", getName());
		attributes.put("major", getMajor());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long instructorId = (Long)attributes.get("instructorId");

		if (instructorId != null) {
			setInstructorId(instructorId);
		}

		Long courseCatalogId = (Long)attributes.get("courseCatalogId");

		if (courseCatalogId != null) {
			setCourseCatalogId(courseCatalogId);
		}

		Integer creditHours = (Integer)attributes.get("creditHours");

		if (creditHours != null) {
			setCreditHours(creditHours);
		}

		Integer semester = (Integer)attributes.get("semester");

		if (semester != null) {
			setSemester(semester);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String major = (String)attributes.get("major");

		if (major != null) {
			setMajor(major);
		}
	}

	/**
	* Returns the primary key of this course.
	*
	* @return the primary key of this course
	*/
	public long getPrimaryKey() {
		return _course.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course.
	*
	* @param primaryKey the primary key of this course
	*/
	public void setPrimaryKey(long primaryKey) {
		_course.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the course ID of this course.
	*
	* @return the course ID of this course
	*/
	public long getCourseId() {
		return _course.getCourseId();
	}

	/**
	* Sets the course ID of this course.
	*
	* @param courseId the course ID of this course
	*/
	public void setCourseId(long courseId) {
		_course.setCourseId(courseId);
	}

	/**
	* Returns the user ID of this course.
	*
	* @return the user ID of this course
	*/
	public long getUserId() {
		return _course.getUserId();
	}

	/**
	* Sets the user ID of this course.
	*
	* @param userId the user ID of this course
	*/
	public void setUserId(long userId) {
		_course.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course.
	*
	* @return the user uuid of this course
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course.getUserUuid();
	}

	/**
	* Sets the user uuid of this course.
	*
	* @param userUuid the user uuid of this course
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_course.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this course.
	*
	* @return the create date of this course
	*/
	public java.util.Date getCreateDate() {
		return _course.getCreateDate();
	}

	/**
	* Sets the create date of this course.
	*
	* @param createDate the create date of this course
	*/
	public void setCreateDate(java.util.Date createDate) {
		_course.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course.
	*
	* @return the modified date of this course
	*/
	public java.util.Date getModifiedDate() {
		return _course.getModifiedDate();
	}

	/**
	* Sets the modified date of this course.
	*
	* @param modifiedDate the modified date of this course
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_course.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the instructor ID of this course.
	*
	* @return the instructor ID of this course
	*/
	public long getInstructorId() {
		return _course.getInstructorId();
	}

	/**
	* Sets the instructor ID of this course.
	*
	* @param instructorId the instructor ID of this course
	*/
	public void setInstructorId(long instructorId) {
		_course.setInstructorId(instructorId);
	}

	/**
	* Returns the course catalog ID of this course.
	*
	* @return the course catalog ID of this course
	*/
	public long getCourseCatalogId() {
		return _course.getCourseCatalogId();
	}

	/**
	* Sets the course catalog ID of this course.
	*
	* @param courseCatalogId the course catalog ID of this course
	*/
	public void setCourseCatalogId(long courseCatalogId) {
		_course.setCourseCatalogId(courseCatalogId);
	}

	/**
	* Returns the credit hours of this course.
	*
	* @return the credit hours of this course
	*/
	public int getCreditHours() {
		return _course.getCreditHours();
	}

	/**
	* Sets the credit hours of this course.
	*
	* @param creditHours the credit hours of this course
	*/
	public void setCreditHours(int creditHours) {
		_course.setCreditHours(creditHours);
	}

	/**
	* Returns the semester of this course.
	*
	* @return the semester of this course
	*/
	public int getSemester() {
		return _course.getSemester();
	}

	/**
	* Sets the semester of this course.
	*
	* @param semester the semester of this course
	*/
	public void setSemester(int semester) {
		_course.setSemester(semester);
	}

	/**
	* Returns the year of this course.
	*
	* @return the year of this course
	*/
	public int getYear() {
		return _course.getYear();
	}

	/**
	* Sets the year of this course.
	*
	* @param year the year of this course
	*/
	public void setYear(int year) {
		_course.setYear(year);
	}

	/**
	* Returns the name of this course.
	*
	* @return the name of this course
	*/
	public java.lang.String getName() {
		return _course.getName();
	}

	/**
	* Sets the name of this course.
	*
	* @param name the name of this course
	*/
	public void setName(java.lang.String name) {
		_course.setName(name);
	}

	/**
	* Returns the major of this course.
	*
	* @return the major of this course
	*/
	public java.lang.String getMajor() {
		return _course.getMajor();
	}

	/**
	* Sets the major of this course.
	*
	* @param major the major of this course
	*/
	public void setMajor(java.lang.String major) {
		_course.setMajor(major);
	}

	public boolean isNew() {
		return _course.isNew();
	}

	public void setNew(boolean n) {
		_course.setNew(n);
	}

	public boolean isCachedModel() {
		return _course.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_course.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _course.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _course.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_course.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _course.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_course.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseWrapper((Course)_course.clone());
	}

	public int compareTo(com.liferay.live.sb.demo.model.Course course) {
		return _course.compareTo(course);
	}

	@Override
	public int hashCode() {
		return _course.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.live.sb.demo.model.Course> toCacheModel() {
		return _course.toCacheModel();
	}

	public com.liferay.live.sb.demo.model.Course toEscapedModel() {
		return new CourseWrapper(_course.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _course.toString();
	}

	public java.lang.String toXmlString() {
		return _course.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_course.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Course getWrappedCourse() {
		return _course;
	}

	public Course getWrappedModel() {
		return _course;
	}

	public void resetOriginalValues() {
		_course.resetOriginalValues();
	}

	private Course _course;
}