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
public class CourseCatalogSoap implements Serializable {
	public static CourseCatalogSoap toSoapModel(CourseCatalog model) {
		CourseCatalogSoap soapModel = new CourseCatalogSoap();

		soapModel.setCourseCatalogId(model.getCourseCatalogId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setMajor(model.getMajor());
		soapModel.setCreditHours(model.getCreditHours());

		return soapModel;
	}

	public static CourseCatalogSoap[] toSoapModels(CourseCatalog[] models) {
		CourseCatalogSoap[] soapModels = new CourseCatalogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseCatalogSoap[][] toSoapModels(CourseCatalog[][] models) {
		CourseCatalogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseCatalogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseCatalogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseCatalogSoap[] toSoapModels(List<CourseCatalog> models) {
		List<CourseCatalogSoap> soapModels = new ArrayList<CourseCatalogSoap>(models.size());

		for (CourseCatalog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseCatalogSoap[soapModels.size()]);
	}

	public CourseCatalogSoap() {
	}

	public long getPrimaryKey() {
		return _courseCatalogId;
	}

	public void setPrimaryKey(long pk) {
		setCourseCatalogId(pk);
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

	private long _courseCatalogId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _major;
	private int _creditHours;
}