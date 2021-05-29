package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Coupon;

public interface CouponDAO {
	void addCoupon(Coupon coupon) throws Exception;
	Coupon getCouponByCode(String code) throws Exception;
	Coupon getCouponByBillId(int id) throws Exception;
	List<Coupon> getAllCoupon() throws Exception;
	List<Coupon> getCouponByUserId(int id) throws Exception;
}
