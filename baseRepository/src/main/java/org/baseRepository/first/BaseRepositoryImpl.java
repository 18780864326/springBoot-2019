package org.baseRepository.first;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {

	private final EntityManager entityManager;
		BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation,
	            EntityManager entityManager) {
	super(entityInformation, entityManager);
	this.entityManager = entityManager;
		}
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listBySqlToListObj(String sql) {
		  return entityManager.createNativeQuery(sql).getResultList();
	}

	@Override
	public Long getTableSequencesToLong(String sqlsequences) {
		String select = "select ";
		String nextval = ".NEXTVAL FROM DUAL";
		String sql = select+sqlsequences+nextval;
		Query query = entityManager.createNativeQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object> resultList = query.getResultList();
		Long Id = Long.valueOf(String.valueOf(resultList.get(0)));
		return Id;
	}

	@Override
	public List<T> listBySqlToListEntity(String sql, Class<T> resultClass) {
		Query query =  entityManager.createNativeQuery(sql, resultClass);
		@SuppressWarnings("unchecked")
		List<T> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public List<String> listBySqlAndOneColumnToListStr(String sql) {
		Query query  =	entityManager.createNativeQuery(sql);
		List<String> strList =query.getResultList();
		return strList;
	}

	@Override
	public List<Map<String, Object>> listBySqlToMap(String sql) {
		Query query  =	entityManager.createNativeQuery(sql);
		List<Map<String, Object>> resultList =	(List<Map<String, Object>>) query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return resultList;
	}

	@Override
	public Integer countBySqlToInteger(String sql) {
		String countStrStart ="select count(1) from ( ";
		String countStrEnd=" ) ";
		String countStr =countStrStart + sql +countStrEnd;
		Query query  =	entityManager.createNativeQuery(countStr);
		List<Object> strList =query.getResultList();
		Integer count = null;
		if(strList.get(0) != null) {
			count = Integer.valueOf( strList.get(0).toString())  ;			
		}
		return count;
	}

	@Override
	public List<Map<String, Object>> ListBySqlAndPageInfoToMap(String sql, Integer startIndex, Integer endIndex) {
		String PageStrStart ="select * from ( \r\n" + 
				"    select rownum rownumber ,t.* from (  ";
		String PageStrEnd = "  )t \r\n" + 
				"    )t \r\n" + 
				"  where t.rownumber <= "+ endIndex 
				+ " and t.rownumber >=" +  startIndex;
		Query query  =	entityManager.createNativeQuery(PageStrStart+sql+PageStrEnd);
		List<Map<String, Object>> resultList =	(List<Map<String, Object>>) query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return resultList;
	}

	@Override
	public List<?> ListBySqlToDto(String sql, Class<?> _class) {
		Session session = entityManager.unwrap(Session.class);
		List<?> resultList = (List<?>) session.createNativeQuery(sql).setResultTransformer( Transformers.aliasToBean( _class )).list();
		return resultList;
	}

	@Override
	public List<?> ListBySqlAndPageInfoToListDto(String sql, Integer startIndex, Integer endIndex, Class<?> _class) {
		Session session = entityManager.unwrap(Session.class);
		String PageStrStart ="select * from ( \r\n" + 
				"    select rownum rownumber ,t.* from (  ";
		String PageStrEnd = "  )t \r\n" + 
				"    )t \r\n" + 
				"  where t.rownumber <= "+ endIndex 
				+ " and t.rownumber >=" +  startIndex;
		List<?> resultList = (List<?>) session.createNativeQuery(PageStrStart+sql+PageStrEnd).setResultTransformer( Transformers.aliasToBean( _class )).list();
		return resultList;
	}

	@Override
	public List<T> listBySqlAndPageInfoToListEntity(String sql, Integer startIndex, Integer endIndex,
			Class<T> resultClass) {
		String PageStrStart ="select * from ( \r\n" + 
				"    select rownum rownumber ,t.* from (  ";
		String PageStrEnd = "  )t \r\n" + 
				"    )t \r\n" + 
				"  where t.rownumber <= "+ endIndex 
				+ " and t.rownumber >=" +  startIndex;
		Query query =  entityManager.createNativeQuery(PageStrStart+sql+PageStrEnd, resultClass);
		@SuppressWarnings("unchecked")
		List<T> resultList = query.getResultList();
		return resultList;
	}


}
