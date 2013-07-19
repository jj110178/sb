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

import com.liferay.live.sb.demo.service.CourseLocalServiceUtil;

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
public class CourseClp extends BaseModelImpl<Course> implements Course {
	public CourseClp() {
	}

	public Class<?> getModelClass() {
		return Course.class;
	}

	public String getModelClassName() {
		return Course.class.getName();
	}

	public long getPrimaryKey() {
		return _courseId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCourseId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_courseId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
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

	public long getInstructorId() {
		return _instructorId;
	}

	public void setInstructorId(long instructorId) {
		_instructorId = instructorId;
	}

	public long getCourseCatalogId() {
		return _courseCatalogId;
	}

	public void setCourseCatalogId(long courseCatalogId) {
		_courseCatalogId = courseCatalogId;
	}

	public int getCreditHours() {
		return _creditHours;
	}

	public void setCreditHours(int creditHours) {
		_creditHours = creditHours;
	}

	public int getSemester() {
		return _semester;
	}

	public void setSemester(int semester) {
		_semester = semester;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMajor() {
		return _major;
	}

	public void setMajor(String major) {
		_major = major;
	}

	public BaseModel<?> getCourseRemoteModel() {
		return _courseRemoteModel;
	}

	public void setCourseRemoteModel(BaseModel<?> courseRemoteModel) {
		_courseRemoteModel = courseRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseLocalServiceUtil.addCourse(this);
		}
		else {
			CourseLocalServiceUtil.updateCourse(this);
		}
	}

	@Override
	public Course toEscapedModel() {
		return (Course)Proxy.newProxyInstance(Course.class.getClassLoader(),
			new Class[] { Course.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseClp clone = new CourseClp();

		clone.setCourseId(getCourseId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setInstructorId(getInstructorId());
		clone.setCourseCatalogId(getCourseCatalogId());
		clone.setCreditHours(getCreditHours());
		clone.setSemester(getSemester());
		clone.setYear(getYear());
		clone.setName(getName());
		clone.setMajor(getMajor());

		return clone;
	}

	public int compareTo(Course course) {
		int value = 0;

		if (getYear() < course.getYear()) {
			value = -1;
		}
		else if (getYear() > course.getYear()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getSemester() < course.getSemester()) {
			value = -1;
		}
		else if (getSemester() > course.getSemester()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getName().compareTo(course.getName());

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

		CourseClp course = null;

		try {
			course = (CourseClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = course.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{courseId=");
		sb.append(getCourseId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", instructorId=");
		sb.append(getInstructorId());
		sb.append(", courseCatalogId=");
		sb.append(getCourseCatalogId());
		sb.append(", creditHours=");
		sb.append(getCreditHours());
		sb.append(", semester=");
		sb.append(getSemester());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", major=");
		sb.append(getMajor());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.live.sb.demo.model.Course");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
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
			"<column><column-name>instructorId</column-name><column-value><![CDATA[");
		sb.append(getInstructorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseCatalogId</column-name><column-value><![CDATA[");
		sb.append(getCourseCatalogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditHours</column-name><column-value><![CDATA[");
		sb.append(getCreditHours());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>semester</column-name><column-value><![CDATA[");
		sb.append(getSemester());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>major</column-name><column-value><![CDATA[");
		sb.append(getMajor());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _courseId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _instructorId;
	private long _courseCatalogId;
	private int _creditHours;
	private int _semester;
	private int _year;
	private String _name;
	private String _major;
	private BaseModel<?> _courseRemoteModel;
}