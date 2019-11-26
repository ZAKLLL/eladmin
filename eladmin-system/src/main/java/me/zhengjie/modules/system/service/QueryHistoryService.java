package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.domain.QueryHistory;
import org.springframework.http.ResponseEntity;

/**
 * @program: eladmin
 * @description:
 * @author: ZakL
 * @create: 2019-11-25 15:05
 **/
public interface QueryHistoryService {

    ResponseEntity addQueryHistory(QueryHistory queryHistory);

    ResponseEntity getQueryhistory(int page, int size, boolean asc);

    ResponseEntity delQueryhistory(long[] ids);
}
