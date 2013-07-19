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

package com.liferay.live.sb.demo.model.impl;

import com.liferay.live.sb.demo.model.StudentGPA;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing StudentGPA in entity cache.
 *
 * @author dnebinger
 * @see StudentGPA
 * @generated
 */
public class StudentGPACacheModel implements CacheModel<StudentGPA>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{studentId=");
		sb.append(studentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", gradePoints=");
		sb.append(gradePoints);
		sb.append(", year=");
		sb.append(year);
		sb.append(", semester=");
		sb.append(semester);
		sb.append(", creditHours=");
		sb.append(creditHours);
		sb.append(", gpa=");
		sb.append(gpa);
		sb.append(", letterGrade=");
		sb.append(letterGrade);
		sb.append("}");

		return sb.toString();
	}

	public StudentGPA toEntityModel() {
		StudentGPAImpl studentGPAImpl = new StudentGPAImpl();

		studentGPAImpl.setStudentId(studentId);

		if (name == null) {
			studentGPAImpl.setName(StringPool.BLANK);
		}
		else {
			studentGPAImpl.setName(name);
		}

		studentGPAImpl.setGradePoints(gradePoints);
		studentGPAImpl.setYear(year);
		studentGPAImpl.setSemester(semester);
		studentGPAImpl.setCreditHours(creditHours);
		studentGPAImpl.setGpa(gpa);

		if (letterGrade == null) {
			studentGPAImpl.setLetterGrade(StringPool.BLANK);
		}
		else {
			studentGPAImpl.setLetterGrade(letterGrade);
		}

		studentGPAImpl.resetOriginalValues();

		return studentGPAImpl;
	}

	public long studentId;
	public String name;
	public double gradePoints;
	public int year;
	public int semester;
	public int creditHours;
	public double gpa;
	public String letterGrade;
}