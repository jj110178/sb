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
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author    dnebinger
 * @see       Student
 * @generated
 */
public class StudentWrapper implements Student, ModelWrapper<Student> {
	public StudentWrapper(Student student) {
		_student = student;
	}

	public Class<?> getModelClass() {
		return Student.class;
	}

	public String getModelClassName() {
		return Student.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("studentId", getStudentId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("enrolled", getEnrolled());
		attributes.put("enrollmentDate", getEnrollmentDate());
		attributes.put("yearInSchool", getYearInSchool());
		attributes.put("major", getMajor());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean enrolled = (Boolean)attributes.get("enrolled");

		if (enrolled != null) {
			setEnrolled(enrolled);
		}

		Date enrollmentDate = (Date)attributes.get("enrollmentDate");

		if (enrollmentDate != null) {
			setEnrollmentDate(enrollmentDate);
		}

		Integer yearInSchool = (Integer)attributes.get("yearInSchool");

		if (yearInSchool != null) {
			setYearInSchool(yearInSchool);
		}

		String major = (String)attributes.get("major");

		if (major != null) {
			setMajor(major);
		}
	}

	/**
	* Returns the primary key of this student.
	*
	* @return the primary key of this student
	*/
	public long getPrimaryKey() {
		return _student.getPrimaryKey();
	}

	/**
	* Sets the primary key of this student.
	*
	* @param primaryKey the primary key of this student
	*/
	public void setPrimaryKey(long primaryKey) {
		_student.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the student ID of this student.
	*
	* @return the student ID of this student
	*/
	public long getStudentId() {
		return _student.getStudentId();
	}

	/**
	* Sets the student ID of this student.
	*
	* @param studentId the student ID of this student
	*/
	public void setStudentId(long studentId) {
		_student.setStudentId(studentId);
	}

	/**
	* Returns the user ID of this student.
	*
	* @return the user ID of this student
	*/
	public long getUserId() {
		return _student.getUserId();
	}

	/**
	* Sets the user ID of this student.
	*
	* @param userId the user ID of this student
	*/
	public void setUserId(long userId) {
		_student.setUserId(userId);
	}

	/**
	* Returns the user uuid of this student.
	*
	* @return the user uuid of this student
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _student.getUserUuid();
	}

	/**
	* Sets the user uuid of this student.
	*
	* @param userUuid the user uuid of this student
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_student.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this student.
	*
	* @return the create date of this student
	*/
	public java.util.Date getCreateDate() {
		return _student.getCreateDate();
	}

	/**
	* Sets the create date of this student.
	*
	* @param createDate the create date of this student
	*/
	public void setCreateDate(java.util.Date createDate) {
		_student.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this student.
	*
	* @return the modified date of this student
	*/
	public java.util.Date getModifiedDate() {
		return _student.getModifiedDate();
	}

	/**
	* Sets the modified date of this student.
	*
	* @param modifiedDate the modified date of this student
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_student.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this student.
	*
	* @return the name of this student
	*/
	public java.lang.String getName() {
		return _student.getName();
	}

	/**
	* Sets the name of this student.
	*
	* @param name the name of this student
	*/
	public void setName(java.lang.String name) {
		_student.setName(name);
	}

	/**
	* Returns the enrolled of this student.
	*
	* @return the enrolled of this student
	*/
	public boolean getEnrolled() {
		return _student.getEnrolled();
	}

	/**
	* Returns <code>true</code> if this student is enrolled.
	*
	* @return <code>true</code> if this student is enrolled; <code>false</code> otherwise
	*/
	public boolean isEnrolled() {
		return _student.isEnrolled();
	}

	/**
	* Sets whether this student is enrolled.
	*
	* @param enrolled the enrolled of this student
	*/
	public void setEnrolled(boolean enrolled) {
		_student.setEnrolled(enrolled);
	}

	/**
	* Returns the enrollment date of this student.
	*
	* @return the enrollment date of this student
	*/
	public java.util.Date getEnrollmentDate() {
		return _student.getEnrollmentDate();
	}

	/**
	* Sets the enrollment date of this student.
	*
	* @param enrollmentDate the enrollment date of this student
	*/
	public void setEnrollmentDate(java.util.Date enrollmentDate) {
		_student.setEnrollmentDate(enrollmentDate);
	}

	/**
	* Returns the year in school of this student.
	*
	* @return the year in school of this student
	*/
	public int getYearInSchool() {
		return _student.getYearInSchool();
	}

	/**
	* Sets the year in school of this student.
	*
	* @param yearInSchool the year in school of this student
	*/
	public void setYearInSchool(int yearInSchool) {
		_student.setYearInSchool(yearInSchool);
	}

	/**
	* Returns the major of this student.
	*
	* @return the major of this student
	*/
	public java.lang.String getMajor() {
		return _student.getMajor();
	}

	/**
	* Sets the major of this student.
	*
	* @param major the major of this student
	*/
	public void setMajor(java.lang.String major) {
		_student.setMajor(major);
	}

	public boolean isNew() {
		return _student.isNew();
	}

	public void setNew(boolean n) {
		_student.setNew(n);
	}

	public boolean isCachedModel() {
		return _student.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_student.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _student.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _student.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_student.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _student.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_student.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentWrapper((Student)_student.clone());
	}

	public int compareTo(com.liferay.live.sb.demo.model.Student student) {
		return _student.compareTo(student);
	}

	@Override
	public int hashCode() {
		return _student.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.live.sb.demo.model.Student> toCacheModel() {
		return _student.toCacheModel();
	}

	public com.liferay.live.sb.demo.model.Student toEscapedModel() {
		return new StudentWrapper(_student.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _student.toString();
	}

	public java.lang.String toXmlString() {
		return _student.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_student.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Student getWrappedStudent() {
		return _student;
	}

	public Student getWrappedModel() {
		return _student;
	}

	public void resetOriginalValues() {
		_student.resetOriginalValues();
	}

	private Student _student;
}