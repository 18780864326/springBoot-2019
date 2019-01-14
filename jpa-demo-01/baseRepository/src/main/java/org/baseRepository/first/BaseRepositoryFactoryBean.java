package org.baseRepository.first;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.util.Assert;

/**
 * 
 * <p>自定义工厂</p>
 * <p>Description: </p>
 * <p>Copyright (c) 2019 LionCredo.All Rights Reserved.</p>
 * @author C3005890</a>
 */
public class BaseRepositoryFactoryBean<T extends  JpaRepository<S, ID>, S, ID extends Serializable> extends  JpaRepositoryFactoryBean<T, S, ID>{

	public BaseRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}
	@Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
        return new BaseRepositoryFactory(em);
    }
				//创建一个内部类，该类不用在外部访问
			    private static class BaseRepositoryFactory<T, I extends Serializable>
			            extends JpaRepositoryFactory {
			
			        private final EntityManager em;
			
			        public BaseRepositoryFactory(EntityManager em) {
			            super(em);
			            this.em = em;
			        }
			
			        //设置具体的实现类是BaseRepositoryImpl
			        @Override
			        protected JpaRepositoryImplementation<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
			            JpaEntityInformation<?, Serializable> entityInformation = this.getEntityInformation(information.getDomainType());
			            Object repository = this.getTargetRepositoryViaReflection(information, new Object[]{entityInformation, entityManager});
			            Assert.isInstanceOf(BaseRepositoryImpl.class, repository);
			            return (JpaRepositoryImplementation)repository;
			        }
			
			        //设置具体的实现类的class
			        @Override
			        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			            return BaseRepositoryImpl.class;
			        }
    }

}
