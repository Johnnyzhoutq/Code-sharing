package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IndexInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndexInfoExample() {
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

        public Criteria andIndexidIsNull() {
            addCriterion("IndexId is null");
            return (Criteria) this;
        }

        public Criteria andIndexidIsNotNull() {
            addCriterion("IndexId is not null");
            return (Criteria) this;
        }

        public Criteria andIndexidEqualTo(Integer value) {
            addCriterion("IndexId =", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotEqualTo(Integer value) {
            addCriterion("IndexId <>", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidGreaterThan(Integer value) {
            addCriterion("IndexId >", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidGreaterThanOrEqualTo(Integer value) {
            addCriterion("IndexId >=", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidLessThan(Integer value) {
            addCriterion("IndexId <", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidLessThanOrEqualTo(Integer value) {
            addCriterion("IndexId <=", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidIn(List<Integer> values) {
            addCriterion("IndexId in", values, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotIn(List<Integer> values) {
            addCriterion("IndexId not in", values, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidBetween(Integer value1, Integer value2) {
            addCriterion("IndexId between", value1, value2, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotBetween(Integer value1, Integer value2) {
            addCriterion("IndexId not between", value1, value2, "indexid");
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

        public Criteria andIndexlibidIsNull() {
            addCriterion("IndexLibId is null");
            return (Criteria) this;
        }

        public Criteria andIndexlibidIsNotNull() {
            addCriterion("IndexLibId is not null");
            return (Criteria) this;
        }

        public Criteria andIndexlibidEqualTo(Integer value) {
            addCriterion("IndexLibId =", value, "indexlibid");
            return (Criteria) this;
        }

        public Criteria andIndexlibidNotEqualTo(Integer value) {
            addCriterion("IndexLibId <>", value, "indexlibid");
            return (Criteria) this;
        }

        public Criteria andIndexlibidGreaterThan(Integer value) {
            addCriterion("IndexLibId >", value, "indexlibid");
            return (Criteria) this;
        }

        public Criteria andIndexlibidGreaterThanOrEqualTo(Integer value) {
            addCriterion("IndexLibId >=", value, "indexlibid");
            return (Criteria) this;
        }

        public Criteria andIndexlibidLessThan(Integer value) {
            addCriterion("IndexLibId <", value, "indexlibid");
            return (Criteria) this;
        }

        public Criteria andIndexlibidLessThanOrEqualTo(Integer value) {
            addCriterion("IndexLibId <=", value, "indexlibid");
            return (Criteria) this;
        }

        public Criteria andIndexlibidIn(List<Integer> values) {
            addCriterion("IndexLibId in", values, "indexlibid");
            return (Criteria) this;
        }

        public Criteria andIndexlibidNotIn(List<Integer> values) {
            addCriterion("IndexLibId not in", values, "indexlibid");
            return (Criteria) this;
        }

        public Criteria andIndexlibidBetween(Integer value1, Integer value2) {
            addCriterion("IndexLibId between", value1, value2, "indexlibid");
            return (Criteria) this;
        }

        public Criteria andIndexlibidNotBetween(Integer value1, Integer value2) {
            addCriterion("IndexLibId not between", value1, value2, "indexlibid");
            return (Criteria) this;
        }

        public Criteria andIndexnameIsNull() {
            addCriterion("IndexName is null");
            return (Criteria) this;
        }

        public Criteria andIndexnameIsNotNull() {
            addCriterion("IndexName is not null");
            return (Criteria) this;
        }

        public Criteria andIndexnameEqualTo(String value) {
            addCriterion("IndexName =", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotEqualTo(String value) {
            addCriterion("IndexName <>", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameGreaterThan(String value) {
            addCriterion("IndexName >", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameGreaterThanOrEqualTo(String value) {
            addCriterion("IndexName >=", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLessThan(String value) {
            addCriterion("IndexName <", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLessThanOrEqualTo(String value) {
            addCriterion("IndexName <=", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLike(String value) {
            addCriterion("IndexName like", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotLike(String value) {
            addCriterion("IndexName not like", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameIn(List<String> values) {
            addCriterion("IndexName in", values, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotIn(List<String> values) {
            addCriterion("IndexName not in", values, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameBetween(String value1, String value2) {
            addCriterion("IndexName between", value1, value2, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotBetween(String value1, String value2) {
            addCriterion("IndexName not between", value1, value2, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexunitsIsNull() {
            addCriterion("IndexUnits is null");
            return (Criteria) this;
        }

        public Criteria andIndexunitsIsNotNull() {
            addCriterion("IndexUnits is not null");
            return (Criteria) this;
        }

        public Criteria andIndexunitsEqualTo(String value) {
            addCriterion("IndexUnits =", value, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsNotEqualTo(String value) {
            addCriterion("IndexUnits <>", value, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsGreaterThan(String value) {
            addCriterion("IndexUnits >", value, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsGreaterThanOrEqualTo(String value) {
            addCriterion("IndexUnits >=", value, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsLessThan(String value) {
            addCriterion("IndexUnits <", value, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsLessThanOrEqualTo(String value) {
            addCriterion("IndexUnits <=", value, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsLike(String value) {
            addCriterion("IndexUnits like", value, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsNotLike(String value) {
            addCriterion("IndexUnits not like", value, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsIn(List<String> values) {
            addCriterion("IndexUnits in", values, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsNotIn(List<String> values) {
            addCriterion("IndexUnits not in", values, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsBetween(String value1, String value2) {
            addCriterion("IndexUnits between", value1, value2, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexunitsNotBetween(String value1, String value2) {
            addCriterion("IndexUnits not between", value1, value2, "indexunits");
            return (Criteria) this;
        }

        public Criteria andIndexpriceIsNull() {
            addCriterion("IndexPrice is null");
            return (Criteria) this;
        }

        public Criteria andIndexpriceIsNotNull() {
            addCriterion("IndexPrice is not null");
            return (Criteria) this;
        }

        public Criteria andIndexpriceEqualTo(BigDecimal value) {
            addCriterion("IndexPrice =", value, "indexprice");
            return (Criteria) this;
        }

        public Criteria andIndexpriceNotEqualTo(BigDecimal value) {
            addCriterion("IndexPrice <>", value, "indexprice");
            return (Criteria) this;
        }

        public Criteria andIndexpriceGreaterThan(BigDecimal value) {
            addCriterion("IndexPrice >", value, "indexprice");
            return (Criteria) this;
        }

        public Criteria andIndexpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IndexPrice >=", value, "indexprice");
            return (Criteria) this;
        }

        public Criteria andIndexpriceLessThan(BigDecimal value) {
            addCriterion("IndexPrice <", value, "indexprice");
            return (Criteria) this;
        }

        public Criteria andIndexpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IndexPrice <=", value, "indexprice");
            return (Criteria) this;
        }

        public Criteria andIndexpriceIn(List<BigDecimal> values) {
            addCriterion("IndexPrice in", values, "indexprice");
            return (Criteria) this;
        }

        public Criteria andIndexpriceNotIn(List<BigDecimal> values) {
            addCriterion("IndexPrice not in", values, "indexprice");
            return (Criteria) this;
        }

        public Criteria andIndexpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IndexPrice between", value1, value2, "indexprice");
            return (Criteria) this;
        }

        public Criteria andIndexpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IndexPrice not between", value1, value2, "indexprice");
            return (Criteria) this;
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

        public Criteria andStateIsNull() {
            addCriterion("State is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("State is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("State =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("State <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("State >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("State >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("State <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("State <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("State like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("State not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("State in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("State not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("State between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("State not between", value1, value2, "state");
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