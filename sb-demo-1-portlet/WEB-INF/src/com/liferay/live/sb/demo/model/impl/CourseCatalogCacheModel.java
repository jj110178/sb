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

import com.liferay.live.sb.demo.model.CourseCatalog;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CourseCatalog in entity cache.
 *
 * @author dnebinger
 * @see CourseCatalog
 * @generated
 */
public class CourseCatalogCacheModel implements CacheModel<CourseCatalog>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{courseCatalogId=");
		sb.append(courseCatalogId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", major=");
		sb.append(major);
		sb.append(", creditHours=");
		sb.append(creditHours);
		sb.append("}");

		return sb.toString();
	}

	public CourseCatalog toEntityModel() {
		CourseCatalogImpl courseCatalogImpl = new CourseCatalogImpl();

		courseCatalogImpl.setCourseCatalogId(courseCatalogId);
		courseCatalogImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			courseCatalogImpl.setCreateDate(null);
		}
		else {
			courseCatalogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseCatalogImpl.setModifiedDate(null);
		}
		else {
			courseCatalogImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			courseCatalogImpl.setName(StringPool.BLANK);
		}
		else {
			courseCatalogImpl.setName(name);
		}

		if (description == null) {
			courseCatalogImpl.setDescription(StringPool.BLANK);
		}
		else {
			courseCatalogImpl.setDescription(description);
		}

		if (major == null) {
			courseCatalogImpl.setMajor(StringPool.BLANK);
		}
		else {
			courseCatalogImpl.setMajor(major);
		}

		courseCatalogImpl.setCreditHours(creditHours);

		courseCatalogImpl.resetOriginalValues();

		return courseCatalogImpl;
	}

	public long courseCatalogId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String major;
	public int creditHours;
}