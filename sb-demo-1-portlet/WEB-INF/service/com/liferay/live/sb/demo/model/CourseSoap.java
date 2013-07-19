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
public class CourseSoap implements Serializable {
	public static CourseSoap toSoapModel(Course model) {
		CourseSoap soapModel = new CourseSoap();

		soapModel.setCourseId(model.getCourseId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setInstructorId(model.getInstructorId());
		soapModel.setCourseCatalogId(model.getCourseCatalogId());
		soapModel.setCreditHours(model.getCreditHours());
		soapModel.setSemester(model.getSemester());
		soapModel.setYear(model.getYear());
		soapModel.setName(model.getName());
		soapModel.setMajor(model.getMajor());

		return soapModel;
	}

	public static CourseSoap[] toSoapModels(Course[] models) {
		CourseSoap[] soapModels = new CourseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseSoap[][] toSoapModels(Course[][] models) {
		CourseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseSoap[] toSoapModels(List<Course> models) {
		List<CourseSoap> soapModels = new ArrayList<CourseSoap>(models.size());

		for (Course model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseSoap[soapModels.size()]);
	}

	public CourseSoap() {
	}

	public long getPrimaryKey() {
		return _courseId;
	}

	public void setPrimaryKey(long pk) {
		setCourseId(pk);
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

	private long _courseId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _instructorId;
	private long _courseCatalogId;
	private int _creditHours;
	private int _semester;
	private int _year;
	private String _name;
	private String _major;
}