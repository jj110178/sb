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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    dnebinger
 * @generated
 */
public class StudentGPASoap implements Serializable {
	public static StudentGPASoap toSoapModel(StudentGPA model) {
		StudentGPASoap soapModel = new StudentGPASoap();

		soapModel.setStudentId(model.getStudentId());
		soapModel.setName(model.getName());
		soapModel.setGradePoints(model.getGradePoints());
		soapModel.setYear(model.getYear());
		soapModel.setSemester(model.getSemester());
		soapModel.setCreditHours(model.getCreditHours());
		soapModel.setGpa(model.getGpa());
		soapModel.setLetterGrade(model.getLetterGrade());

		return soapModel;
	}

	public static StudentGPASoap[] toSoapModels(StudentGPA[] models) {
		StudentGPASoap[] soapModels = new StudentGPASoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentGPASoap[][] toSoapModels(StudentGPA[][] models) {
		StudentGPASoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentGPASoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentGPASoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentGPASoap[] toSoapModels(List<StudentGPA> models) {
		List<StudentGPASoap> soapModels = new ArrayList<StudentGPASoap>(models.size());

		for (StudentGPA model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentGPASoap[soapModels.size()]);
	}

	public StudentGPASoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public double getGradePoints() {
		return _gradePoints;
	}

	public void setGradePoints(double gradePoints) {
		_gradePoints = gradePoints;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public int getSemester() {
		return _semester;
	}

	public void setSemester(int semester) {
		_semester = semester;
	}

	public int getCreditHours() {
		return _creditHours;
	}

	public void setCreditHours(int creditHours) {
		_creditHours = creditHours;
	}

	public double getGpa() {
		return _gpa;
	}

	public void setGpa(double gpa) {
		_gpa = gpa;
	}

	public String getLetterGrade() {
		return _letterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		_letterGrade = letterGrade;
	}

	private long _studentId;
	private String _name;
	private double _gradePoints;
	private int _year;
	private int _semester;
	private int _creditHours;
	private double _gpa;
	private String _letterGrade;
}