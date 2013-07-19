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

import com.liferay.live.sb.demo.model.CourseStudent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CourseStudent in entity cache.
 *
 * @author dnebinger
 * @see CourseStudent
 * @generated
 */
public class CourseStudentCacheModel implements CacheModel<CourseStudent>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{studentId=");
		sb.append(studentId);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", grade=");
		sb.append(grade);
		sb.append("}");

		return sb.toString();
	}

	public CourseStudent toEntityModel() {
		CourseStudentImpl courseStudentImpl = new CourseStudentImpl();

		courseStudentImpl.setStudentId(studentId);
		courseStudentImpl.setCourseId(courseId);
		courseStudentImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			courseStudentImpl.setCreateDate(null);
		}
		else {
			courseStudentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseStudentImpl.setModifiedDate(null);
		}
		else {
			courseStudentImpl.setModifiedDate(new Date(modifiedDate));
		}

		courseStudentImpl.setGrade(grade);

		courseStudentImpl.resetOriginalValues();

		return courseStudentImpl;
	}

	public long studentId;
	public long courseId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public double grade;
}