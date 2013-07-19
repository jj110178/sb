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
 * This class is a wrapper for {@link Instructor}.
 * </p>
 *
 * @author    dnebinger
 * @see       Instructor
 * @generated
 */
public class InstructorWrapper implements Instructor, ModelWrapper<Instructor> {
	public InstructorWrapper(Instructor instructor) {
		_instructor = instructor;
	}

	public Class<?> getModelClass() {
		return Instructor.class;
	}

	public String getModelClassName() {
		return Instructor.class.getName();
	}

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

	/**
	* Returns the primary key of this instructor.
	*
	* @return the primary key of this instructor
	*/
	public long getPrimaryKey() {
		return _instructor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this instructor.
	*
	* @param primaryKey the primary key of this instructor
	*/
	public void setPrimaryKey(long primaryKey) {
		_instructor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the instructor ID of this instructor.
	*
	* @return the instructor ID of this instructor
	*/
	public long getInstructorId() {
		return _instructor.getInstructorId();
	}

	/**
	* Sets the instructor ID of this instructor.
	*
	* @param instructorId the instructor ID of this instructor
	*/
	public void setInstructorId(long instructorId) {
		_instructor.setInstructorId(instructorId);
	}

	/**
	* Returns the user ID of this instructor.
	*
	* @return the user ID of this instructor
	*/
	public long getUserId() {
		return _instructor.getUserId();
	}

	/**
	* Sets the user ID of this instructor.
	*
	* @param userId the user ID of this instructor
	*/
	public void setUserId(long userId) {
		_instructor.setUserId(userId);
	}

	/**
	* Returns the user uuid of this instructor.
	*
	* @return the user uuid of this instructor
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instructor.getUserUuid();
	}

	/**
	* Sets the user uuid of this instructor.
	*
	* @param userUuid the user uuid of this instructor
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_instructor.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this instructor.
	*
	* @return the create date of this instructor
	*/
	public java.util.Date getCreateDate() {
		return _instructor.getCreateDate();
	}

	/**
	* Sets the create date of this instructor.
	*
	* @param createDate the create date of this instructor
	*/
	public void setCreateDate(java.util.Date createDate) {
		_instructor.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this instructor.
	*
	* @return the modified date of this instructor
	*/
	public java.util.Date getModifiedDate() {
		return _instructor.getModifiedDate();
	}

	/**
	* Sets the modified date of this instructor.
	*
	* @param modifiedDate the modified date of this instructor
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_instructor.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this instructor.
	*
	* @return the name of this instructor
	*/
	public java.lang.String getName() {
		return _instructor.getName();
	}

	/**
	* Sets the name of this instructor.
	*
	* @param name the name of this instructor
	*/
	public void setName(java.lang.String name) {
		_instructor.setName(name);
	}

	/**
	* Returns the started of this instructor.
	*
	* @return the started of this instructor
	*/
	public java.util.Date getStarted() {
		return _instructor.getStarted();
	}

	/**
	* Sets the started of this instructor.
	*
	* @param started the started of this instructor
	*/
	public void setStarted(java.util.Date started) {
		_instructor.setStarted(started);
	}

	public boolean isNew() {
		return _instructor.isNew();
	}

	public void setNew(boolean n) {
		_instructor.setNew(n);
	}

	public boolean isCachedModel() {
		return _instructor.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_instructor.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _instructor.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _instructor.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_instructor.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _instructor.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_instructor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InstructorWrapper((Instructor)_instructor.clone());
	}

	public int compareTo(com.liferay.live.sb.demo.model.Instructor instructor) {
		return _instructor.compareTo(instructor);
	}

	@Override
	public int hashCode() {
		return _instructor.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.live.sb.demo.model.Instructor> toCacheModel() {
		return _instructor.toCacheModel();
	}

	public com.liferay.live.sb.demo.model.Instructor toEscapedModel() {
		return new InstructorWrapper(_instructor.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _instructor.toString();
	}

	public java.lang.String toXmlString() {
		return _instructor.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_instructor.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Instructor getWrappedInstructor() {
		return _instructor;
	}

	public Instructor getWrappedModel() {
		return _instructor;
	}

	public void resetOriginalValues() {
		_instructor.resetOriginalValues();
	}

	private Instructor _instructor;
}