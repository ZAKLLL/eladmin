package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.domain.SiteCollection;
import org.springframework.http.ResponseEntity;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-25 15:06
 **/
public interface SiteCollectionService {
    ResponseEntity addSiteCollection(SiteCollection siteCollection);

    ResponseEntity getSiteCollection(int page, int size, long userId, boolean asc, String keyWord);

    ResponseEntity delSiteCollection(long[] ids);


}
