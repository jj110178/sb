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

import com.liferay.live.sb.demo.service.CourseCatalogLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dnebinger
 */
public class CourseCatalogClp extends BaseModelImpl<CourseCatalog>
	implements CourseCatalog {
	public CourseCatalogClp() {
	}

	public Class<?> getModelClass() {
		return CourseCatalog.class;
	}

	public String getModelClassName() {
		return CourseCatalog.class.getName();
	}

	public long getPrimaryKey() {
		return _courseCatalogId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCourseCatalogId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_courseCatalogId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("courseCatalogId", getCourseCatalogId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("major", getMajor());
		attributes.put("creditHours", getCreditHours());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long courseCatalogId = (Long)attributes.get("courseCatalogId");

		if (courseCatalogId != null) {
			setCourseCatalogId(courseCatalogId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String major = (String)attributes.get("major");

		if (major != null) {
			setMajor(major);
		}

		Integer creditHours = (Integer)attributes.get("creditHours");

		if (creditHours != null) {
			setCreditHours(creditHours);
		}
	}

	public long getCourseCatalogId() {
		return _courseCatalogId;
	}

	public void setCourseCatalogId(long courseCatalogId) {
		_courseCatalogId = courseCatalogId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getMajor() {
		return _major;
	}

	public void setMajor(String major) {
		_major = major;
	}

	public int getCreditHours() {
		return _creditHours;
	}

	public void setCreditHours(int creditHours) {
		_creditHours = creditHours;
	}

	public BaseModel<?> getCourseCatalogRemoteModel() {
		return _courseCatalogRemoteModel;
	}

	public void setCourseCatalogRemoteModel(
		BaseModel<?> courseCatalogRemoteModel) {
		_courseCatalogRemoteModel = courseCatalogRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseCatalogLocalServiceUtil.addCourseCatalog(this);
		}
		else {
			CourseCatalogLocalServiceUtil.updateCourseCatalog(this);
		}
	}

	@Override
	public CourseCatalog toEscapedModel() {
		return (CourseCatalog)Proxy.newProxyInstance(CourseCatalog.class.getClassLoader(),
			new Class[] { CourseCatalog.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseCatalogClp clone = new CourseCatalogClp();

		clone.setCourseCatalogId(getCourseCatalogId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setMajor(getMajor());
		clone.setCreditHours(getCreditHours());

		return clone;
	}

	public int compareTo(CourseCatalog courseCatalog) {
		int value = 0;

		value = getName().compareTo(courseCatalog.getName());

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

		CourseCatalogClp courseCatalog = null;

		try {
			courseCatalog = (CourseCatalogClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = courseCatalog.getPrimaryKey();

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

		sb.append("{courseCatalogId=");
		sb.append(getCourseCatalogId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", major=");
		sb.append(getMajor());
		sb.append(", creditHours=");
		sb.append(getCreditHours());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.live.sb.demo.model.CourseCatalog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>courseCatalogId</column-name><column-value><![CDATA[");
		sb.append(getCourseCatalogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>major</column-name><column-value><![CDATA[");
		sb.append(getMajor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditHours</column-name><column-value><![CDATA[");
		sb.append(getCreditHours());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _courseCatalogId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _major;
	private int _creditHours;
	private BaseModel<?> _courseCatalogRemoteModel;
}