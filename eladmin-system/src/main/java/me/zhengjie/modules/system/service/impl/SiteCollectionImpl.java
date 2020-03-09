package me.zhengjie.modules.system.service.impl;

import me.zhengjie.modules.security.utils.JwtTokenUtil;
import me.zhengjie.modules.system.domain.SiteCollection;
import me.zhengjie.modules.system.repository.SiteCollectionRepository;
import me.zhengjie.modules.system.service.SiteCollectionService;
import me.zhengjie.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class SiteCollectionImpl implements SiteCollectionService {
    @Autowired
    private SiteCollectionRepository collectionRepository;

    @Override
    public ResponseEntity addSiteCollection(SiteCollection siteCollection) {
        siteCollection.setUserId(JwtTokenUtil.getCurrentUserid());
        collectionRepository.save(siteCollection);
        return new ResponseEntity(new ResultMessage(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getSiteCollection(int page, int size, long userId, boolean asc, String keyWord) {
        Sort sort = new Sort(asc ? Sort.Direction.ASC : Sort.Direction.DESC, "createTime");
        long Id = userId == 0 ? JwtTokenUtil.getCurrentUserid() : userId;
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<SiteCollection> res;
        if (keyWord == null || keyWord.length() == 0) {
            res = collectionRepository.findAllByUserId(Id, pageable);
        } else {
            res = collectionRepository.findAllByUserIdAndSiteNameLike(userId, "%"+keyWord+"%", pageable);
        }
        return new ResponseEntity(new ResultMessage(res), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delSiteCollection(long[] ids) {
        for (long id : ids) {
            collectionRepository.deleteById(id);
        }
        return new ResponseEntity(new ResultMessage(), HttpStatus.OK);
    }

}
