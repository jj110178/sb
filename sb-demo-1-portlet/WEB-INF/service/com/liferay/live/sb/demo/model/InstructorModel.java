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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Instructor service. Represents a row in the &quot;SBDemo_Instructor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.live.sb.demo.model.impl.InstructorModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.live.sb.demo.model.impl.InstructorImpl}.
 * </p>
 *
 * @author dnebinger
 * @see Instructor
 * @see com.liferay.live.sb.demo.model.impl.InstructorImpl
 * @see com.liferay.live.sb.demo.model.impl.InstructorModelImpl
 * @generated
 */
public interface InstructorModel extends BaseModel<Instructor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a instructor model instance should use the {@link Instructor} interface instead.
	 */

	/**
	 * Returns the primary key of this instructor.
	 *
	 * @return the primary key of this instructor
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this instructor.
	 *
	 * @param primaryKey the primary key of this instructor
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the instructor ID of this instructor.
	 *
	 * @return the instructor ID of this instructor
	 */
	public long getInstructorId();

	/**
	 * Sets the instructor ID of this instructor.
	 *
	 * @param instructorId the instructor ID of this instructor
	 */
	public void setInstructorId(long instructorId);

	/**
	 * Returns the user ID of this instructor.
	 *
	 * @return the user ID of this instructor
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this instructor.
	 *
	 * @param userId the user ID of this instructor
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this instructor.
	 *
	 * @return the user uuid of this instructor
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this instructor.
	 *
	 * @param userUuid the user uuid of this instructor
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this instructor.
	 *
	 * @return the create date of this instructor
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this instructor.
	 *
	 * @param createDate the create date of this instructor
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this instructor.
	 *
	 * @return the modified date of this instructor
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this instructor.
	 *
	 * @param modifiedDate the modified date of this instructor
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this instructor.
	 *
	 * @return the name of this instructor
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this instructor.
	 *
	 * @param name the name of this instructor
	 */
	public void setName(String name);

	/**
	 * Returns the started of this instructor.
	 *
	 * @return the started of this instructor
	 */
	public Date getStarted();

	/**
	 * Sets the started of this instructor.
	 *
	 * @param started the started of this instructor
	 */
	public void setStarted(Date started);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Instructor instructor);

	public int hashCode();

	public CacheModel<Instructor> toCacheModel();

	public Instructor toEscapedModel();

	public String toString();

	public String toXmlString();
}