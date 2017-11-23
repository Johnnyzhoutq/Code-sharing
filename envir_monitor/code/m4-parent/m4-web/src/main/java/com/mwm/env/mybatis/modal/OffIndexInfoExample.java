package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OffIndexInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OffIndexInfoExample() {
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

        public Criteria andOffindexidIsNull() {
            addCriterion("OffIndexId is null");
            return (Criteria) this;
        }

        public Criteria andOffindexidIsNotNull() {
            addCriterion("OffIndexId is not null");
            return (Criteria) this;
        }

        public Criteria andOffindexidEqualTo(Integer value) {
            addCriterion("OffIndexId =", value, "offindexid");
            return (Criteria) this;
        }

        public Criteria andOffindexidNotEqualTo(Integer value) {
            addCriterion("OffIndexId <>", value, "offindexid");
            return (Criteria) this;
        }

        public Criteria andOffindexidGreaterThan(Integer value) {
            addCriterion("OffIndexId >", value, "offindexid");
            return (Criteria) this;
        }

        public Criteria andOffindexidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OffIndexId >=", value, "offindexid");
            return (Criteria) this;
        }

        public Criteria andOffindexidLessThan(Integer value) {
            addCriterion("OffIndexId <", value, "offindexid");
            return (Criteria) this;
        }

        public Criteria andOffindexidLessThanOrEqualTo(Integer value) {
            addCriterion("OffIndexId <=", value, "offindexid");
            return (Criteria) this;
        }

        public Criteria andOffindexidIn(List<Integer> values) {
            addCriterion("OffIndexId in", values, "offindexid");
            return (Criteria) this;
        }

        public Criteria andOffindexidNotIn(List<Integer> values) {
            addCriterion("OffIndexId not in", values, "offindexid");
            return (Criteria) this;
        }

        public Criteria andOffindexidBetween(Integer value1, Integer value2) {
            addCriterion("OffIndexId between", value1, value2, "offindexid");
            return (Criteria) this;
        }

        public Criteria andOffindexidNotBetween(Integer value1, Integer value2) {
            addCriterion("OffIndexId not between", value1, value2, "offindexid");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidIsNull() {
            addCriterion("OffIndexLibId is null");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidIsNotNull() {
            addCriterion("OffIndexLibId is not null");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidEqualTo(Integer value) {
            addCriterion("OffIndexLibId =", value, "offindexlibid");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidNotEqualTo(Integer value) {
            addCriterion("OffIndexLibId <>", value, "offindexlibid");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidGreaterThan(Integer value) {
            addCriterion("OffIndexLibId >", value, "offindexlibid");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OffIndexLibId >=", value, "offindexlibid");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidLessThan(Integer value) {
            addCriterion("OffIndexLibId <", value, "offindexlibid");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidLessThanOrEqualTo(Integer value) {
            addCriterion("OffIndexLibId <=", value, "offindexlibid");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidIn(List<Integer> values) {
            addCriterion("OffIndexLibId in", values, "offindexlibid");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidNotIn(List<Integer> values) {
            addCriterion("OffIndexLibId not in", values, "offindexlibid");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidBetween(Integer value1, Integer value2) {
            addCriterion("OffIndexLibId between", value1, value2, "offindexlibid");
            return (Criteria) this;
        }

        public Criteria andOffindexlibidNotBetween(Integer value1, Integer value2) {
            addCriterion("OffIndexLibId not between", value1, value2, "offindexlibid");
            return (Criteria) this;
        }

        public Criteria andOffindexnameIsNull() {
            addCriterion("OffIndexName is null");
            return (Criteria) this;
        }

        public Criteria andOffindexnameIsNotNull() {
            addCriterion("OffIndexName is not null");
            return (Criteria) this;
        }

        public Criteria andOffindexnameEqualTo(String value) {
            addCriterion("OffIndexName =", value, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameNotEqualTo(String value) {
            addCriterion("OffIndexName <>", value, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameGreaterThan(String value) {
            addCriterion("OffIndexName >", value, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameGreaterThanOrEqualTo(String value) {
            addCriterion("OffIndexName >=", value, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameLessThan(String value) {
            addCriterion("OffIndexName <", value, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameLessThanOrEqualTo(String value) {
            addCriterion("OffIndexName <=", value, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameLike(String value) {
            addCriterion("OffIndexName like", value, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameNotLike(String value) {
            addCriterion("OffIndexName not like", value, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameIn(List<String> values) {
            addCriterion("OffIndexName in", values, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameNotIn(List<String> values) {
            addCriterion("OffIndexName not in", values, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameBetween(String value1, String value2) {
            addCriterion("OffIndexName between", value1, value2, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexnameNotBetween(String value1, String value2) {
            addCriterion("OffIndexName not between", value1, value2, "offindexname");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsIsNull() {
            addCriterion("OffIndexUnits is null");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsIsNotNull() {
            addCriterion("OffIndexUnits is not null");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsEqualTo(String value) {
            addCriterion("OffIndexUnits =", value, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsNotEqualTo(String value) {
            addCriterion("OffIndexUnits <>", value, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsGreaterThan(String value) {
            addCriterion("OffIndexUnits >", value, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsGreaterThanOrEqualTo(String value) {
            addCriterion("OffIndexUnits >=", value, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsLessThan(String value) {
            addCriterion("OffIndexUnits <", value, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsLessThanOrEqualTo(String value) {
            addCriterion("OffIndexUnits <=", value, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsLike(String value) {
            addCriterion("OffIndexUnits like", value, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsNotLike(String value) {
            addCriterion("OffIndexUnits not like", value, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsIn(List<String> values) {
            addCriterion("OffIndexUnits in", values, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsNotIn(List<String> values) {
            addCriterion("OffIndexUnits not in", values, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsBetween(String value1, String value2) {
            addCriterion("OffIndexUnits between", value1, value2, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexunitsNotBetween(String value1, String value2) {
            addCriterion("OffIndexUnits not between", value1, value2, "offindexunits");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceIsNull() {
            addCriterion("OffIndexPrice is null");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceIsNotNull() {
            addCriterion("OffIndexPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceEqualTo(BigDecimal value) {
            addCriterion("OffIndexPrice =", value, "offindexprice");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceNotEqualTo(BigDecimal value) {
            addCriterion("OffIndexPrice <>", value, "offindexprice");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceGreaterThan(BigDecimal value) {
            addCriterion("OffIndexPrice >", value, "offindexprice");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OffIndexPrice >=", value, "offindexprice");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceLessThan(BigDecimal value) {
            addCriterion("OffIndexPrice <", value, "offindexprice");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OffIndexPrice <=", value, "offindexprice");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceIn(List<BigDecimal> values) {
            addCriterion("OffIndexPrice in", values, "offindexprice");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceNotIn(List<BigDecimal> values) {
            addCriterion("OffIndexPrice not in", values, "offindexprice");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OffIndexPrice between", value1, value2, "offindexprice");
            return (Criteria) this;
        }

        public Criteria andOffindexpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OffIndexPrice not between", value1, value2, "offindexprice");
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