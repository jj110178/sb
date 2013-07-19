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

import com.liferay.live.sb.demo.service.persistence.CourseStudentPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    dnebinger
 * @generated
 */
public class CourseStudentSoap implements Serializable {
	public static CourseStudentSoap toSoapModel(CourseStudent model) {
		CourseStudentSoap soapModel = new CourseStudentSoap();

		soapModel.setStudentId(model.getStudentId());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGrade(model.getGrade());

		return soapModel;
	}

	public static CourseStudentSoap[] toSoapModels(CourseStudent[] models) {
		CourseStudentSoap[] soapModels = new CourseStudentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseStudentSoap[][] toSoapModels(CourseStudent[][] models) {
		CourseStudentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseStudentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseStudentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseStudentSoap[] toSoapModels(List<CourseStudent> models) {
		List<CourseStudentSoap> soapModels = new ArrayList<CourseStudentSoap>(models.size());

		for (CourseStudent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseStudentSoap[soapModels.size()]);
	}

	public CourseStudentSoap() {
	}

	public CourseStudentPK getPrimaryKey() {
		return new CourseStudentPK(_studentId, _courseId);
	}

	public void setPrimaryKey(CourseStudentPK pk) {
		setStudentId(pk.studentId);
		setCourseId(pk.courseId);
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

	private long _studentId;
	private long _courseId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private double _grade;
}