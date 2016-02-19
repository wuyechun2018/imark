package com.imark.manager.dao.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.imark.manager.model.BizBill;

public interface BizBillJpaDao extends PagingAndSortingRepository<BizBill, String>{

}
