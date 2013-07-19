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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    dnebinger
 * @generated
 */
public class InstructorSoap implements Serializable {
	public static InstructorSoap toSoapModel(Instructor model) {
		InstructorSoap soapModel = new InstructorSoap();

		soapModel.setInstructorId(model.getInstructorId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setStarted(model.getStarted());

		return soapModel;
	}

	public static InstructorSoap[] toSoapModels(Instructor[] models) {
		InstructorSoap[] soapModels = new InstructorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InstructorSoap[][] toSoapModels(Instructor[][] models) {
		InstructorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InstructorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InstructorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InstructorSoap[] toSoapModels(List<Instructor> models) {
		List<InstructorSoap> soapModels = new ArrayList<InstructorSoap>(models.size());

		for (Instructor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InstructorSoap[soapModels.size()]);
	}

	public InstructorSoap() {
	}

	public long getPrimaryKey() {
		return _instructorId;
	}

	public void setPrimaryKey(long pk) {
		setInstructorId(pk);
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

	private long _instructorId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private Date _started;
}