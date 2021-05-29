package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.Impl.CouponDAOImpl;
import com.trungtamjava.model.Coupon;

public class CouponService {
	private CouponDAOImpl couponDAOImpl;
	
	public CouponService() {
		couponDAOImpl = new CouponDAOImpl();
	}
	
	public void addCoupon(Coupon coupon) throws Exception {
		couponDAOImpl.addCoupon(coupon);
	}
	
	public Coupon getCouponByCode(String code) throws Exception {
		return couponDAOImpl.getCouponByCode(code);
	}
	
	public Coupon getCouponByBillId(int id) throws Exception {
		return couponDAOImpl.getCouponByBillId(id);	
	}
	
	public List<Coupon> getAllCoupon() throws Exception {
		return couponDAOImpl.getAllCoupon();
	}
	
	public List<Coupon> getCouponByUserId(int id) throws Exception {
		return couponDAOImpl.getCouponByUserId(id);
	}
}
