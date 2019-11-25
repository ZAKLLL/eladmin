package me.zhengjie.modules.system.rest;

import io.swagger.annotations.Api;
import me.zhengjie.modules.system.domain.RouteCollection;
import me.zhengjie.modules.system.service.QueryHistoryService;
import me.zhengjie.modules.system.service.RouteCollectionService;
import me.zhengjie.modules.system.service.SiteCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-25 15:10
 **/
@RestController
@Api(tags = "爱公交业务接口/非账户相关")
@RequestMapping("/api/aigongjiao")
public class AigongjiaoController {

    @Autowired
    private QueryHistoryService queryHistoryService;

    @Autowired
    private SiteCollectionService collectionService;

    @Autowired
    private RouteCollectionService routeCollectionService;



}
