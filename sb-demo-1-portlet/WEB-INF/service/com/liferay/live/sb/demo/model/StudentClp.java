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

import com.liferay.live.sb.demo.service.StudentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dnebinger
 */
public class StudentClp extends BaseModelImpl<Student> implements Student {
	public StudentClp() {
	}

	public Class<?> getModelClass() {
		return Student.class;
	}

	public String getModelClassName() {
		return Student.class.getName();
	}

	public long getPrimaryKey() {
		return _studentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setStudentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_studentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public boolean getEnrolled() {
		return _enrolled;
	}

	public boolean isEnrolled() {
		return _enrolled;
	}

	public void setEnrolled(boolean enrolled) {
		_enrolled = enrolled;
	}

	public Date getEnrollmentDate() {
		return _enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		_enrollmentDate = enrollmentDate;
	}

	public int getYearInSchool() {
		return _yearInSchool;
	}

	public void setYearInSchool(int yearInSchool) {
		_yearInSchool = yearInSchool;
	}

	public String getMajor() {
		return _major;
	}

	public void setMajor(String major) {
		_major = major;
	}

	public BaseModel<?> getStudentRemoteModel() {
		return _studentRemoteModel;
	}

	public void setStudentRemoteModel(BaseModel<?> studentRemoteModel) {
		_studentRemoteModel = studentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			StudentLocalServiceUtil.addStudent(this);
		}
		else {
			StudentLocalServiceUtil.updateStudent(this);
		}
	}

	@Override
	public Student toEscapedModel() {
		return (Student)Proxy.newProxyInstance(Student.class.getClassLoader(),
			new Class[] { Student.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StudentClp clone = new StudentClp();

		clone.setStudentId(getStudentId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setEnrolled(getEnrolled());
		clone.setEnrollmentDate(getEnrollmentDate());
		clone.setYearInSchool(getYearInSchool());
		clone.setMajor(getMajor());

		return clone;
	}

	public int compareTo(Student student) {
		int value = 0;

		value = getName().compareTo(student.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		StudentClp student = null;

		try {
			student = (StudentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = student.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{studentId=");
		sb.append(getStudentId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", enrolled=");
		sb.append(getEnrolled());
		sb.append(", enrollmentDate=");
		sb.append(getEnrollmentDate());
		sb.append(", yearInSchool=");
		sb.append(getYearInSchool());
		sb.append(", major=");
		sb.append(getMajor());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.live.sb.demo.model.Student");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enrolled</column-name><column-value><![CDATA[");
		sb.append(getEnrolled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enrollmentDate</column-name><column-value><![CDATA[");
		sb.append(getEnrollmentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearInSchool</column-name><column-value><![CDATA[");
		sb.append(getYearInSchool());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>major</column-name><column-value><![CDATA[");
		sb.append(getMajor());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _studentId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private boolean _enrolled;
	private Date _enrollmentDate;
	private int _yearInSchool;
	private String _major;
	private BaseModel<?> _studentRemoteModel;
}