package com.burnetzhong.repo;

import com.burnetzhong.domain.Swagger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Project: zhcore
 *
 * @Comments
 * @Author Zhong Han
 * @Created Date 2017/4/5
 */
@Repository
public interface SwaggerDocRepo extends CrudRepository<Swagger, String> {

    Swagger findByBasePath(String basePath);
}
