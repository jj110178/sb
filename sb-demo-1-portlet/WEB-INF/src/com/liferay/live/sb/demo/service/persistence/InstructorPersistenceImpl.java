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

import com.liferay.live.sb.demo.NoSuchInstructorException;
import com.liferay.live.sb.demo.model.Instructor;
import com.liferay.live.sb.demo.model.impl.InstructorImpl;
import com.liferay.live.sb.demo.model.impl.InstructorModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the instructor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see InstructorPersistence
 * @see InstructorUtil
 * @generated
 */
public class InstructorPersistenceImpl extends BasePersistenceImpl<Instructor>
	implements InstructorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InstructorUtil} to access the instructor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InstructorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InstructorModelImpl.ENTITY_CACHE_ENABLED,
			InstructorModelImpl.FINDER_CACHE_ENABLED, InstructorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InstructorModelImpl.ENTITY_CACHE_ENABLED,
			InstructorModelImpl.FINDER_CACHE_ENABLED, InstructorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InstructorModelImpl.ENTITY_CACHE_ENABLED,
			InstructorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the instructor in the entity cache if it is enabled.
	 *
	 * @param instructor the instructor
	 */
	public void cacheResult(Instructor instructor) {
		EntityCacheUtil.putResult(InstructorModelImpl.ENTITY_CACHE_ENABLED,
			InstructorImpl.class, instructor.getPrimaryKey(), instructor);

		instructor.resetOriginalValues();
	}

	/**
	 * Caches the instructors in the entity cache if it is enabled.
	 *
	 * @param instructors the instructors
	 */
	public void cacheResult(List<Instructor> instructors) {
		for (Instructor instructor : instructors) {
			if (EntityCacheUtil.getResult(
						InstructorModelImpl.ENTITY_CACHE_ENABLED,
						InstructorImpl.class, instructor.getPrimaryKey()) == null) {
				cacheResult(instructor);
			}
			else {
				instructor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all instructors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InstructorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InstructorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the instructor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Instructor instructor) {
		EntityCacheUtil.removeResult(InstructorModelImpl.ENTITY_CACHE_ENABLED,
			InstructorImpl.class, instructor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Instructor> instructors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Instructor instructor : instructors) {
			EntityCacheUtil.removeResult(InstructorModelImpl.ENTITY_CACHE_ENABLED,
				InstructorImpl.class, instructor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new instructor with the primary key. Does not add the instructor to the database.
	 *
	 * @param instructorId the primary key for the new instructor
	 * @return the new instructor
	 */
	public Instructor create(long instructorId) {
		Instructor instructor = new InstructorImpl();

		instructor.setNew(true);
		instructor.setPrimaryKey(instructorId);

		return instructor;
	}

	/**
	 * Removes the instructor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instructorId the primary key of the instructor
	 * @return the instructor that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchInstructorException if a instructor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Instructor remove(long instructorId)
		throws NoSuchInstructorException, SystemException {
		return remove(Long.valueOf(instructorId));
	}

	/**
	 * Removes the instructor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the instructor
	 * @return the instructor that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchInstructorException if a instructor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Instructor remove(Serializable primaryKey)
		throws NoSuchInstructorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Instructor instructor = (Instructor)session.get(InstructorImpl.class,
					primaryKey);

			if (instructor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInstructorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(instructor);
		}
		catch (NoSuchInstructorException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Instructor removeImpl(Instructor instructor)
		throws SystemException {
		instructor = toUnwrappedModel(instructor);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, instructor);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(instructor);

		return instructor;
	}

	@Override
	public Instructor updateImpl(
		com.liferay.live.sb.demo.model.Instructor instructor, boolean merge)
		throws SystemException {
		instructor = toUnwrappedModel(instructor);

		boolean isNew = instructor.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, instructor, merge);

			instructor.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(InstructorModelImpl.ENTITY_CACHE_ENABLED,
			InstructorImpl.class, instructor.getPrimaryKey(), instructor);

		return instructor;
	}

	protected Instructor toUnwrappedModel(Instructor instructor) {
		if (instructor instanceof InstructorImpl) {
			return instructor;
		}

		InstructorImpl instructorImpl = new InstructorImpl();

		instructorImpl.setNew(instructor.isNew());
		instructorImpl.setPrimaryKey(instructor.getPrimaryKey());

		instructorImpl.setInstructorId(instructor.getInstructorId());
		instructorImpl.setUserId(instructor.getUserId());
		instructorImpl.setCreateDate(instructor.getCreateDate());
		instructorImpl.setModifiedDate(instructor.getModifiedDate());
		instructorImpl.setName(instructor.getName());
		instructorImpl.setStarted(instructor.getStarted());

		return instructorImpl;
	}

	/**
	 * Returns the instructor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the instructor
	 * @return the instructor
	 * @throws com.liferay.portal.NoSuchModelException if a instructor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Instructor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the instructor with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchInstructorException} if it could not be found.
	 *
	 * @param instructorId the primary key of the instructor
	 * @return the instructor
	 * @throws com.liferay.live.sb.demo.NoSuchInstructorException if a instructor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Instructor findByPrimaryKey(long instructorId)
		throws NoSuchInstructorException, SystemException {
		Instructor instructor = fetchByPrimaryKey(instructorId);

		if (instructor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + instructorId);
			}

			throw new NoSuchInstructorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				instructorId);
		}

		return instructor;
	}

	/**
	 * Returns the instructor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the instructor
	 * @return the instructor, or <code>null</code> if a instructor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Instructor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the instructor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param instructorId the primary key of the instructor
	 * @return the instructor, or <code>null</code> if a instructor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Instructor fetchByPrimaryKey(long instructorId)
		throws SystemException {
		Instructor instructor = (Instructor)EntityCacheUtil.getResult(InstructorModelImpl.ENTITY_CACHE_ENABLED,
				InstructorImpl.class, instructorId);

		if (instructor == _nullInstructor) {
			return null;
		}

		if (instructor == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				instructor = (Instructor)session.get(InstructorImpl.class,
						Long.valueOf(instructorId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (instructor != null) {
					cacheResult(instructor);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(InstructorModelImpl.ENTITY_CACHE_ENABLED,
						InstructorImpl.class, instructorId, _nullInstructor);
				}

				closeSession(session);
			}
		}

		return instructor;
	}

	/**
	 * Returns all the instructors.
	 *
	 * @return the instructors
	 * @throws SystemException if a system exception occurred
	 */
	public List<Instructor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the instructors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of instructors
	 * @param end the upper bound of the range of instructors (not inclusive)
	 * @return the range of instructors
	 * @throws SystemException if a system exception occurred
	 */
	public List<Instructor> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the instructors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of instructors
	 * @param end the upper bound of the range of instructors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of instructors
	 * @throws SystemException if a system exception occurred
	 */
	public List<Instructor> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Instructor> list = (List<Instructor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INSTRUCTOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INSTRUCTOR;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Instructor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Instructor>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the instructors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Instructor instructor : findAll()) {
			remove(instructor);
		}
	}

	/**
	 * Returns the number of instructors.
	 *
	 * @return the number of instructors
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INSTRUCTOR);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the instructor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.live.sb.demo.model.Instructor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Instructor>> listenersList = new ArrayList<ModelListener<Instructor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Instructor>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(InstructorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = CourseCatalogPersistence.class)
	protected CourseCatalogPersistence courseCatalogPersistence;
	@BeanReference(type = CourseStudentPersistence.class)
	protected CourseStudentPersistence courseStudentPersistence;
	@BeanReference(type = InstructorPersistence.class)
	protected InstructorPersistence instructorPersistence;
	@BeanReference(type = StudentPersistence.class)
	protected StudentPersistence studentPersistence;
	@BeanReference(type = StudentGPAPersistence.class)
	protected StudentGPAPersistence studentGPAPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_INSTRUCTOR = "SELECT instructor FROM Instructor instructor";
	private static final String _SQL_COUNT_INSTRUCTOR = "SELECT COUNT(instructor) FROM Instructor instructor";
	private static final String _ORDER_BY_ENTITY_ALIAS = "instructor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Instructor exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InstructorPersistenceImpl.class);
	private static Instructor _nullInstructor = new InstructorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Instructor> toCacheModel() {
				return _nullInstructorCacheModel;
			}
		};

	private static CacheModel<Instructor> _nullInstructorCacheModel = new CacheModel<Instructor>() {
			public Instructor toEntityModel() {
				return _nullInstructor;
			}
		};
}