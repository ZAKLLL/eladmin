package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.SiteCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sun.java2d.pipe.SolidTextRenderer;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-25 14:57
 **/
public interface SiteCollectionRepository extends JpaRepository<SiteCollection, Long>, JpaSpecificationExecutor<SiteCollection> {

    Page<SiteCollection> findBySiteNameLike(String keyword, Pageable pageable);
}
