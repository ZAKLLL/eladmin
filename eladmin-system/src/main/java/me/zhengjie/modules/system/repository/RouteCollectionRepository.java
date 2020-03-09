package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.RouteCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-25 14:56
 **/
public interface RouteCollectionRepository extends JpaRepository<RouteCollection, Long>, JpaSpecificationExecutor<RouteCollection> {

    Page<RouteCollection> findAllByUserIdAndBeginSiteLikeOrEndSiteLike(long userId, String k1,String k2, Pageable pageable);

    Page<RouteCollection> findAllByUserId(long userId, Pageable pageable);


}
