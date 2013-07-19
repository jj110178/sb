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
import com.liferay.live.sb.demo.model.CourseCatalogModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CourseCatalog service. Represents a row in the &quot;COURSE_CATALOG&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.live.sb.demo.model.CourseCatalogModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CourseCatalogImpl}.
 * </p>
 *
 * @author dnebinger
 * @see CourseCatalogImpl
 * @see com.liferay.live.sb.demo.model.CourseCatalog
 * @see com.liferay.live.sb.demo.model.CourseCatalogModel
 * @generated
 */
public class CourseCatalogModelImpl extends BaseModelImpl<CourseCatalog>
	implements CourseCatalogModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a course catalog model instance should use the {@link com.liferay.live.sb.demo.model.CourseCatalog} interface instead.
	 */
	public static final String TABLE_NAME = "COURSE_CATALOG";
	public static final Object[][] TABLE_COLUMNS = {
			{ "CC_ID", Types.BIGINT },
			{ "U_ID", Types.BIGINT },
			{ "CREATED", Types.TIMESTAMP },
			{ "MODIFIED", Types.TIMESTAMP },
			{ "C_NAME", Types.VARCHAR },
			{ "C_DESC", Types.VARCHAR },
			{ "C_MAJOR", Types.VARCHAR },
			{ "CRED_HRS", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table COURSE_CATALOG (CC_ID LONG not null primary key,U_ID LONG,CREATED DATE null,MODIFIED DATE null,C_NAME VARCHAR(75) null,C_DESC VARCHAR(75) null,C_MAJOR VARCHAR(75) null,CRED_HRS INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table COURSE_CATALOG";
	public static final String ORDER_BY_JPQL = " ORDER BY courseCatalog.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY COURSE_CATALOG.C_NAME ASC";
	public static final String DATA_SOURCE = "demo2DataSource";
	public static final String SESSION_FACTORY = "demo2SessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.live.sb.demo.model.CourseCatalog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.live.sb.demo.model.CourseCatalog"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.live.sb.demo.model.CourseCatalog"));

	public CourseCatalogModelImpl() {
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

	public Class<?> getModelClass() {
		return CourseCatalog.class;
	}

	public String getModelClassName() {
		return CourseCatalog.class.getName();
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
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getMajor() {
		if (_major == null) {
			return StringPool.BLANK;
		}
		else {
			return _major;
		}
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

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CourseCatalog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CourseCatalog toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (CourseCatalog)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CourseCatalogImpl courseCatalogImpl = new CourseCatalogImpl();

		courseCatalogImpl.setCourseCatalogId(getCourseCatalogId());
		courseCatalogImpl.setUserId(getUserId());
		courseCatalogImpl.setCreateDate(getCreateDate());
		courseCatalogImpl.setModifiedDate(getModifiedDate());
		courseCatalogImpl.setName(getName());
		courseCatalogImpl.setDescription(getDescription());
		courseCatalogImpl.setMajor(getMajor());
		courseCatalogImpl.setCreditHours(getCreditHours());

		courseCatalogImpl.resetOriginalValues();

		return courseCatalogImpl;
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

		CourseCatalog courseCatalog = null;

		try {
			courseCatalog = (CourseCatalog)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<CourseCatalog> toCacheModel() {
		CourseCatalogCacheModel courseCatalogCacheModel = new CourseCatalogCacheModel();

		courseCatalogCacheModel.courseCatalogId = getCourseCatalogId();

		courseCatalogCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			courseCatalogCacheModel.createDate = createDate.getTime();
		}
		else {
			courseCatalogCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			courseCatalogCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			courseCatalogCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		courseCatalogCacheModel.name = getName();

		String name = courseCatalogCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			courseCatalogCacheModel.name = null;
		}

		courseCatalogCacheModel.description = getDescription();

		String description = courseCatalogCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			courseCatalogCacheModel.description = null;
		}

		courseCatalogCacheModel.major = getMajor();

		String major = courseCatalogCacheModel.major;

		if ((major != null) && (major.length() == 0)) {
			courseCatalogCacheModel.major = null;
		}

		courseCatalogCacheModel.creditHours = getCreditHours();

		return courseCatalogCacheModel;
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

	private static ClassLoader _classLoader = CourseCatalog.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			CourseCatalog.class
		};
	private long _courseCatalogId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _major;
	private int _creditHours;
	private CourseCatalog _escapedModelProxy;
}