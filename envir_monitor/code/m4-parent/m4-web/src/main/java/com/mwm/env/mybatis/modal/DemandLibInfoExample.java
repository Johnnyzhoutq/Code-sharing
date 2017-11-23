package com.mwm.env.mybatis.modal;

import java.util.ArrayList;
import java.util.List;

public class DemandLibInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DemandLibInfoExample() {
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

        public Criteria andDemandlibidIsNull() {
            addCriterion("DemandLibId is null");
            return (Criteria) this;
        }

        public Criteria andDemandlibidIsNotNull() {
            addCriterion("DemandLibId is not null");
            return (Criteria) this;
        }

        public Criteria andDemandlibidEqualTo(Integer value) {
            addCriterion("DemandLibId =", value, "demandlibid");
            return (Criteria) this;
        }

        public Criteria andDemandlibidNotEqualTo(Integer value) {
            addCriterion("DemandLibId <>", value, "demandlibid");
            return (Criteria) this;
        }

        public Criteria andDemandlibidGreaterThan(Integer value) {
            addCriterion("DemandLibId >", value, "demandlibid");
            return (Criteria) this;
        }

        public Criteria andDemandlibidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DemandLibId >=", value, "demandlibid");
            return (Criteria) this;
        }

        public Criteria andDemandlibidLessThan(Integer value) {
            addCriterion("DemandLibId <", value, "demandlibid");
            return (Criteria) this;
        }

        public Criteria andDemandlibidLessThanOrEqualTo(Integer value) {
            addCriterion("DemandLibId <=", value, "demandlibid");
            return (Criteria) this;
        }

        public Criteria andDemandlibidIn(List<Integer> values) {
            addCriterion("DemandLibId in", values, "demandlibid");
            return (Criteria) this;
        }

        public Criteria andDemandlibidNotIn(List<Integer> values) {
            addCriterion("DemandLibId not in", values, "demandlibid");
            return (Criteria) this;
        }

        public Criteria andDemandlibidBetween(Integer value1, Integer value2) {
            addCriterion("DemandLibId between", value1, value2, "demandlibid");
            return (Criteria) this;
        }

        public Criteria andDemandlibidNotBetween(Integer value1, Integer value2) {
            addCriterion("DemandLibId not between", value1, value2, "demandlibid");
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

        public Criteria andDemandlibnameIsNull() {
            addCriterion("DemandLibName is null");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameIsNotNull() {
            addCriterion("DemandLibName is not null");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameEqualTo(String value) {
            addCriterion("DemandLibName =", value, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameNotEqualTo(String value) {
            addCriterion("DemandLibName <>", value, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameGreaterThan(String value) {
            addCriterion("DemandLibName >", value, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameGreaterThanOrEqualTo(String value) {
            addCriterion("DemandLibName >=", value, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameLessThan(String value) {
            addCriterion("DemandLibName <", value, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameLessThanOrEqualTo(String value) {
            addCriterion("DemandLibName <=", value, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameLike(String value) {
            addCriterion("DemandLibName like", value, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameNotLike(String value) {
            addCriterion("DemandLibName not like", value, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameIn(List<String> values) {
            addCriterion("DemandLibName in", values, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameNotIn(List<String> values) {
            addCriterion("DemandLibName not in", values, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameBetween(String value1, String value2) {
            addCriterion("DemandLibName between", value1, value2, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibnameNotBetween(String value1, String value2) {
            addCriterion("DemandLibName not between", value1, value2, "demandlibname");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescIsNull() {
            addCriterion("DemandLibDesc is null");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescIsNotNull() {
            addCriterion("DemandLibDesc is not null");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescEqualTo(String value) {
            addCriterion("DemandLibDesc =", value, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescNotEqualTo(String value) {
            addCriterion("DemandLibDesc <>", value, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescGreaterThan(String value) {
            addCriterion("DemandLibDesc >", value, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescGreaterThanOrEqualTo(String value) {
            addCriterion("DemandLibDesc >=", value, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescLessThan(String value) {
            addCriterion("DemandLibDesc <", value, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescLessThanOrEqualTo(String value) {
            addCriterion("DemandLibDesc <=", value, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescLike(String value) {
            addCriterion("DemandLibDesc like", value, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescNotLike(String value) {
            addCriterion("DemandLibDesc not like", value, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescIn(List<String> values) {
            addCriterion("DemandLibDesc in", values, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescNotIn(List<String> values) {
            addCriterion("DemandLibDesc not in", values, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescBetween(String value1, String value2) {
            addCriterion("DemandLibDesc between", value1, value2, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andDemandlibdescNotBetween(String value1, String value2) {
            addCriterion("DemandLibDesc not between", value1, value2, "demandlibdesc");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Long value) {
            addCriterion("CreateDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Long value) {
            addCriterion("CreateDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Long value) {
            addCriterion("CreateDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Long value) {
            addCriterion("CreateDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Long value) {
            addCriterion("CreateDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Long value) {
            addCriterion("CreateDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Long> values) {
            addCriterion("CreateDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Long> values) {
            addCriterion("CreateDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Long value1, Long value2) {
            addCriterion("CreateDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Long value1, Long value2) {
            addCriterion("CreateDate not between", value1, value2, "createdate");
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