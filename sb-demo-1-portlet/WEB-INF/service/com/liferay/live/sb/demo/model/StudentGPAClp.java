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

import com.liferay.live.sb.demo.service.StudentGPALocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dnebinger
 */
public class StudentGPAClp extends BaseModelImpl<StudentGPA>
	implements StudentGPA {
	public StudentGPAClp() {
	}

	public Class<?> getModelClass() {
		return StudentGPA.class;
	}

	public String getModelClassName() {
		return StudentGPA.class.getName();
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
		attributes.put("name", getName());
		attributes.put("gradePoints", getGradePoints());
		attributes.put("year", getYear());
		attributes.put("semester", getSemester());
		attributes.put("creditHours", getCreditHours());
		attributes.put("gpa", getGpa());
		attributes.put("letterGrade", getLetterGrade());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double gradePoints = (Double)attributes.get("gradePoints");

		if (gradePoints != null) {
			setGradePoints(gradePoints);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Integer semester = (Integer)attributes.get("semester");

		if (semester != null) {
			setSemester(semester);
		}

		Integer creditHours = (Integer)attributes.get("creditHours");

		if (creditHours != null) {
			setCreditHours(creditHours);
		}

		Double gpa = (Double)attributes.get("gpa");

		if (gpa != null) {
			setGpa(gpa);
		}

		String letterGrade = (String)attributes.get("letterGrade");

		if (letterGrade != null) {
			setLetterGrade(letterGrade);
		}
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

	public BaseModel<?> getStudentGPARemoteModel() {
		return _studentGPARemoteModel;
	}

	public void setStudentGPARemoteModel(BaseModel<?> studentGPARemoteModel) {
		_studentGPARemoteModel = studentGPARemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			StudentGPALocalServiceUtil.addStudentGPA(this);
		}
		else {
			StudentGPALocalServiceUtil.updateStudentGPA(this);
		}
	}

	@Override
	public StudentGPA toEscapedModel() {
		return (StudentGPA)Proxy.newProxyInstance(StudentGPA.class.getClassLoader(),
			new Class[] { StudentGPA.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StudentGPAClp clone = new StudentGPAClp();

		clone.setStudentId(getStudentId());
		clone.setName(getName());
		clone.setGradePoints(getGradePoints());
		clone.setYear(getYear());
		clone.setSemester(getSemester());
		clone.setCreditHours(getCreditHours());
		clone.setGpa(getGpa());
		clone.setLetterGrade(getLetterGrade());

		return clone;
	}

	public int compareTo(StudentGPA studentGPA) {
		long primaryKey = studentGPA.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		StudentGPAClp studentGPA = null;

		try {
			studentGPA = (StudentGPAClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = studentGPA.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{studentId=");
		sb.append(getStudentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", gradePoints=");
		sb.append(getGradePoints());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", semester=");
		sb.append(getSemester());
		sb.append(", creditHours=");
		sb.append(getCreditHours());
		sb.append(", gpa=");
		sb.append(getGpa());
		sb.append(", letterGrade=");
		sb.append(getLetterGrade());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.live.sb.demo.model.StudentGPA");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gradePoints</column-name><column-value><![CDATA[");
		sb.append(getGradePoints());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>semester</column-name><column-value><![CDATA[");
		sb.append(getSemester());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditHours</column-name><column-value><![CDATA[");
		sb.append(getCreditHours());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gpa</column-name><column-value><![CDATA[");
		sb.append(getGpa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>letterGrade</column-name><column-value><![CDATA[");
		sb.append(getLetterGrade());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _studentId;
	private String _name;
	private double _gradePoints;
	private int _year;
	private int _semester;
	private int _creditHours;
	private double _gpa;
	private String _letterGrade;
	private BaseModel<?> _studentGPARemoteModel;
}