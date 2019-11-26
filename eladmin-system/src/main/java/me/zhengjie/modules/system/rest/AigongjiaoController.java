package me.zhengjie.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.system.domain.QueryHistory;
import me.zhengjie.modules.system.domain.RouteCollection;
import me.zhengjie.modules.system.domain.SiteCollection;
import me.zhengjie.modules.system.service.QueryHistoryService;
import me.zhengjie.modules.system.service.RouteCollectionService;
import me.zhengjie.modules.system.service.SiteCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    private SiteCollectionService siteCollectionService;

    @Autowired
    private RouteCollectionService routeCollectionService;

    @Log("添加历史记录")
    @ApiOperation("添加历史记录")
    @PostMapping("/queryhistory")
    public ResponseEntity addQueryHistory(@RequestBody QueryHistory queryHistory) {
        return queryHistoryService.addQueryHistory(queryHistory);
    }

    @Log("分页查询查询历史记录")
    @ApiOperation("分页查询查询历史记录")
    @GetMapping("/queryhitory")
    public ResponseEntity getQueryhitory(int page, int size, boolean asc) {
        return queryHistoryService.getQueryhistory(page, size, asc);
    }

    @Log("删除查询历史记录")
    @ApiOperation("删除查询历史记录")
    @DeleteMapping("/queryhistory")
    public ResponseEntity delQueryhistory(long[] ids) {
        return queryHistoryService.delQueryhistory(ids);
    }

    @Log("收藏站点")
    @ApiOperation("收藏站点")
    @PostMapping("/siteCollection")
    public ResponseEntity addSiteCollection(@Validated @RequestBody SiteCollection siteCollection) {
        return siteCollectionService.addSiteCollection(siteCollection);
    }

    @Log("查询站点")
    @ApiOperation("查询站点")
    @GetMapping("/siteCollection")
    public ResponseEntity getSiteCollection(int page, int size, boolean asc, String keyWord) {
        return siteCollectionService.getSiteCollection(page, size, asc, keyWord);
    }

    @Log("删除收藏站点")
    @ApiOperation("删除收藏站点")
    @DeleteMapping("/sitecolletion")
    public ResponseEntity delSitecolletion(long[] ids) {
        return siteCollectionService.delSiteCollection(ids);
    }

    @Log("删除收藏路线")
    @ApiOperation("删除收藏路线")
    @DeleteMapping("/routecollection")
    public ResponseEntity delRouteCollection(long[] ids) {
        return routeCollectionService.delRouteCollection(ids);
    }

    @Log("收藏路线")
    @ApiOperation("收藏路线")
    @PostMapping("/routecollection")
    public ResponseEntity addRouteCollection(@Validated @RequestBody RouteCollection routeCollection) {
        return routeCollectionService.addRouteCollection(routeCollection);
    }

    @Log("分页查看路线")
    @ApiOperation("分页查看路线")
    @GetMapping("/routecollection")
    public ResponseEntity getRouteCollection(int page, int size, boolean asc, String keyword) {
        return routeCollectionService.getRouteCollection(page, size, asc, keyword);
    }


}
