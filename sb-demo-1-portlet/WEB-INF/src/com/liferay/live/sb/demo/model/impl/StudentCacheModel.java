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

import com.liferay.live.sb.demo.model.Student;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author dnebinger
 * @see Student
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{studentId=");
		sb.append(studentId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", enrolled=");
		sb.append(enrolled);
		sb.append(", enrollmentDate=");
		sb.append(enrollmentDate);
		sb.append(", yearInSchool=");
		sb.append(yearInSchool);
		sb.append(", major=");
		sb.append(major);
		sb.append("}");

		return sb.toString();
	}

	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setStudentId(studentId);
		studentImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			studentImpl.setCreateDate(null);
		}
		else {
			studentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			studentImpl.setModifiedDate(null);
		}
		else {
			studentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			studentImpl.setName(StringPool.BLANK);
		}
		else {
			studentImpl.setName(name);
		}

		studentImpl.setEnrolled(enrolled);

		if (enrollmentDate == Long.MIN_VALUE) {
			studentImpl.setEnrollmentDate(null);
		}
		else {
			studentImpl.setEnrollmentDate(new Date(enrollmentDate));
		}

		studentImpl.setYearInSchool(yearInSchool);

		if (major == null) {
			studentImpl.setMajor(StringPool.BLANK);
		}
		else {
			studentImpl.setMajor(major);
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	public long studentId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public boolean enrolled;
	public long enrollmentDate;
	public int yearInSchool;
	public String major;
}