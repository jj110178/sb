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

import com.liferay.live.sb.demo.model.Instructor;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Instructor in entity cache.
 *
 * @author dnebinger
 * @see Instructor
 * @generated
 */
public class InstructorCacheModel implements CacheModel<Instructor>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{instructorId=");
		sb.append(instructorId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", started=");
		sb.append(started);
		sb.append("}");

		return sb.toString();
	}

	public Instructor toEntityModel() {
		InstructorImpl instructorImpl = new InstructorImpl();

		instructorImpl.setInstructorId(instructorId);
		instructorImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			instructorImpl.setCreateDate(null);
		}
		else {
			instructorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			instructorImpl.setModifiedDate(null);
		}
		else {
			instructorImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			instructorImpl.setName(StringPool.BLANK);
		}
		else {
			instructorImpl.setName(name);
		}

		if (started == Long.MIN_VALUE) {
			instructorImpl.setStarted(null);
		}
		else {
			instructorImpl.setStarted(new Date(started));
		}

		instructorImpl.resetOriginalValues();

		return instructorImpl;
	}

	public long instructorId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long started;
}