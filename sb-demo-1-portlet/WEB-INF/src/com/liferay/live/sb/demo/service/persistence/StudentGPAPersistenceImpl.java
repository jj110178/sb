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

import com.liferay.live.sb.demo.NoSuchStudentGPAException;
import com.liferay.live.sb.demo.model.StudentGPA;
import com.liferay.live.sb.demo.model.impl.StudentGPAImpl;
import com.liferay.live.sb.demo.model.impl.StudentGPAModelImpl;

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
 * The persistence implementation for the student g p a service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see StudentGPAPersistence
 * @see StudentGPAUtil
 * @generated
 */
public class StudentGPAPersistenceImpl extends BasePersistenceImpl<StudentGPA>
	implements StudentGPAPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentGPAUtil} to access the student g p a persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentGPAImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentGPAModelImpl.ENTITY_CACHE_ENABLED,
			StudentGPAModelImpl.FINDER_CACHE_ENABLED, StudentGPAImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentGPAModelImpl.ENTITY_CACHE_ENABLED,
			StudentGPAModelImpl.FINDER_CACHE_ENABLED, StudentGPAImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentGPAModelImpl.ENTITY_CACHE_ENABLED,
			StudentGPAModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the student g p a in the entity cache if it is enabled.
	 *
	 * @param studentGPA the student g p a
	 */
	public void cacheResult(StudentGPA studentGPA) {
		EntityCacheUtil.putResult(StudentGPAModelImpl.ENTITY_CACHE_ENABLED,
			StudentGPAImpl.class, studentGPA.getPrimaryKey(), studentGPA);

		studentGPA.resetOriginalValues();
	}

	/**
	 * Caches the student g p as in the entity cache if it is enabled.
	 *
	 * @param studentGPAs the student g p as
	 */
	public void cacheResult(List<StudentGPA> studentGPAs) {
		for (StudentGPA studentGPA : studentGPAs) {
			if (EntityCacheUtil.getResult(
						StudentGPAModelImpl.ENTITY_CACHE_ENABLED,
						StudentGPAImpl.class, studentGPA.getPrimaryKey()) == null) {
				cacheResult(studentGPA);
			}
			else {
				studentGPA.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all student g p as.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StudentGPAImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StudentGPAImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student g p a.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StudentGPA studentGPA) {
		EntityCacheUtil.removeResult(StudentGPAModelImpl.ENTITY_CACHE_ENABLED,
			StudentGPAImpl.class, studentGPA.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StudentGPA> studentGPAs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StudentGPA studentGPA : studentGPAs) {
			EntityCacheUtil.removeResult(StudentGPAModelImpl.ENTITY_CACHE_ENABLED,
				StudentGPAImpl.class, studentGPA.getPrimaryKey());
		}
	}

	/**
	 * Creates a new student g p a with the primary key. Does not add the student g p a to the database.
	 *
	 * @param studentId the primary key for the new student g p a
	 * @return the new student g p a
	 */
	public StudentGPA create(long studentId) {
		StudentGPA studentGPA = new StudentGPAImpl();

		studentGPA.setNew(true);
		studentGPA.setPrimaryKey(studentId);

		return studentGPA;
	}

	/**
	 * Removes the student g p a with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student g p a
	 * @return the student g p a that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchStudentGPAException if a student g p a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StudentGPA remove(long studentId)
		throws NoSuchStudentGPAException, SystemException {
		return remove(Long.valueOf(studentId));
	}

	/**
	 * Removes the student g p a with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student g p a
	 * @return the student g p a that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchStudentGPAException if a student g p a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentGPA remove(Serializable primaryKey)
		throws NoSuchStudentGPAException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StudentGPA studentGPA = (StudentGPA)session.get(StudentGPAImpl.class,
					primaryKey);

			if (studentGPA == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentGPAException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(studentGPA);
		}
		catch (NoSuchStudentGPAException nsee) {
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
	protected StudentGPA removeImpl(StudentGPA studentGPA)
		throws SystemException {
		studentGPA = toUnwrappedModel(studentGPA);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, studentGPA);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(studentGPA);

		return studentGPA;
	}

	@Override
	public StudentGPA updateImpl(
		com.liferay.live.sb.demo.model.StudentGPA studentGPA, boolean merge)
		throws SystemException {
		studentGPA = toUnwrappedModel(studentGPA);

		boolean isNew = studentGPA.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, studentGPA, merge);

			studentGPA.setNew(false);
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

		EntityCacheUtil.putResult(StudentGPAModelImpl.ENTITY_CACHE_ENABLED,
			StudentGPAImpl.class, studentGPA.getPrimaryKey(), studentGPA);

		return studentGPA;
	}

	protected StudentGPA toUnwrappedModel(StudentGPA studentGPA) {
		if (studentGPA instanceof StudentGPAImpl) {
			return studentGPA;
		}

		StudentGPAImpl studentGPAImpl = new StudentGPAImpl();

		studentGPAImpl.setNew(studentGPA.isNew());
		studentGPAImpl.setPrimaryKey(studentGPA.getPrimaryKey());

		studentGPAImpl.setStudentId(studentGPA.getStudentId());
		studentGPAImpl.setName(studentGPA.getName());
		studentGPAImpl.setGradePoints(studentGPA.getGradePoints());
		studentGPAImpl.setYear(studentGPA.getYear());
		studentGPAImpl.setSemester(studentGPA.getSemester());
		studentGPAImpl.setCreditHours(studentGPA.getCreditHours());
		studentGPAImpl.setGpa(studentGPA.getGpa());
		studentGPAImpl.setLetterGrade(studentGPA.getLetterGrade());

		return studentGPAImpl;
	}

	/**
	 * Returns the student g p a with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student g p a
	 * @return the student g p a
	 * @throws com.liferay.portal.NoSuchModelException if a student g p a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentGPA findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the student g p a with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchStudentGPAException} if it could not be found.
	 *
	 * @param studentId the primary key of the student g p a
	 * @return the student g p a
	 * @throws com.liferay.live.sb.demo.NoSuchStudentGPAException if a student g p a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StudentGPA findByPrimaryKey(long studentId)
		throws NoSuchStudentGPAException, SystemException {
		StudentGPA studentGPA = fetchByPrimaryKey(studentId);

		if (studentGPA == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + studentId);
			}

			throw new NoSuchStudentGPAException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				studentId);
		}

		return studentGPA;
	}

	/**
	 * Returns the student g p a with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student g p a
	 * @return the student g p a, or <code>null</code> if a student g p a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentGPA fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the student g p a with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student g p a
	 * @return the student g p a, or <code>null</code> if a student g p a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StudentGPA fetchByPrimaryKey(long studentId)
		throws SystemException {
		StudentGPA studentGPA = (StudentGPA)EntityCacheUtil.getResult(StudentGPAModelImpl.ENTITY_CACHE_ENABLED,
				StudentGPAImpl.class, studentId);

		if (studentGPA == _nullStudentGPA) {
			return null;
		}

		if (studentGPA == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				studentGPA = (StudentGPA)session.get(StudentGPAImpl.class,
						Long.valueOf(studentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (studentGPA != null) {
					cacheResult(studentGPA);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(StudentGPAModelImpl.ENTITY_CACHE_ENABLED,
						StudentGPAImpl.class, studentId, _nullStudentGPA);
				}

				closeSession(session);
			}
		}

		return studentGPA;
	}

	/**
	 * Returns all the student g p as.
	 *
	 * @return the student g p as
	 * @throws SystemException if a system exception occurred
	 */
	public List<StudentGPA> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student g p as.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of student g p as
	 * @param end the upper bound of the range of student g p as (not inclusive)
	 * @return the range of student g p as
	 * @throws SystemException if a system exception occurred
	 */
	public List<StudentGPA> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the student g p as.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of student g p as
	 * @param end the upper bound of the range of student g p as (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student g p as
	 * @throws SystemException if a system exception occurred
	 */
	public List<StudentGPA> findAll(int start, int end,
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

		List<StudentGPA> list = (List<StudentGPA>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDENTGPA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENTGPA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<StudentGPA>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<StudentGPA>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the student g p as from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (StudentGPA studentGPA : findAll()) {
			remove(studentGPA);
		}
	}

	/**
	 * Returns the number of student g p as.
	 *
	 * @return the number of student g p as
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENTGPA);

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
	 * Initializes the student g p a persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.live.sb.demo.model.StudentGPA")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StudentGPA>> listenersList = new ArrayList<ModelListener<StudentGPA>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StudentGPA>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StudentGPAImpl.class.getName());
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
	private static final String _SQL_SELECT_STUDENTGPA = "SELECT studentGPA FROM StudentGPA studentGPA";
	private static final String _SQL_COUNT_STUDENTGPA = "SELECT COUNT(studentGPA) FROM StudentGPA studentGPA";
	private static final String _ORDER_BY_ENTITY_ALIAS = "studentGPA.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StudentGPA exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StudentGPAPersistenceImpl.class);
	private static StudentGPA _nullStudentGPA = new StudentGPAImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StudentGPA> toCacheModel() {
				return _nullStudentGPACacheModel;
			}
		};

	private static CacheModel<StudentGPA> _nullStudentGPACacheModel = new CacheModel<StudentGPA>() {
			public StudentGPA toEntityModel() {
				return _nullStudentGPA;
			}
		};
}