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

package com.liferay.live.sb.demo.service.persistence;

import com.liferay.live.sb.demo.model.CourseCatalog;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the course catalog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see CourseCatalogPersistenceImpl
 * @see CourseCatalogUtil
 * @generated
 */
public interface CourseCatalogPersistence extends BasePersistence<CourseCatalog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseCatalogUtil} to access the course catalog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the course catalog in the entity cache if it is enabled.
	*
	* @param courseCatalog the course catalog
	*/
	public void cacheResult(
		com.liferay.live.sb.demo.model.CourseCatalog courseCatalog);

	/**
	* Caches the course catalogs in the entity cache if it is enabled.
	*
	* @param courseCatalogs the course catalogs
	*/
	public void cacheResult(
		java.util.List<com.liferay.live.sb.demo.model.CourseCatalog> courseCatalogs);

	/**
	* Creates a new course catalog with the primary key. Does not add the course catalog to the database.
	*
	* @param courseCatalogId the primary key for the new course catalog
	* @return the new course catalog
	*/
	public com.liferay.live.sb.demo.model.CourseCatalog create(
		long courseCatalogId);

	/**
	* Removes the course catalog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseCatalogId the primary key of the course catalog
	* @return the course catalog that was removed
	* @throws com.liferay.live.sb.demo.NoSuchCourseCatalogException if a course catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseCatalog remove(
		long courseCatalogId)
		throws com.liferay.live.sb.demo.NoSuchCourseCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.live.sb.demo.model.CourseCatalog updateImpl(
		com.liferay.live.sb.demo.model.CourseCatalog courseCatalog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course catalog with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchCourseCatalogException} if it could not be found.
	*
	* @param courseCatalogId the primary key of the course catalog
	* @return the course catalog
	* @throws com.liferay.live.sb.demo.NoSuchCourseCatalogException if a course catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseCatalog findByPrimaryKey(
		long courseCatalogId)
		throws com.liferay.live.sb.demo.NoSuchCourseCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course catalog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseCatalogId the primary key of the course catalog
	* @return the course catalog, or <code>null</code> if a course catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseCatalog fetchByPrimaryKey(
		long courseCatalogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course catalogs.
	*
	* @return the course catalogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseCatalog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course catalogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of course catalogs
	* @param end the upper bound of the range of course catalogs (not inclusive)
	* @return the range of course catalogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseCatalog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course catalogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of course catalogs
	* @param end the upper bound of the range of course catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course catalogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseCatalog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course catalogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course catalogs.
	*
	* @return the number of course catalogs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}