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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StudentGPA}.
 * </p>
 *
 * @author    dnebinger
 * @see       StudentGPA
 * @generated
 */
public class StudentGPAWrapper implements StudentGPA, ModelWrapper<StudentGPA> {
	public StudentGPAWrapper(StudentGPA studentGPA) {
		_studentGPA = studentGPA;
	}

	public Class<?> getModelClass() {
		return StudentGPA.class;
	}

	public String getModelClassName() {
		return StudentGPA.class.getName();
	}

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

	/**
	* Returns the primary key of this student g p a.
	*
	* @return the primary key of this student g p a
	*/
	public long getPrimaryKey() {
		return _studentGPA.getPrimaryKey();
	}

	/**
	* Sets the primary key of this student g p a.
	*
	* @param primaryKey the primary key of this student g p a
	*/
	public void setPrimaryKey(long primaryKey) {
		_studentGPA.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the student ID of this student g p a.
	*
	* @return the student ID of this student g p a
	*/
	public long getStudentId() {
		return _studentGPA.getStudentId();
	}

	/**
	* Sets the student ID of this student g p a.
	*
	* @param studentId the student ID of this student g p a
	*/
	public void setStudentId(long studentId) {
		_studentGPA.setStudentId(studentId);
	}

	/**
	* Returns the name of this student g p a.
	*
	* @return the name of this student g p a
	*/
	public java.lang.String getName() {
		return _studentGPA.getName();
	}

	/**
	* Sets the name of this student g p a.
	*
	* @param name the name of this student g p a
	*/
	public void setName(java.lang.String name) {
		_studentGPA.setName(name);
	}

	/**
	* Returns the grade points of this student g p a.
	*
	* @return the grade points of this student g p a
	*/
	public double getGradePoints() {
		return _studentGPA.getGradePoints();
	}

	/**
	* Sets the grade points of this student g p a.
	*
	* @param gradePoints the grade points of this student g p a
	*/
	public void setGradePoints(double gradePoints) {
		_studentGPA.setGradePoints(gradePoints);
	}

	/**
	* Returns the year of this student g p a.
	*
	* @return the year of this student g p a
	*/
	public int getYear() {
		return _studentGPA.getYear();
	}

	/**
	* Sets the year of this student g p a.
	*
	* @param year the year of this student g p a
	*/
	public void setYear(int year) {
		_studentGPA.setYear(year);
	}

	/**
	* Returns the semester of this student g p a.
	*
	* @return the semester of this student g p a
	*/
	public int getSemester() {
		return _studentGPA.getSemester();
	}

	/**
	* Sets the semester of this student g p a.
	*
	* @param semester the semester of this student g p a
	*/
	public void setSemester(int semester) {
		_studentGPA.setSemester(semester);
	}

	/**
	* Returns the credit hours of this student g p a.
	*
	* @return the credit hours of this student g p a
	*/
	public int getCreditHours() {
		return _studentGPA.getCreditHours();
	}

	/**
	* Sets the credit hours of this student g p a.
	*
	* @param creditHours the credit hours of this student g p a
	*/
	public void setCreditHours(int creditHours) {
		_studentGPA.setCreditHours(creditHours);
	}

	/**
	* Returns the gpa of this student g p a.
	*
	* @return the gpa of this student g p a
	*/
	public double getGpa() {
		return _studentGPA.getGpa();
	}

	/**
	* Sets the gpa of this student g p a.
	*
	* @param gpa the gpa of this student g p a
	*/
	public void setGpa(double gpa) {
		_studentGPA.setGpa(gpa);
	}

	/**
	* Returns the letter grade of this student g p a.
	*
	* @return the letter grade of this student g p a
	*/
	public java.lang.String getLetterGrade() {
		return _studentGPA.getLetterGrade();
	}

	/**
	* Sets the letter grade of this student g p a.
	*
	* @param letterGrade the letter grade of this student g p a
	*/
	public void setLetterGrade(java.lang.String letterGrade) {
		_studentGPA.setLetterGrade(letterGrade);
	}

	public boolean isNew() {
		return _studentGPA.isNew();
	}

	public void setNew(boolean n) {
		_studentGPA.setNew(n);
	}

	public boolean isCachedModel() {
		return _studentGPA.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_studentGPA.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _studentGPA.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _studentGPA.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_studentGPA.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _studentGPA.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_studentGPA.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentGPAWrapper((StudentGPA)_studentGPA.clone());
	}

	public int compareTo(com.liferay.live.sb.demo.model.StudentGPA studentGPA) {
		return _studentGPA.compareTo(studentGPA);
	}

	@Override
	public int hashCode() {
		return _studentGPA.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.live.sb.demo.model.StudentGPA> toCacheModel() {
		return _studentGPA.toCacheModel();
	}

	public com.liferay.live.sb.demo.model.StudentGPA toEscapedModel() {
		return new StudentGPAWrapper(_studentGPA.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _studentGPA.toString();
	}

	public java.lang.String toXmlString() {
		return _studentGPA.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_studentGPA.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public StudentGPA getWrappedStudentGPA() {
		return _studentGPA;
	}

	public StudentGPA getWrappedModel() {
		return _studentGPA;
	}

	public void resetOriginalValues() {
		_studentGPA.resetOriginalValues();
	}

	private StudentGPA _studentGPA;
}