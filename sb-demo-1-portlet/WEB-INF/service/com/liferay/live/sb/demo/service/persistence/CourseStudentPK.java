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

package com.liferay.live.sb.demo.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author dnebinger
 */
public class CourseStudentPK implements Comparable<CourseStudentPK>,
	Serializable {
	public long studentId;
	public long courseId;

	public CourseStudentPK() {
	}

	public CourseStudentPK(long studentId, long courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public int compareTo(CourseStudentPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (studentId < pk.studentId) {
			value = -1;
		}
		else if (studentId > pk.studentId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (courseId < pk.courseId) {
			value = -1;
		}
		else if (courseId > pk.courseId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CourseStudentPK pk = null;

		try {
			pk = (CourseStudentPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((studentId == pk.studentId) && (courseId == pk.courseId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(studentId) + String.valueOf(courseId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("studentId");
		sb.append(StringPool.EQUAL);
		sb.append(studentId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("courseId");
		sb.append(StringPool.EQUAL);
		sb.append(courseId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}