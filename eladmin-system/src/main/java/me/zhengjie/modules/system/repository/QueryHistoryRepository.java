package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.QueryHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-25 14:54
 **/
public interface QueryHistoryRepository extends JpaRepository<QueryHistory,Long> , JpaSpecificationExecutor<QueryHistory> {

    Page<QueryHistory> findAllByUserId(long userId, Pageable pageable);
}
