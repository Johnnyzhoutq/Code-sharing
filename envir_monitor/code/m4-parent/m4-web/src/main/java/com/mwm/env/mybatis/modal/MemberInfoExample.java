package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MemberInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMemberidIsNull() {
            addCriterion("MemberId is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("MemberId is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("MemberId =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("MemberId <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("MemberId >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MemberId >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("MemberId <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("MemberId <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("MemberId in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("MemberId not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("MemberId between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("MemberId not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andProvideidIsNull() {
            addCriterion("ProvideId is null");
            return (Criteria) this;
        }

        public Criteria andProvideidIsNotNull() {
            addCriterion("ProvideId is not null");
            return (Criteria) this;
        }

        public Criteria andProvideidEqualTo(Integer value) {
            addCriterion("ProvideId =", value, "provideid");
            return (Criteria) this;
        }

        public Criteria andProvideidNotEqualTo(Integer value) {
            addCriterion("ProvideId <>", value, "provideid");
            return (Criteria) this;
        }

        public Criteria andProvideidGreaterThan(Integer value) {
            addCriterion("ProvideId >", value, "provideid");
            return (Criteria) this;
        }

        public Criteria andProvideidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ProvideId >=", value, "provideid");
            return (Criteria) this;
        }

        public Criteria andProvideidLessThan(Integer value) {
            addCriterion("ProvideId <", value, "provideid");
            return (Criteria) this;
        }

        public Criteria andProvideidLessThanOrEqualTo(Integer value) {
            addCriterion("ProvideId <=", value, "provideid");
            return (Criteria) this;
        }

        public Criteria andProvideidIn(List<Integer> values) {
            addCriterion("ProvideId in", values, "provideid");
            return (Criteria) this;
        }

        public Criteria andProvideidNotIn(List<Integer> values) {
            addCriterion("ProvideId not in", values, "provideid");
            return (Criteria) this;
        }

        public Criteria andProvideidBetween(Integer value1, Integer value2) {
            addCriterion("ProvideId between", value1, value2, "provideid");
            return (Criteria) this;
        }

        public Criteria andProvideidNotBetween(Integer value1, Integer value2) {
            addCriterion("ProvideId not between", value1, value2, "provideid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("UserId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("UserId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("UserId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("UserId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("UserId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("UserId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("UserId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("UserId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("UserId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("UserId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("UserId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("UserId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMembertypeIsNull() {
            addCriterion("MemberType is null");
            return (Criteria) this;
        }

        public Criteria andMembertypeIsNotNull() {
            addCriterion("MemberType is not null");
            return (Criteria) this;
        }

        public Criteria andMembertypeEqualTo(Integer value) {
            addCriterion("MemberType =", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeNotEqualTo(Integer value) {
            addCriterion("MemberType <>", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeGreaterThan(Integer value) {
            addCriterion("MemberType >", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MemberType >=", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeLessThan(Integer value) {
            addCriterion("MemberType <", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeLessThanOrEqualTo(Integer value) {
            addCriterion("MemberType <=", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeIn(List<Integer> values) {
            addCriterion("MemberType in", values, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeNotIn(List<Integer> values) {
            addCriterion("MemberType not in", values, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeBetween(Integer value1, Integer value2) {
            addCriterion("MemberType between", value1, value2, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("MemberType not between", value1, value2, "membertype");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeIsNull() {
            addCriterion("OpenedTime is null");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeIsNotNull() {
            addCriterion("OpenedTime is not null");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeEqualTo(Long value) {
            addCriterion("OpenedTime =", value, "openedtime");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeNotEqualTo(Long value) {
            addCriterion("OpenedTime <>", value, "openedtime");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeGreaterThan(Long value) {
            addCriterion("OpenedTime >", value, "openedtime");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("OpenedTime >=", value, "openedtime");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeLessThan(Long value) {
            addCriterion("OpenedTime <", value, "openedtime");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeLessThanOrEqualTo(Long value) {
            addCriterion("OpenedTime <=", value, "openedtime");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeIn(List<Long> values) {
            addCriterion("OpenedTime in", values, "openedtime");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeNotIn(List<Long> values) {
            addCriterion("OpenedTime not in", values, "openedtime");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeBetween(Long value1, Long value2) {
            addCriterion("OpenedTime between", value1, value2, "openedtime");
            return (Criteria) this;
        }

        public Criteria andOpenedtimeNotBetween(Long value1, Long value2) {
            addCriterion("OpenedTime not between", value1, value2, "openedtime");
            return (Criteria) this;
        }

        public Criteria andOpenedwayIsNull() {
            addCriterion("OpenedWay is null");
            return (Criteria) this;
        }

        public Criteria andOpenedwayIsNotNull() {
            addCriterion("OpenedWay is not null");
            return (Criteria) this;
        }

        public Criteria andOpenedwayEqualTo(String value) {
            addCriterion("OpenedWay =", value, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayNotEqualTo(String value) {
            addCriterion("OpenedWay <>", value, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayGreaterThan(String value) {
            addCriterion("OpenedWay >", value, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayGreaterThanOrEqualTo(String value) {
            addCriterion("OpenedWay >=", value, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayLessThan(String value) {
            addCriterion("OpenedWay <", value, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayLessThanOrEqualTo(String value) {
            addCriterion("OpenedWay <=", value, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayLike(String value) {
            addCriterion("OpenedWay like", value, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayNotLike(String value) {
            addCriterion("OpenedWay not like", value, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayIn(List<String> values) {
            addCriterion("OpenedWay in", values, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayNotIn(List<String> values) {
            addCriterion("OpenedWay not in", values, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayBetween(String value1, String value2) {
            addCriterion("OpenedWay between", value1, value2, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedwayNotBetween(String value1, String value2) {
            addCriterion("OpenedWay not between", value1, value2, "openedway");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentIsNull() {
            addCriterion("OpenedContent is null");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentIsNotNull() {
            addCriterion("OpenedContent is not null");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentEqualTo(String value) {
            addCriterion("OpenedContent =", value, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentNotEqualTo(String value) {
            addCriterion("OpenedContent <>", value, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentGreaterThan(String value) {
            addCriterion("OpenedContent >", value, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentGreaterThanOrEqualTo(String value) {
            addCriterion("OpenedContent >=", value, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentLessThan(String value) {
            addCriterion("OpenedContent <", value, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentLessThanOrEqualTo(String value) {
            addCriterion("OpenedContent <=", value, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentLike(String value) {
            addCriterion("OpenedContent like", value, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentNotLike(String value) {
            addCriterion("OpenedContent not like", value, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentIn(List<String> values) {
            addCriterion("OpenedContent in", values, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentNotIn(List<String> values) {
            addCriterion("OpenedContent not in", values, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentBetween(String value1, String value2) {
            addCriterion("OpenedContent between", value1, value2, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andOpenedcontentNotBetween(String value1, String value2) {
            addCriterion("OpenedContent not between", value1, value2, "openedcontent");
            return (Criteria) this;
        }

        public Criteria andAmountpaidIsNull() {
            addCriterion("AmountPaid is null");
            return (Criteria) this;
        }

        public Criteria andAmountpaidIsNotNull() {
            addCriterion("AmountPaid is not null");
            return (Criteria) this;
        }

        public Criteria andAmountpaidEqualTo(BigDecimal value) {
            addCriterion("AmountPaid =", value, "amountpaid");
            return (Criteria) this;
        }

        public Criteria andAmountpaidNotEqualTo(BigDecimal value) {
            addCriterion("AmountPaid <>", value, "amountpaid");
            return (Criteria) this;
        }

        public Criteria andAmountpaidGreaterThan(BigDecimal value) {
            addCriterion("AmountPaid >", value, "amountpaid");
            return (Criteria) this;
        }

        public Criteria andAmountpaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AmountPaid >=", value, "amountpaid");
            return (Criteria) this;
        }

        public Criteria andAmountpaidLessThan(BigDecimal value) {
            addCriterion("AmountPaid <", value, "amountpaid");
            return (Criteria) this;
        }

        public Criteria andAmountpaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AmountPaid <=", value, "amountpaid");
            return (Criteria) this;
        }

        public Criteria andAmountpaidIn(List<BigDecimal> values) {
            addCriterion("AmountPaid in", values, "amountpaid");
            return (Criteria) this;
        }

        public Criteria andAmountpaidNotIn(List<BigDecimal> values) {
            addCriterion("AmountPaid not in", values, "amountpaid");
            return (Criteria) this;
        }

        public Criteria andAmountpaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AmountPaid between", value1, value2, "amountpaid");
            return (Criteria) this;
        }

        public Criteria andAmountpaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AmountPaid not between", value1, value2, "amountpaid");
            return (Criteria) this;
        }

        public Criteria andAmountwayIsNull() {
            addCriterion("AmountWay is null");
            return (Criteria) this;
        }

        public Criteria andAmountwayIsNotNull() {
            addCriterion("AmountWay is not null");
            return (Criteria) this;
        }

        public Criteria andAmountwayEqualTo(String value) {
            addCriterion("AmountWay =", value, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayNotEqualTo(String value) {
            addCriterion("AmountWay <>", value, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayGreaterThan(String value) {
            addCriterion("AmountWay >", value, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayGreaterThanOrEqualTo(String value) {
            addCriterion("AmountWay >=", value, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayLessThan(String value) {
            addCriterion("AmountWay <", value, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayLessThanOrEqualTo(String value) {
            addCriterion("AmountWay <=", value, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayLike(String value) {
            addCriterion("AmountWay like", value, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayNotLike(String value) {
            addCriterion("AmountWay not like", value, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayIn(List<String> values) {
            addCriterion("AmountWay in", values, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayNotIn(List<String> values) {
            addCriterion("AmountWay not in", values, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayBetween(String value1, String value2) {
            addCriterion("AmountWay between", value1, value2, "amountway");
            return (Criteria) this;
        }

        public Criteria andAmountwayNotBetween(String value1, String value2) {
            addCriterion("AmountWay not between", value1, value2, "amountway");
            return (Criteria) this;
        }

        public Criteria andIncomratioIsNull() {
            addCriterion("IncomRatio is null");
            return (Criteria) this;
        }

        public Criteria andIncomratioIsNotNull() {
            addCriterion("IncomRatio is not null");
            return (Criteria) this;
        }

        public Criteria andIncomratioEqualTo(BigDecimal value) {
            addCriterion("IncomRatio =", value, "incomratio");
            return (Criteria) this;
        }

        public Criteria andIncomratioNotEqualTo(BigDecimal value) {
            addCriterion("IncomRatio <>", value, "incomratio");
            return (Criteria) this;
        }

        public Criteria andIncomratioGreaterThan(BigDecimal value) {
            addCriterion("IncomRatio >", value, "incomratio");
            return (Criteria) this;
        }

        public Criteria andIncomratioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IncomRatio >=", value, "incomratio");
            return (Criteria) this;
        }

        public Criteria andIncomratioLessThan(BigDecimal value) {
            addCriterion("IncomRatio <", value, "incomratio");
            return (Criteria) this;
        }

        public Criteria andIncomratioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IncomRatio <=", value, "incomratio");
            return (Criteria) this;
        }

        public Criteria andIncomratioIn(List<BigDecimal> values) {
            addCriterion("IncomRatio in", values, "incomratio");
            return (Criteria) this;
        }

        public Criteria andIncomratioNotIn(List<BigDecimal> values) {
            addCriterion("IncomRatio not in", values, "incomratio");
            return (Criteria) this;
        }

        public Criteria andIncomratioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IncomRatio between", value1, value2, "incomratio");
            return (Criteria) this;
        }

        public Criteria andIncomratioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IncomRatio not between", value1, value2, "incomratio");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginIsNull() {
            addCriterion("PeriodBegin is null");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginIsNotNull() {
            addCriterion("PeriodBegin is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginEqualTo(Long value) {
            addCriterion("PeriodBegin =", value, "periodbegin");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginNotEqualTo(Long value) {
            addCriterion("PeriodBegin <>", value, "periodbegin");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginGreaterThan(Long value) {
            addCriterion("PeriodBegin >", value, "periodbegin");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginGreaterThanOrEqualTo(Long value) {
            addCriterion("PeriodBegin >=", value, "periodbegin");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginLessThan(Long value) {
            addCriterion("PeriodBegin <", value, "periodbegin");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginLessThanOrEqualTo(Long value) {
            addCriterion("PeriodBegin <=", value, "periodbegin");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginIn(List<Long> values) {
            addCriterion("PeriodBegin in", values, "periodbegin");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginNotIn(List<Long> values) {
            addCriterion("PeriodBegin not in", values, "periodbegin");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginBetween(Long value1, Long value2) {
            addCriterion("PeriodBegin between", value1, value2, "periodbegin");
            return (Criteria) this;
        }

        public Criteria andPeriodbeginNotBetween(Long value1, Long value2) {
            addCriterion("PeriodBegin not between", value1, value2, "periodbegin");
            return (Criteria) this;
        }

        public Criteria andPeriodendIsNull() {
            addCriterion("PeriodEnd is null");
            return (Criteria) this;
        }

        public Criteria andPeriodendIsNotNull() {
            addCriterion("PeriodEnd is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodendEqualTo(Long value) {
            addCriterion("PeriodEnd =", value, "periodend");
            return (Criteria) this;
        }

        public Criteria andPeriodendNotEqualTo(Long value) {
            addCriterion("PeriodEnd <>", value, "periodend");
            return (Criteria) this;
        }

        public Criteria andPeriodendGreaterThan(Long value) {
            addCriterion("PeriodEnd >", value, "periodend");
            return (Criteria) this;
        }

        public Criteria andPeriodendGreaterThanOrEqualTo(Long value) {
            addCriterion("PeriodEnd >=", value, "periodend");
            return (Criteria) this;
        }

        public Criteria andPeriodendLessThan(Long value) {
            addCriterion("PeriodEnd <", value, "periodend");
            return (Criteria) this;
        }

        public Criteria andPeriodendLessThanOrEqualTo(Long value) {
            addCriterion("PeriodEnd <=", value, "periodend");
            return (Criteria) this;
        }

        public Criteria andPeriodendIn(List<Long> values) {
            addCriterion("PeriodEnd in", values, "periodend");
            return (Criteria) this;
        }

        public Criteria andPeriodendNotIn(List<Long> values) {
            addCriterion("PeriodEnd not in", values, "periodend");
            return (Criteria) this;
        }

        public Criteria andPeriodendBetween(Long value1, Long value2) {
            addCriterion("PeriodEnd between", value1, value2, "periodend");
            return (Criteria) this;
        }

        public Criteria andPeriodendNotBetween(Long value1, Long value2) {
            addCriterion("PeriodEnd not between", value1, value2, "periodend");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("Createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("Createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Long value) {
            addCriterion("Createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Long value) {
            addCriterion("Createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Long value) {
            addCriterion("Createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Long value) {
            addCriterion("Createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Long value) {
            addCriterion("Createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Long value) {
            addCriterion("Createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Long> values) {
            addCriterion("Createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Long> values) {
            addCriterion("Createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Long value1, Long value2) {
            addCriterion("Createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Long value1, Long value2) {
            addCriterion("Createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNull() {
            addCriterion("ModifyDate is null");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNotNull() {
            addCriterion("ModifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andModifydateEqualTo(Long value) {
            addCriterion("ModifyDate =", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotEqualTo(Long value) {
            addCriterion("ModifyDate <>", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThan(Long value) {
            addCriterion("ModifyDate >", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThanOrEqualTo(Long value) {
            addCriterion("ModifyDate >=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThan(Long value) {
            addCriterion("ModifyDate <", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThanOrEqualTo(Long value) {
            addCriterion("ModifyDate <=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateIn(List<Long> values) {
            addCriterion("ModifyDate in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotIn(List<Long> values) {
            addCriterion("ModifyDate not in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateBetween(Long value1, Long value2) {
            addCriterion("ModifyDate between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotBetween(Long value1, Long value2) {
            addCriterion("ModifyDate not between", value1, value2, "modifydate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}