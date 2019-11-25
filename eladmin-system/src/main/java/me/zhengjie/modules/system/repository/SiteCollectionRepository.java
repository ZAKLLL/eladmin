package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.SiteCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-25 14:57
 **/
public interface SiteCollectionRepository extends JpaRepository<SiteCollection, Long>, JpaSpecificationExecutor<SiteCollection> {

}
