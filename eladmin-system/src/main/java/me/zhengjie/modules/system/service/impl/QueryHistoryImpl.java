package me.zhengjie.modules.system.service.impl;

import me.zhengjie.modules.security.utils.JwtTokenUtil;
import me.zhengjie.modules.system.domain.QueryHistory;
import me.zhengjie.modules.system.repository.QueryHistoryRepository;
import me.zhengjie.modules.system.service.QueryHistoryService;
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
 * @create: 2019-11-25 15:08
 **/
@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class QueryHistoryImpl implements QueryHistoryService {

    @Autowired
    private QueryHistoryRepository queryHistoryRepository;

    @Override
    public ResponseEntity addQueryHistory(QueryHistory queryHistory) {
        queryHistory.setUserId(JwtTokenUtil.getCurrentUserid());
        queryHistoryRepository.save(queryHistory);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity getQueryhistory(int page, int size, boolean asc) {
        Sort sort = new Sort(asc ? Sort.Direction.ASC : Sort.Direction.DESC, "createTime");
        Page<QueryHistory> all = queryHistoryRepository.findAll(PageRequest.of(page, size, sort));
        return new ResponseEntity(all, HttpStatus.OK);
    }

    @Override
    public ResponseEntity delQueryhistory(long[] ids) {
        for (long id : ids) {
            queryHistoryRepository.deleteById(id);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
