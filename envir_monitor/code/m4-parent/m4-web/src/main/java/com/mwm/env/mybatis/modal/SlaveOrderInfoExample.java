package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SlaveOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SlaveOrderInfoExample() {
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

        public Criteria andSlaveidIsNull() {
            addCriterion("SlaveId is null");
            return (Criteria) this;
        }

        public Criteria andSlaveidIsNotNull() {
            addCriterion("SlaveId is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveidEqualTo(Long value) {
            addCriterion("SlaveId =", value, "slaveid");
            return (Criteria) this;
        }

        public Criteria andSlaveidNotEqualTo(Long value) {
            addCriterion("SlaveId <>", value, "slaveid");
            return (Criteria) this;
        }

        public Criteria andSlaveidGreaterThan(Long value) {
            addCriterion("SlaveId >", value, "slaveid");
            return (Criteria) this;
        }

        public Criteria andSlaveidGreaterThanOrEqualTo(Long value) {
            addCriterion("SlaveId >=", value, "slaveid");
            return (Criteria) this;
        }

        public Criteria andSlaveidLessThan(Long value) {
            addCriterion("SlaveId <", value, "slaveid");
            return (Criteria) this;
        }

        public Criteria andSlaveidLessThanOrEqualTo(Long value) {
            addCriterion("SlaveId <=", value, "slaveid");
            return (Criteria) this;
        }

        public Criteria andSlaveidIn(List<Long> values) {
            addCriterion("SlaveId in", values, "slaveid");
            return (Criteria) this;
        }

        public Criteria andSlaveidNotIn(List<Long> values) {
            addCriterion("SlaveId not in", values, "slaveid");
            return (Criteria) this;
        }

        public Criteria andSlaveidBetween(Long value1, Long value2) {
            addCriterion("SlaveId between", value1, value2, "slaveid");
            return (Criteria) this;
        }

        public Criteria andSlaveidNotBetween(Long value1, Long value2) {
            addCriterion("SlaveId not between", value1, value2, "slaveid");
            return (Criteria) this;
        }

        public Criteria andMasteridIsNull() {
            addCriterion("MasterId is null");
            return (Criteria) this;
        }

        public Criteria andMasteridIsNotNull() {
            addCriterion("MasterId is not null");
            return (Criteria) this;
        }

        public Criteria andMasteridEqualTo(Long value) {
            addCriterion("MasterId =", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridNotEqualTo(Long value) {
            addCriterion("MasterId <>", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridGreaterThan(Long value) {
            addCriterion("MasterId >", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridGreaterThanOrEqualTo(Long value) {
            addCriterion("MasterId >=", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridLessThan(Long value) {
            addCriterion("MasterId <", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridLessThanOrEqualTo(Long value) {
            addCriterion("MasterId <=", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridIn(List<Long> values) {
            addCriterion("MasterId in", values, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridNotIn(List<Long> values) {
            addCriterion("MasterId not in", values, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridBetween(Long value1, Long value2) {
            addCriterion("MasterId between", value1, value2, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridNotBetween(Long value1, Long value2) {
            addCriterion("MasterId not between", value1, value2, "masterid");
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

        public Criteria andSlavenumIsNull() {
            addCriterion("SlaveNum is null");
            return (Criteria) this;
        }

        public Criteria andSlavenumIsNotNull() {
            addCriterion("SlaveNum is not null");
            return (Criteria) this;
        }

        public Criteria andSlavenumEqualTo(String value) {
            addCriterion("SlaveNum =", value, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumNotEqualTo(String value) {
            addCriterion("SlaveNum <>", value, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumGreaterThan(String value) {
            addCriterion("SlaveNum >", value, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumGreaterThanOrEqualTo(String value) {
            addCriterion("SlaveNum >=", value, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumLessThan(String value) {
            addCriterion("SlaveNum <", value, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumLessThanOrEqualTo(String value) {
            addCriterion("SlaveNum <=", value, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumLike(String value) {
            addCriterion("SlaveNum like", value, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumNotLike(String value) {
            addCriterion("SlaveNum not like", value, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumIn(List<String> values) {
            addCriterion("SlaveNum in", values, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumNotIn(List<String> values) {
            addCriterion("SlaveNum not in", values, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumBetween(String value1, String value2) {
            addCriterion("SlaveNum between", value1, value2, "slavenum");
            return (Criteria) this;
        }

        public Criteria andSlavenumNotBetween(String value1, String value2) {
            addCriterion("SlaveNum not between", value1, value2, "slavenum");
            return (Criteria) this;
        }

        public Criteria andRecivableIsNull() {
            addCriterion("Recivable is null");
            return (Criteria) this;
        }

        public Criteria andRecivableIsNotNull() {
            addCriterion("Recivable is not null");
            return (Criteria) this;
        }

        public Criteria andRecivableEqualTo(BigDecimal value) {
            addCriterion("Recivable =", value, "recivable");
            return (Criteria) this;
        }

        public Criteria andRecivableNotEqualTo(BigDecimal value) {
            addCriterion("Recivable <>", value, "recivable");
            return (Criteria) this;
        }

        public Criteria andRecivableGreaterThan(BigDecimal value) {
            addCriterion("Recivable >", value, "recivable");
            return (Criteria) this;
        }

        public Criteria andRecivableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Recivable >=", value, "recivable");
            return (Criteria) this;
        }

        public Criteria andRecivableLessThan(BigDecimal value) {
            addCriterion("Recivable <", value, "recivable");
            return (Criteria) this;
        }

        public Criteria andRecivableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Recivable <=", value, "recivable");
            return (Criteria) this;
        }

        public Criteria andRecivableIn(List<BigDecimal> values) {
            addCriterion("Recivable in", values, "recivable");
            return (Criteria) this;
        }

        public Criteria andRecivableNotIn(List<BigDecimal> values) {
            addCriterion("Recivable not in", values, "recivable");
            return (Criteria) this;
        }

        public Criteria andRecivableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Recivable between", value1, value2, "recivable");
            return (Criteria) this;
        }

        public Criteria andRecivableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Recivable not between", value1, value2, "recivable");
            return (Criteria) this;
        }

        public Criteria andPaidpriceIsNull() {
            addCriterion("PaidPrice is null");
            return (Criteria) this;
        }

        public Criteria andPaidpriceIsNotNull() {
            addCriterion("PaidPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPaidpriceEqualTo(BigDecimal value) {
            addCriterion("PaidPrice =", value, "paidprice");
            return (Criteria) this;
        }

        public Criteria andPaidpriceNotEqualTo(BigDecimal value) {
            addCriterion("PaidPrice <>", value, "paidprice");
            return (Criteria) this;
        }

        public Criteria andPaidpriceGreaterThan(BigDecimal value) {
            addCriterion("PaidPrice >", value, "paidprice");
            return (Criteria) this;
        }

        public Criteria andPaidpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PaidPrice >=", value, "paidprice");
            return (Criteria) this;
        }

        public Criteria andPaidpriceLessThan(BigDecimal value) {
            addCriterion("PaidPrice <", value, "paidprice");
            return (Criteria) this;
        }

        public Criteria andPaidpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PaidPrice <=", value, "paidprice");
            return (Criteria) this;
        }

        public Criteria andPaidpriceIn(List<BigDecimal> values) {
            addCriterion("PaidPrice in", values, "paidprice");
            return (Criteria) this;
        }

        public Criteria andPaidpriceNotIn(List<BigDecimal> values) {
            addCriterion("PaidPrice not in", values, "paidprice");
            return (Criteria) this;
        }

        public Criteria andPaidpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PaidPrice between", value1, value2, "paidprice");
            return (Criteria) this;
        }

        public Criteria andPaidpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PaidPrice not between", value1, value2, "paidprice");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceIsNull() {
            addCriterion("PenaltyPrice is null");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceIsNotNull() {
            addCriterion("PenaltyPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceEqualTo(BigDecimal value) {
            addCriterion("PenaltyPrice =", value, "penaltyprice");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceNotEqualTo(BigDecimal value) {
            addCriterion("PenaltyPrice <>", value, "penaltyprice");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceGreaterThan(BigDecimal value) {
            addCriterion("PenaltyPrice >", value, "penaltyprice");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PenaltyPrice >=", value, "penaltyprice");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceLessThan(BigDecimal value) {
            addCriterion("PenaltyPrice <", value, "penaltyprice");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PenaltyPrice <=", value, "penaltyprice");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceIn(List<BigDecimal> values) {
            addCriterion("PenaltyPrice in", values, "penaltyprice");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceNotIn(List<BigDecimal> values) {
            addCriterion("PenaltyPrice not in", values, "penaltyprice");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PenaltyPrice between", value1, value2, "penaltyprice");
            return (Criteria) this;
        }

        public Criteria andPenaltypriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PenaltyPrice not between", value1, value2, "penaltyprice");
            return (Criteria) this;
        }

        public Criteria andRefundIsNull() {
            addCriterion("Refund is null");
            return (Criteria) this;
        }

        public Criteria andRefundIsNotNull() {
            addCriterion("Refund is not null");
            return (Criteria) this;
        }

        public Criteria andRefundEqualTo(BigDecimal value) {
            addCriterion("Refund =", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotEqualTo(BigDecimal value) {
            addCriterion("Refund <>", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThan(BigDecimal value) {
            addCriterion("Refund >", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Refund >=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThan(BigDecimal value) {
            addCriterion("Refund <", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Refund <=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundIn(List<BigDecimal> values) {
            addCriterion("Refund in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotIn(List<BigDecimal> values) {
            addCriterion("Refund not in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Refund between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Refund not between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andIncomeratioIsNull() {
            addCriterion("IncomeRatio is null");
            return (Criteria) this;
        }

        public Criteria andIncomeratioIsNotNull() {
            addCriterion("IncomeRatio is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeratioEqualTo(BigDecimal value) {
            addCriterion("IncomeRatio =", value, "incomeratio");
            return (Criteria) this;
        }

        public Criteria andIncomeratioNotEqualTo(BigDecimal value) {
            addCriterion("IncomeRatio <>", value, "incomeratio");
            return (Criteria) this;
        }

        public Criteria andIncomeratioGreaterThan(BigDecimal value) {
            addCriterion("IncomeRatio >", value, "incomeratio");
            return (Criteria) this;
        }

        public Criteria andIncomeratioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IncomeRatio >=", value, "incomeratio");
            return (Criteria) this;
        }

        public Criteria andIncomeratioLessThan(BigDecimal value) {
            addCriterion("IncomeRatio <", value, "incomeratio");
            return (Criteria) this;
        }

        public Criteria andIncomeratioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IncomeRatio <=", value, "incomeratio");
            return (Criteria) this;
        }

        public Criteria andIncomeratioIn(List<BigDecimal> values) {
            addCriterion("IncomeRatio in", values, "incomeratio");
            return (Criteria) this;
        }

        public Criteria andIncomeratioNotIn(List<BigDecimal> values) {
            addCriterion("IncomeRatio not in", values, "incomeratio");
            return (Criteria) this;
        }

        public Criteria andIncomeratioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IncomeRatio between", value1, value2, "incomeratio");
            return (Criteria) this;
        }

        public Criteria andIncomeratioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IncomeRatio not between", value1, value2, "incomeratio");
            return (Criteria) this;
        }

        public Criteria andOrderstateIsNull() {
            addCriterion("OrderState is null");
            return (Criteria) this;
        }

        public Criteria andOrderstateIsNotNull() {
            addCriterion("OrderState is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstateEqualTo(String value) {
            addCriterion("OrderState =", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotEqualTo(String value) {
            addCriterion("OrderState <>", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateGreaterThan(String value) {
            addCriterion("OrderState >", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateGreaterThanOrEqualTo(String value) {
            addCriterion("OrderState >=", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateLessThan(String value) {
            addCriterion("OrderState <", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateLessThanOrEqualTo(String value) {
            addCriterion("OrderState <=", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateLike(String value) {
            addCriterion("OrderState like", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotLike(String value) {
            addCriterion("OrderState not like", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateIn(List<String> values) {
            addCriterion("OrderState in", values, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotIn(List<String> values) {
            addCriterion("OrderState not in", values, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateBetween(String value1, String value2) {
            addCriterion("OrderState between", value1, value2, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotBetween(String value1, String value2) {
            addCriterion("OrderState not between", value1, value2, "orderstate");
            return (Criteria) this;
        }

        public Criteria andDeliverynumIsNull() {
            addCriterion("DeliveryNum is null");
            return (Criteria) this;
        }

        public Criteria andDeliverynumIsNotNull() {
            addCriterion("DeliveryNum is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverynumEqualTo(String value) {
            addCriterion("DeliveryNum =", value, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumNotEqualTo(String value) {
            addCriterion("DeliveryNum <>", value, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumGreaterThan(String value) {
            addCriterion("DeliveryNum >", value, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumGreaterThanOrEqualTo(String value) {
            addCriterion("DeliveryNum >=", value, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumLessThan(String value) {
            addCriterion("DeliveryNum <", value, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumLessThanOrEqualTo(String value) {
            addCriterion("DeliveryNum <=", value, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumLike(String value) {
            addCriterion("DeliveryNum like", value, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumNotLike(String value) {
            addCriterion("DeliveryNum not like", value, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumIn(List<String> values) {
            addCriterion("DeliveryNum in", values, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumNotIn(List<String> values) {
            addCriterion("DeliveryNum not in", values, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumBetween(String value1, String value2) {
            addCriterion("DeliveryNum between", value1, value2, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverynumNotBetween(String value1, String value2) {
            addCriterion("DeliveryNum not between", value1, value2, "deliverynum");
            return (Criteria) this;
        }

        public Criteria andDeliverydateIsNull() {
            addCriterion("DeliveryDate is null");
            return (Criteria) this;
        }

        public Criteria andDeliverydateIsNotNull() {
            addCriterion("DeliveryDate is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverydateEqualTo(Long value) {
            addCriterion("DeliveryDate =", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateNotEqualTo(Long value) {
            addCriterion("DeliveryDate <>", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateGreaterThan(Long value) {
            addCriterion("DeliveryDate >", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateGreaterThanOrEqualTo(Long value) {
            addCriterion("DeliveryDate >=", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateLessThan(Long value) {
            addCriterion("DeliveryDate <", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateLessThanOrEqualTo(Long value) {
            addCriterion("DeliveryDate <=", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateIn(List<Long> values) {
            addCriterion("DeliveryDate in", values, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateNotIn(List<Long> values) {
            addCriterion("DeliveryDate not in", values, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateBetween(Long value1, Long value2) {
            addCriterion("DeliveryDate between", value1, value2, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateNotBetween(Long value1, Long value2) {
            addCriterion("DeliveryDate not between", value1, value2, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andRecipdateIsNull() {
            addCriterion("RecipDate is null");
            return (Criteria) this;
        }

        public Criteria andRecipdateIsNotNull() {
            addCriterion("RecipDate is not null");
            return (Criteria) this;
        }

        public Criteria andRecipdateEqualTo(Long value) {
            addCriterion("RecipDate =", value, "recipdate");
            return (Criteria) this;
        }

        public Criteria andRecipdateNotEqualTo(Long value) {
            addCriterion("RecipDate <>", value, "recipdate");
            return (Criteria) this;
        }

        public Criteria andRecipdateGreaterThan(Long value) {
            addCriterion("RecipDate >", value, "recipdate");
            return (Criteria) this;
        }

        public Criteria andRecipdateGreaterThanOrEqualTo(Long value) {
            addCriterion("RecipDate >=", value, "recipdate");
            return (Criteria) this;
        }

        public Criteria andRecipdateLessThan(Long value) {
            addCriterion("RecipDate <", value, "recipdate");
            return (Criteria) this;
        }

        public Criteria andRecipdateLessThanOrEqualTo(Long value) {
            addCriterion("RecipDate <=", value, "recipdate");
            return (Criteria) this;
        }

        public Criteria andRecipdateIn(List<Long> values) {
            addCriterion("RecipDate in", values, "recipdate");
            return (Criteria) this;
        }

        public Criteria andRecipdateNotIn(List<Long> values) {
            addCriterion("RecipDate not in", values, "recipdate");
            return (Criteria) this;
        }

        public Criteria andRecipdateBetween(Long value1, Long value2) {
            addCriterion("RecipDate between", value1, value2, "recipdate");
            return (Criteria) this;
        }

        public Criteria andRecipdateNotBetween(Long value1, Long value2) {
            addCriterion("RecipDate not between", value1, value2, "recipdate");
            return (Criteria) this;
        }

        public Criteria andPlatformdateIsNull() {
            addCriterion("PlatformDate is null");
            return (Criteria) this;
        }

        public Criteria andPlatformdateIsNotNull() {
            addCriterion("PlatformDate is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformdateEqualTo(Long value) {
            addCriterion("PlatformDate =", value, "platformdate");
            return (Criteria) this;
        }

        public Criteria andPlatformdateNotEqualTo(Long value) {
            addCriterion("PlatformDate <>", value, "platformdate");
            return (Criteria) this;
        }

        public Criteria andPlatformdateGreaterThan(Long value) {
            addCriterion("PlatformDate >", value, "platformdate");
            return (Criteria) this;
        }

        public Criteria andPlatformdateGreaterThanOrEqualTo(Long value) {
            addCriterion("PlatformDate >=", value, "platformdate");
            return (Criteria) this;
        }

        public Criteria andPlatformdateLessThan(Long value) {
            addCriterion("PlatformDate <", value, "platformdate");
            return (Criteria) this;
        }

        public Criteria andPlatformdateLessThanOrEqualTo(Long value) {
            addCriterion("PlatformDate <=", value, "platformdate");
            return (Criteria) this;
        }

        public Criteria andPlatformdateIn(List<Long> values) {
            addCriterion("PlatformDate in", values, "platformdate");
            return (Criteria) this;
        }

        public Criteria andPlatformdateNotIn(List<Long> values) {
            addCriterion("PlatformDate not in", values, "platformdate");
            return (Criteria) this;
        }

        public Criteria andPlatformdateBetween(Long value1, Long value2) {
            addCriterion("PlatformDate between", value1, value2, "platformdate");
            return (Criteria) this;
        }

        public Criteria andPlatformdateNotBetween(Long value1, Long value2) {
            addCriterion("PlatformDate not between", value1, value2, "platformdate");
            return (Criteria) this;
        }

        public Criteria andCompletedateIsNull() {
            addCriterion("CompleteDate is null");
            return (Criteria) this;
        }

        public Criteria andCompletedateIsNotNull() {
            addCriterion("CompleteDate is not null");
            return (Criteria) this;
        }

        public Criteria andCompletedateEqualTo(Long value) {
            addCriterion("CompleteDate =", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateNotEqualTo(Long value) {
            addCriterion("CompleteDate <>", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateGreaterThan(Long value) {
            addCriterion("CompleteDate >", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateGreaterThanOrEqualTo(Long value) {
            addCriterion("CompleteDate >=", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateLessThan(Long value) {
            addCriterion("CompleteDate <", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateLessThanOrEqualTo(Long value) {
            addCriterion("CompleteDate <=", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateIn(List<Long> values) {
            addCriterion("CompleteDate in", values, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateNotIn(List<Long> values) {
            addCriterion("CompleteDate not in", values, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateBetween(Long value1, Long value2) {
            addCriterion("CompleteDate between", value1, value2, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateNotBetween(Long value1, Long value2) {
            addCriterion("CompleteDate not between", value1, value2, "completedate");
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

        public Criteria andGoodsIsNull() {
            addCriterion("Goods is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIsNotNull() {
            addCriterion("Goods is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsEqualTo(Integer value) {
            addCriterion("Goods =", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsNotEqualTo(Integer value) {
            addCriterion("Goods <>", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsGreaterThan(Integer value) {
            addCriterion("Goods >", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Goods >=", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsLessThan(Integer value) {
            addCriterion("Goods <", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsLessThanOrEqualTo(Integer value) {
            addCriterion("Goods <=", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsIn(List<Integer> values) {
            addCriterion("Goods in", values, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsNotIn(List<Integer> values) {
            addCriterion("Goods not in", values, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsBetween(Integer value1, Integer value2) {
            addCriterion("Goods between", value1, value2, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsNotBetween(Integer value1, Integer value2) {
            addCriterion("Goods not between", value1, value2, "goods");
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