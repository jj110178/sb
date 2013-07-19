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

import com.liferay.live.sb.demo.service.CourseStudentLocalServiceUtil;
import com.liferay.live.sb.demo.service.persistence.CourseStudentPK;

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
public class CourseStudentClp extends BaseModelImpl<CourseStudent>
	implements CourseStudent {
	public CourseStudentClp() {
	}

	public Class<?> getModelClass() {
		return CourseStudent.class;
	}

	public String getModelClassName() {
		return CourseStudent.class.getName();
	}

	public CourseStudentPK getPrimaryKey() {
		return new CourseStudentPK(_studentId, _courseId);
	}

	public void setPrimaryKey(CourseStudentPK primaryKey) {
		setStudentId(primaryKey.studentId);
		setCourseId(primaryKey.courseId);
	}

	public Serializable getPrimaryKeyObj() {
		return new CourseStudentPK(_studentId, _courseId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CourseStudentPK)primaryKeyObj);
	}

	@Override
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

	@Override
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

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
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

	public double getGrade() {
		return _grade;
	}

	public void setGrade(double grade) {
		_grade = grade;
	}

	public BaseModel<?> getCourseStudentRemoteModel() {
		return _courseStudentRemoteModel;
	}

	public void setCourseStudentRemoteModel(
		BaseModel<?> courseStudentRemoteModel) {
		_courseStudentRemoteModel = courseStudentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseStudentLocalServiceUtil.addCourseStudent(this);
		}
		else {
			CourseStudentLocalServiceUtil.updateCourseStudent(this);
		}
	}

	@Override
	public CourseStudent toEscapedModel() {
		return (CourseStudent)Proxy.newProxyInstance(CourseStudent.class.getClassLoader(),
			new Class[] { CourseStudent.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseStudentClp clone = new CourseStudentClp();

		clone.setStudentId(getStudentId());
		clone.setCourseId(getCourseId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setGrade(getGrade());

		return clone;
	}

	public int compareTo(CourseStudent courseStudent) {
		CourseStudentPK primaryKey = courseStudent.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CourseStudentClp courseStudent = null;

		try {
			courseStudent = (CourseStudentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		CourseStudentPK primaryKey = courseStudent.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{studentId=");
		sb.append(getStudentId());
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", grade=");
		sb.append(getGrade());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.live.sb.demo.model.CourseStudent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
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
			"<column><column-name>grade</column-name><column-value><![CDATA[");
		sb.append(getGrade());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _studentId;
	private long _courseId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private double _grade;
	private BaseModel<?> _courseStudentRemoteModel;
}