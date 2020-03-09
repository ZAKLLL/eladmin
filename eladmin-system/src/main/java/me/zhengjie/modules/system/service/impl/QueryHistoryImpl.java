package me.zhengjie.modules.system.service.impl;

import me.zhengjie.modules.security.utils.JwtTokenUtil;
import me.zhengjie.modules.system.domain.QueryHistory;
import me.zhengjie.modules.system.repository.QueryHistoryRepository;
import me.zhengjie.modules.system.service.QueryHistoryService;
import me.zhengjie.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

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
        return new ResponseEntity(new ResultMessage(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getQueryhistory(int page, int size, long userId, boolean asc) {
        long Id = userId == 0 ? JwtTokenUtil.getCurrentUserid() : userId;
        Sort sort = new Sort(asc ? Sort.Direction.ASC : Sort.Direction.DESC, "createTime");
        Page<QueryHistory> all = queryHistoryRepository.findAllByUserId(Id, PageRequest.of(page, size, sort));
        HashMap res = new HashMap();
        res.put("res", all);
        return new ResponseEntity(new ResultMessage(res), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delQueryhistory(long[] ids) {
        for (long id : ids) {
            queryHistoryRepository.deleteById(id);
        }
        return new ResponseEntity(new ResultMessage(), HttpStatus.OK);
    }
}
