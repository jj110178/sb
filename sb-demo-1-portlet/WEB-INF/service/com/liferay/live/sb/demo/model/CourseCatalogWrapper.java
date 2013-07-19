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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CourseCatalog}.
 * </p>
 *
 * @author    dnebinger
 * @see       CourseCatalog
 * @generated
 */
public class CourseCatalogWrapper implements CourseCatalog,
	ModelWrapper<CourseCatalog> {
	public CourseCatalogWrapper(CourseCatalog courseCatalog) {
		_courseCatalog = courseCatalog;
	}

	public Class<?> getModelClass() {
		return CourseCatalog.class;
	}

	public String getModelClassName() {
		return CourseCatalog.class.getName();
	}

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

	/**
	* Returns the primary key of this course catalog.
	*
	* @return the primary key of this course catalog
	*/
	public long getPrimaryKey() {
		return _courseCatalog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course catalog.
	*
	* @param primaryKey the primary key of this course catalog
	*/
	public void setPrimaryKey(long primaryKey) {
		_courseCatalog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the course catalog ID of this course catalog.
	*
	* @return the course catalog ID of this course catalog
	*/
	public long getCourseCatalogId() {
		return _courseCatalog.getCourseCatalogId();
	}

	/**
	* Sets the course catalog ID of this course catalog.
	*
	* @param courseCatalogId the course catalog ID of this course catalog
	*/
	public void setCourseCatalogId(long courseCatalogId) {
		_courseCatalog.setCourseCatalogId(courseCatalogId);
	}

	/**
	* Returns the user ID of this course catalog.
	*
	* @return the user ID of this course catalog
	*/
	public long getUserId() {
		return _courseCatalog.getUserId();
	}

	/**
	* Sets the user ID of this course catalog.
	*
	* @param userId the user ID of this course catalog
	*/
	public void setUserId(long userId) {
		_courseCatalog.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course catalog.
	*
	* @return the user uuid of this course catalog
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCatalog.getUserUuid();
	}

	/**
	* Sets the user uuid of this course catalog.
	*
	* @param userUuid the user uuid of this course catalog
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_courseCatalog.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this course catalog.
	*
	* @return the create date of this course catalog
	*/
	public java.util.Date getCreateDate() {
		return _courseCatalog.getCreateDate();
	}

	/**
	* Sets the create date of this course catalog.
	*
	* @param createDate the create date of this course catalog
	*/
	public void setCreateDate(java.util.Date createDate) {
		_courseCatalog.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course catalog.
	*
	* @return the modified date of this course catalog
	*/
	public java.util.Date getModifiedDate() {
		return _courseCatalog.getModifiedDate();
	}

	/**
	* Sets the modified date of this course catalog.
	*
	* @param modifiedDate the modified date of this course catalog
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseCatalog.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this course catalog.
	*
	* @return the name of this course catalog
	*/
	public java.lang.String getName() {
		return _courseCatalog.getName();
	}

	/**
	* Sets the name of this course catalog.
	*
	* @param name the name of this course catalog
	*/
	public void setName(java.lang.String name) {
		_courseCatalog.setName(name);
	}

	/**
	* Returns the description of this course catalog.
	*
	* @return the description of this course catalog
	*/
	public java.lang.String getDescription() {
		return _courseCatalog.getDescription();
	}

	/**
	* Sets the description of this course catalog.
	*
	* @param description the description of this course catalog
	*/
	public void setDescription(java.lang.String description) {
		_courseCatalog.setDescription(description);
	}

	/**
	* Returns the major of this course catalog.
	*
	* @return the major of this course catalog
	*/
	public java.lang.String getMajor() {
		return _courseCatalog.getMajor();
	}

	/**
	* Sets the major of this course catalog.
	*
	* @param major the major of this course catalog
	*/
	public void setMajor(java.lang.String major) {
		_courseCatalog.setMajor(major);
	}

	/**
	* Returns the credit hours of this course catalog.
	*
	* @return the credit hours of this course catalog
	*/
	public int getCreditHours() {
		return _courseCatalog.getCreditHours();
	}

	/**
	* Sets the credit hours of this course catalog.
	*
	* @param creditHours the credit hours of this course catalog
	*/
	public void setCreditHours(int creditHours) {
		_courseCatalog.setCreditHours(creditHours);
	}

	public boolean isNew() {
		return _courseCatalog.isNew();
	}

	public void setNew(boolean n) {
		_courseCatalog.setNew(n);
	}

	public boolean isCachedModel() {
		return _courseCatalog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_courseCatalog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _courseCatalog.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _courseCatalog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseCatalog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseCatalog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseCatalog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseCatalogWrapper((CourseCatalog)_courseCatalog.clone());
	}

	public int compareTo(
		com.liferay.live.sb.demo.model.CourseCatalog courseCatalog) {
		return _courseCatalog.compareTo(courseCatalog);
	}

	@Override
	public int hashCode() {
		return _courseCatalog.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.live.sb.demo.model.CourseCatalog> toCacheModel() {
		return _courseCatalog.toCacheModel();
	}

	public com.liferay.live.sb.demo.model.CourseCatalog toEscapedModel() {
		return new CourseCatalogWrapper(_courseCatalog.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseCatalog.toString();
	}

	public java.lang.String toXmlString() {
		return _courseCatalog.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseCatalog.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CourseCatalog getWrappedCourseCatalog() {
		return _courseCatalog;
	}

	public CourseCatalog getWrappedModel() {
		return _courseCatalog;
	}

	public void resetOriginalValues() {
		_courseCatalog.resetOriginalValues();
	}

	private CourseCatalog _courseCatalog;
}