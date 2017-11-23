package com.mwm.env.mybatis.modal;

import java.util.ArrayList;
import java.util.List;

public class ProvideInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProvideInfoExample() {
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

        public Criteria andMeasurecerurlIsNull() {
            addCriterion("MeasureCerUrl is null");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlIsNotNull() {
            addCriterion("MeasureCerUrl is not null");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlEqualTo(String value) {
            addCriterion("MeasureCerUrl =", value, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlNotEqualTo(String value) {
            addCriterion("MeasureCerUrl <>", value, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlGreaterThan(String value) {
            addCriterion("MeasureCerUrl >", value, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlGreaterThanOrEqualTo(String value) {
            addCriterion("MeasureCerUrl >=", value, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlLessThan(String value) {
            addCriterion("MeasureCerUrl <", value, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlLessThanOrEqualTo(String value) {
            addCriterion("MeasureCerUrl <=", value, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlLike(String value) {
            addCriterion("MeasureCerUrl like", value, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlNotLike(String value) {
            addCriterion("MeasureCerUrl not like", value, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlIn(List<String> values) {
            addCriterion("MeasureCerUrl in", values, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlNotIn(List<String> values) {
            addCriterion("MeasureCerUrl not in", values, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlBetween(String value1, String value2) {
            addCriterion("MeasureCerUrl between", value1, value2, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andMeasurecerurlNotBetween(String value1, String value2) {
            addCriterion("MeasureCerUrl not between", value1, value2, "measurecerurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlIsNull() {
            addCriterion("DetectionCapabilityUrl is null");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlIsNotNull() {
            addCriterion("DetectionCapabilityUrl is not null");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlEqualTo(String value) {
            addCriterion("DetectionCapabilityUrl =", value, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlNotEqualTo(String value) {
            addCriterion("DetectionCapabilityUrl <>", value, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlGreaterThan(String value) {
            addCriterion("DetectionCapabilityUrl >", value, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlGreaterThanOrEqualTo(String value) {
            addCriterion("DetectionCapabilityUrl >=", value, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlLessThan(String value) {
            addCriterion("DetectionCapabilityUrl <", value, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlLessThanOrEqualTo(String value) {
            addCriterion("DetectionCapabilityUrl <=", value, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlLike(String value) {
            addCriterion("DetectionCapabilityUrl like", value, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlNotLike(String value) {
            addCriterion("DetectionCapabilityUrl not like", value, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlIn(List<String> values) {
            addCriterion("DetectionCapabilityUrl in", values, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlNotIn(List<String> values) {
            addCriterion("DetectionCapabilityUrl not in", values, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlBetween(String value1, String value2) {
            addCriterion("DetectionCapabilityUrl between", value1, value2, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andDetectioncapabilityurlNotBetween(String value1, String value2) {
            addCriterion("DetectionCapabilityUrl not between", value1, value2, "detectioncapabilityurl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlIsNull() {
            addCriterion("AnnexsSetUrl is null");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlIsNotNull() {
            addCriterion("AnnexsSetUrl is not null");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlEqualTo(String value) {
            addCriterion("AnnexsSetUrl =", value, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlNotEqualTo(String value) {
            addCriterion("AnnexsSetUrl <>", value, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlGreaterThan(String value) {
            addCriterion("AnnexsSetUrl >", value, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlGreaterThanOrEqualTo(String value) {
            addCriterion("AnnexsSetUrl >=", value, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlLessThan(String value) {
            addCriterion("AnnexsSetUrl <", value, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlLessThanOrEqualTo(String value) {
            addCriterion("AnnexsSetUrl <=", value, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlLike(String value) {
            addCriterion("AnnexsSetUrl like", value, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlNotLike(String value) {
            addCriterion("AnnexsSetUrl not like", value, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlIn(List<String> values) {
            addCriterion("AnnexsSetUrl in", values, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlNotIn(List<String> values) {
            addCriterion("AnnexsSetUrl not in", values, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlBetween(String value1, String value2) {
            addCriterion("AnnexsSetUrl between", value1, value2, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAnnexsseturlNotBetween(String value1, String value2) {
            addCriterion("AnnexsSetUrl not between", value1, value2, "annexsseturl");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNull() {
            addCriterion("AuditStatus is null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNotNull() {
            addCriterion("AuditStatus is not null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusEqualTo(String value) {
            addCriterion("AuditStatus =", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotEqualTo(String value) {
            addCriterion("AuditStatus <>", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusGreaterThan(String value) {
            addCriterion("AuditStatus >", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusGreaterThanOrEqualTo(String value) {
            addCriterion("AuditStatus >=", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLessThan(String value) {
            addCriterion("AuditStatus <", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLessThanOrEqualTo(String value) {
            addCriterion("AuditStatus <=", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLike(String value) {
            addCriterion("AuditStatus like", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotLike(String value) {
            addCriterion("AuditStatus not like", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIn(List<String> values) {
            addCriterion("AuditStatus in", values, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotIn(List<String> values) {
            addCriterion("AuditStatus not in", values, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusBetween(String value1, String value2) {
            addCriterion("AuditStatus between", value1, value2, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotBetween(String value1, String value2) {
            addCriterion("AuditStatus not between", value1, value2, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("UserType is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("UserType is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(String value) {
            addCriterion("UserType =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(String value) {
            addCriterion("UserType <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(String value) {
            addCriterion("UserType >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(String value) {
            addCriterion("UserType >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(String value) {
            addCriterion("UserType <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(String value) {
            addCriterion("UserType <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLike(String value) {
            addCriterion("UserType like", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotLike(String value) {
            addCriterion("UserType not like", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<String> values) {
            addCriterion("UserType in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<String> values) {
            addCriterion("UserType not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(String value1, String value2) {
            addCriterion("UserType between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(String value1, String value2) {
            addCriterion("UserType not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andAuditstuteIsNull() {
            addCriterion("AuditStute is null");
            return (Criteria) this;
        }

        public Criteria andAuditstuteIsNotNull() {
            addCriterion("AuditStute is not null");
            return (Criteria) this;
        }

        public Criteria andAuditstuteEqualTo(String value) {
            addCriterion("AuditStute =", value, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteNotEqualTo(String value) {
            addCriterion("AuditStute <>", value, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteGreaterThan(String value) {
            addCriterion("AuditStute >", value, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteGreaterThanOrEqualTo(String value) {
            addCriterion("AuditStute >=", value, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteLessThan(String value) {
            addCriterion("AuditStute <", value, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteLessThanOrEqualTo(String value) {
            addCriterion("AuditStute <=", value, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteLike(String value) {
            addCriterion("AuditStute like", value, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteNotLike(String value) {
            addCriterion("AuditStute not like", value, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteIn(List<String> values) {
            addCriterion("AuditStute in", values, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteNotIn(List<String> values) {
            addCriterion("AuditStute not in", values, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteBetween(String value1, String value2) {
            addCriterion("AuditStute between", value1, value2, "auditstute");
            return (Criteria) this;
        }

        public Criteria andAuditstuteNotBetween(String value1, String value2) {
            addCriterion("AuditStute not between", value1, value2, "auditstute");
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