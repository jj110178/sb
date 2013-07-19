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
 * This class is a wrapper for {@link CourseStudent}.
 * </p>
 *
 * @author    dnebinger
 * @see       CourseStudent
 * @generated
 */
public class CourseStudentWrapper implements CourseStudent,
	ModelWrapper<CourseStudent> {
	public CourseStudentWrapper(CourseStudent courseStudent) {
		_courseStudent = courseStudent;
	}

	public Class<?> getModelClass() {
		return CourseStudent.class;
	}

	public String getModelClassName() {
		return CourseStudent.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("studentId", getStudentId());
		attributes.put("courseId", getCourseId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("grade", getGrade());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

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

		Double grade = (Double)attributes.get("grade");

		if (grade != null) {
			setGrade(grade);
		}
	}

	/**
	* Returns the primary key of this course student.
	*
	* @return the primary key of this course student
	*/
	public com.liferay.live.sb.demo.service.persistence.CourseStudentPK getPrimaryKey() {
		return _courseStudent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course student.
	*
	* @param primaryKey the primary key of this course student
	*/
	public void setPrimaryKey(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK primaryKey) {
		_courseStudent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the student ID of this course student.
	*
	* @return the student ID of this course student
	*/
	public long getStudentId() {
		return _courseStudent.getStudentId();
	}

	/**
	* Sets the student ID of this course student.
	*
	* @param studentId the student ID of this course student
	*/
	public void setStudentId(long studentId) {
		_courseStudent.setStudentId(studentId);
	}

	/**
	* Returns the course ID of this course student.
	*
	* @return the course ID of this course student
	*/
	public long getCourseId() {
		return _courseStudent.getCourseId();
	}

	/**
	* Sets the course ID of this course student.
	*
	* @param courseId the course ID of this course student
	*/
	public void setCourseId(long courseId) {
		_courseStudent.setCourseId(courseId);
	}

	/**
	* Returns the user ID of this course student.
	*
	* @return the user ID of this course student
	*/
	public long getUserId() {
		return _courseStudent.getUserId();
	}

	/**
	* Sets the user ID of this course student.
	*
	* @param userId the user ID of this course student
	*/
	public void setUserId(long userId) {
		_courseStudent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course student.
	*
	* @return the user uuid of this course student
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseStudent.getUserUuid();
	}

	/**
	* Sets the user uuid of this course student.
	*
	* @param userUuid the user uuid of this course student
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_courseStudent.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this course student.
	*
	* @return the create date of this course student
	*/
	public java.util.Date getCreateDate() {
		return _courseStudent.getCreateDate();
	}

	/**
	* Sets the create date of this course student.
	*
	* @param createDate the create date of this course student
	*/
	public void setCreateDate(java.util.Date createDate) {
		_courseStudent.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course student.
	*
	* @return the modified date of this course student
	*/
	public java.util.Date getModifiedDate() {
		return _courseStudent.getModifiedDate();
	}

	/**
	* Sets the modified date of this course student.
	*
	* @param modifiedDate the modified date of this course student
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseStudent.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the grade of this course student.
	*
	* @return the grade of this course student
	*/
	public double getGrade() {
		return _courseStudent.getGrade();
	}

	/**
	* Sets the grade of this course student.
	*
	* @param grade the grade of this course student
	*/
	public void setGrade(double grade) {
		_courseStudent.setGrade(grade);
	}

	public boolean isNew() {
		return _courseStudent.isNew();
	}

	public void setNew(boolean n) {
		_courseStudent.setNew(n);
	}

	public boolean isCachedModel() {
		return _courseStudent.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_courseStudent.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _courseStudent.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _courseStudent.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseStudent.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseStudent.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseStudent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseStudentWrapper((CourseStudent)_courseStudent.clone());
	}

	public int compareTo(
		com.liferay.live.sb.demo.model.CourseStudent courseStudent) {
		return _courseStudent.compareTo(courseStudent);
	}

	@Override
	public int hashCode() {
		return _courseStudent.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.live.sb.demo.model.CourseStudent> toCacheModel() {
		return _courseStudent.toCacheModel();
	}

	public com.liferay.live.sb.demo.model.CourseStudent toEscapedModel() {
		return new CourseStudentWrapper(_courseStudent.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseStudent.toString();
	}

	public java.lang.String toXmlString() {
		return _courseStudent.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseStudent.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CourseStudent getWrappedCourseStudent() {
		return _courseStudent;
	}

	public CourseStudent getWrappedModel() {
		return _courseStudent;
	}

	public void resetOriginalValues() {
		_courseStudent.resetOriginalValues();
	}

	private CourseStudent _courseStudent;
}