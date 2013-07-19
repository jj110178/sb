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
public class StudentSoap implements Serializable {
	public static StudentSoap toSoapModel(Student model) {
		StudentSoap soapModel = new StudentSoap();

		soapModel.setStudentId(model.getStudentId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setEnrolled(model.getEnrolled());
		soapModel.setEnrollmentDate(model.getEnrollmentDate());
		soapModel.setYearInSchool(model.getYearInSchool());
		soapModel.setMajor(model.getMajor());

		return soapModel;
	}

	public static StudentSoap[] toSoapModels(Student[] models) {
		StudentSoap[] soapModels = new StudentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[][] toSoapModels(Student[][] models) {
		StudentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[] toSoapModels(List<Student> models) {
		List<StudentSoap> soapModels = new ArrayList<StudentSoap>(models.size());

		for (Student model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentSoap[soapModels.size()]);
	}

	public StudentSoap() {
	}

	public long getPrimaryKey() {
		return _studentId;
	}

	public void setPrimaryKey(long pk) {
		setStudentId(pk);
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

	private long _studentId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private boolean _enrolled;
	private Date _enrollmentDate;
	private int _yearInSchool;
	private String _major;
}