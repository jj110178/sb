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

import com.liferay.live.sb.demo.service.InstructorLocalServiceUtil;

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
public class InstructorClp extends BaseModelImpl<Instructor>
	implements Instructor {
	public InstructorClp() {
	}

	public Class<?> getModelClass() {
		return Instructor.class;
	}

	public String getModelClassName() {
		return Instructor.class.getName();
	}

	public long getPrimaryKey() {
		return _instructorId;
	}

	public void setPrimaryKey(long primaryKey) {
		setInstructorId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_instructorId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("instructorId", getInstructorId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("started", getStarted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long instructorId = (Long)attributes.get("instructorId");

		if (instructorId != null) {
			setInstructorId(instructorId);
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

		Date started = (Date)attributes.get("started");

		if (started != null) {
			setStarted(started);
		}
	}

	public long getInstructorId() {
		return _instructorId;
	}

	public void setInstructorId(long instructorId) {
		_instructorId = instructorId;
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

	public Date getStarted() {
		return _started;
	}

	public void setStarted(Date started) {
		_started = started;
	}

	public BaseModel<?> getInstructorRemoteModel() {
		return _instructorRemoteModel;
	}

	public void setInstructorRemoteModel(BaseModel<?> instructorRemoteModel) {
		_instructorRemoteModel = instructorRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			InstructorLocalServiceUtil.addInstructor(this);
		}
		else {
			InstructorLocalServiceUtil.updateInstructor(this);
		}
	}

	@Override
	public Instructor toEscapedModel() {
		return (Instructor)Proxy.newProxyInstance(Instructor.class.getClassLoader(),
			new Class[] { Instructor.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InstructorClp clone = new InstructorClp();

		clone.setInstructorId(getInstructorId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setStarted(getStarted());

		return clone;
	}

	public int compareTo(Instructor instructor) {
		long primaryKey = instructor.getPrimaryKey();

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

		InstructorClp instructor = null;

		try {
			instructor = (InstructorClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = instructor.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{instructorId=");
		sb.append(getInstructorId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", started=");
		sb.append(getStarted());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.live.sb.demo.model.Instructor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>instructorId</column-name><column-value><![CDATA[");
		sb.append(getInstructorId());
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
			"<column><column-name>started</column-name><column-value><![CDATA[");
		sb.append(getStarted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _instructorId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private Date _started;
	private BaseModel<?> _instructorRemoteModel;
}