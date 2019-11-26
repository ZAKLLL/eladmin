package me.zhengjie.modules.system.service.impl;

import me.zhengjie.modules.system.domain.RouteCollection;
import me.zhengjie.modules.system.repository.RouteCollectionRepository;
import me.zhengjie.modules.system.service.RouteCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-25 15:07
 **/
@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class RouteCollectionImpl implements RouteCollectionService {
    @Autowired
    private RouteCollectionRepository routeCollectionRepository;

    @Override
    public ResponseEntity addRouteCollection(RouteCollection routeCollection) {
        routeCollectionRepository.save(routeCollection);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity getRouteCollection(int page, int size, boolean asc, String keyword) {
        Page<RouteCollection> res;
        PageRequest pageRequest = PageRequest.of(page, size, asc ? Sort.Direction.ASC : Sort.Direction.DESC, "createTime");
        if (keyword != null && keyword.length() != 0) {
            res = routeCollectionRepository.findAllByBeginSiteOrEndSiteLike(keyword, pageRequest);
        } else {
            res =routeCollectionRepository.findAll(pageRequest);
        }
        return new ResponseEntity(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity delRouteCollection(long[] ids) {
        for (long id : ids) {
            routeCollectionRepository.deleteById(id);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
