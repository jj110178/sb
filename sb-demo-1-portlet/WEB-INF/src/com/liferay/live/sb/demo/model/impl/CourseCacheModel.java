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

import com.liferay.live.sb.demo.model.Course;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Course in entity cache.
 *
 * @author dnebinger
 * @see Course
 * @generated
 */
public class CourseCacheModel implements CacheModel<Course>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{courseId=");
		sb.append(courseId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", instructorId=");
		sb.append(instructorId);
		sb.append(", courseCatalogId=");
		sb.append(courseCatalogId);
		sb.append(", creditHours=");
		sb.append(creditHours);
		sb.append(", semester=");
		sb.append(semester);
		sb.append(", year=");
		sb.append(year);
		sb.append(", name=");
		sb.append(name);
		sb.append(", major=");
		sb.append(major);
		sb.append("}");

		return sb.toString();
	}

	public Course toEntityModel() {
		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setCourseId(courseId);
		courseImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			courseImpl.setCreateDate(null);
		}
		else {
			courseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseImpl.setModifiedDate(null);
		}
		else {
			courseImpl.setModifiedDate(new Date(modifiedDate));
		}

		courseImpl.setInstructorId(instructorId);
		courseImpl.setCourseCatalogId(courseCatalogId);
		courseImpl.setCreditHours(creditHours);
		courseImpl.setSemester(semester);
		courseImpl.setYear(year);

		if (name == null) {
			courseImpl.setName(StringPool.BLANK);
		}
		else {
			courseImpl.setName(name);
		}

		if (major == null) {
			courseImpl.setMajor(StringPool.BLANK);
		}
		else {
			courseImpl.setMajor(major);
		}

		courseImpl.resetOriginalValues();

		return courseImpl;
	}

	public long courseId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long instructorId;
	public long courseCatalogId;
	public int creditHours;
	public int semester;
	public int year;
	public String name;
	public String major;
}