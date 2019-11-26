package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.domain.RouteCollection;
import org.springframework.http.ResponseEntity;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-25 15:05
 **/
public interface RouteCollectionService {
    ResponseEntity addRouteCollection(RouteCollection routeCollection);

    ResponseEntity getRouteCollection(int page, int size, boolean asc, String keyword);

    ResponseEntity delRouteCollection(long[] ids);
}
