package sharebook.model;

import java.util.ArrayList;
import java.util.List;

public class ShareUserNameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareUserNameExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(Long value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(Long value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(Long value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(Long value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(Long value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<Long> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<Long> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(Long value1, Long value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(Long value1, Long value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeIsNull() {
            addCriterion("school_code is null");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeIsNotNull() {
            addCriterion("school_code is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeEqualTo(Integer value) {
            addCriterion("school_code =", value, "schoolCode");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeNotEqualTo(Integer value) {
            addCriterion("school_code <>", value, "schoolCode");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeGreaterThan(Integer value) {
            addCriterion("school_code >", value, "schoolCode");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_code >=", value, "schoolCode");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeLessThan(Integer value) {
            addCriterion("school_code <", value, "schoolCode");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeLessThanOrEqualTo(Integer value) {
            addCriterion("school_code <=", value, "schoolCode");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeIn(List<Integer> values) {
            addCriterion("school_code in", values, "schoolCode");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeNotIn(List<Integer> values) {
            addCriterion("school_code not in", values, "schoolCode");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeBetween(Integer value1, Integer value2) {
            addCriterion("school_code between", value1, value2, "schoolCode");
            return (Criteria) this;
        }

        public Criteria andSchoolCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("school_code not between", value1, value2, "schoolCode");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Integer> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Integer> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeIsNull() {
            addCriterion("registered_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeIsNotNull() {
            addCriterion("registered_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeEqualTo(Integer value) {
            addCriterion("registered_time =", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeNotEqualTo(Integer value) {
            addCriterion("registered_time <>", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeGreaterThan(Integer value) {
            addCriterion("registered_time >", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("registered_time >=", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeLessThan(Integer value) {
            addCriterion("registered_time <", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeLessThanOrEqualTo(Integer value) {
            addCriterion("registered_time <=", value, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeIn(List<Integer> values) {
            addCriterion("registered_time in", values, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeNotIn(List<Integer> values) {
            addCriterion("registered_time not in", values, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeBetween(Integer value1, Integer value2) {
            addCriterion("registered_time between", value1, value2, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andRegisteredTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("registered_time not between", value1, value2, "registeredTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Integer value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Integer value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Integer value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Integer value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Integer value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Integer> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Integer> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Integer value1, Integer value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andBanTimeIsNull() {
            addCriterion("ban_time is null");
            return (Criteria) this;
        }

        public Criteria andBanTimeIsNotNull() {
            addCriterion("ban_time is not null");
            return (Criteria) this;
        }

        public Criteria andBanTimeEqualTo(Integer value) {
            addCriterion("ban_time =", value, "banTime");
            return (Criteria) this;
        }

        public Criteria andBanTimeNotEqualTo(Integer value) {
            addCriterion("ban_time <>", value, "banTime");
            return (Criteria) this;
        }

        public Criteria andBanTimeGreaterThan(Integer value) {
            addCriterion("ban_time >", value, "banTime");
            return (Criteria) this;
        }

        public Criteria andBanTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ban_time >=", value, "banTime");
            return (Criteria) this;
        }

        public Criteria andBanTimeLessThan(Integer value) {
            addCriterion("ban_time <", value, "banTime");
            return (Criteria) this;
        }

        public Criteria andBanTimeLessThanOrEqualTo(Integer value) {
            addCriterion("ban_time <=", value, "banTime");
            return (Criteria) this;
        }

        public Criteria andBanTimeIn(List<Integer> values) {
            addCriterion("ban_time in", values, "banTime");
            return (Criteria) this;
        }

        public Criteria andBanTimeNotIn(List<Integer> values) {
            addCriterion("ban_time not in", values, "banTime");
            return (Criteria) this;
        }

        public Criteria andBanTimeBetween(Integer value1, Integer value2) {
            addCriterion("ban_time between", value1, value2, "banTime");
            return (Criteria) this;
        }

        public Criteria andBanTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("ban_time not between", value1, value2, "banTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Integer value) {
            addCriterion("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Integer value) {
            addCriterion("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Integer value) {
            addCriterion("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Integer value) {
            addCriterion("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Integer value) {
            addCriterion("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Integer> values) {
            addCriterion("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Integer> values) {
            addCriterion("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Integer value1, Integer value2) {
            addCriterion("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_time not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andCUIsNull() {
            addCriterion("c_u is null");
            return (Criteria) this;
        }

        public Criteria andCUIsNotNull() {
            addCriterion("c_u is not null");
            return (Criteria) this;
        }

        public Criteria andCUEqualTo(Integer value) {
            addCriterion("c_u =", value, "cU");
            return (Criteria) this;
        }

        public Criteria andCUNotEqualTo(Integer value) {
            addCriterion("c_u <>", value, "cU");
            return (Criteria) this;
        }

        public Criteria andCUGreaterThan(Integer value) {
            addCriterion("c_u >", value, "cU");
            return (Criteria) this;
        }

        public Criteria andCUGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_u >=", value, "cU");
            return (Criteria) this;
        }

        public Criteria andCULessThan(Integer value) {
            addCriterion("c_u <", value, "cU");
            return (Criteria) this;
        }

        public Criteria andCULessThanOrEqualTo(Integer value) {
            addCriterion("c_u <=", value, "cU");
            return (Criteria) this;
        }

        public Criteria andCUIn(List<Integer> values) {
            addCriterion("c_u in", values, "cU");
            return (Criteria) this;
        }

        public Criteria andCUNotIn(List<Integer> values) {
            addCriterion("c_u not in", values, "cU");
            return (Criteria) this;
        }

        public Criteria andCUBetween(Integer value1, Integer value2) {
            addCriterion("c_u between", value1, value2, "cU");
            return (Criteria) this;
        }

        public Criteria andCUNotBetween(Integer value1, Integer value2) {
            addCriterion("c_u not between", value1, value2, "cU");
            return (Criteria) this;
        }

        public Criteria andCTIsNull() {
            addCriterion("c_t is null");
            return (Criteria) this;
        }

        public Criteria andCTIsNotNull() {
            addCriterion("c_t is not null");
            return (Criteria) this;
        }

        public Criteria andCTEqualTo(Integer value) {
            addCriterion("c_t =", value, "cT");
            return (Criteria) this;
        }

        public Criteria andCTNotEqualTo(Integer value) {
            addCriterion("c_t <>", value, "cT");
            return (Criteria) this;
        }

        public Criteria andCTGreaterThan(Integer value) {
            addCriterion("c_t >", value, "cT");
            return (Criteria) this;
        }

        public Criteria andCTGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_t >=", value, "cT");
            return (Criteria) this;
        }

        public Criteria andCTLessThan(Integer value) {
            addCriterion("c_t <", value, "cT");
            return (Criteria) this;
        }

        public Criteria andCTLessThanOrEqualTo(Integer value) {
            addCriterion("c_t <=", value, "cT");
            return (Criteria) this;
        }

        public Criteria andCTIn(List<Integer> values) {
            addCriterion("c_t in", values, "cT");
            return (Criteria) this;
        }

        public Criteria andCTNotIn(List<Integer> values) {
            addCriterion("c_t not in", values, "cT");
            return (Criteria) this;
        }

        public Criteria andCTBetween(Integer value1, Integer value2) {
            addCriterion("c_t between", value1, value2, "cT");
            return (Criteria) this;
        }

        public Criteria andCTNotBetween(Integer value1, Integer value2) {
            addCriterion("c_t not between", value1, value2, "cT");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeIsNull() {
            addCriterion("ban_longtime is null");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeIsNotNull() {
            addCriterion("ban_longtime is not null");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeEqualTo(Integer value) {
            addCriterion("ban_longtime =", value, "banLongtime");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeNotEqualTo(Integer value) {
            addCriterion("ban_longtime <>", value, "banLongtime");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeGreaterThan(Integer value) {
            addCriterion("ban_longtime >", value, "banLongtime");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ban_longtime >=", value, "banLongtime");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeLessThan(Integer value) {
            addCriterion("ban_longtime <", value, "banLongtime");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeLessThanOrEqualTo(Integer value) {
            addCriterion("ban_longtime <=", value, "banLongtime");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeIn(List<Integer> values) {
            addCriterion("ban_longtime in", values, "banLongtime");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeNotIn(List<Integer> values) {
            addCriterion("ban_longtime not in", values, "banLongtime");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeBetween(Integer value1, Integer value2) {
            addCriterion("ban_longtime between", value1, value2, "banLongtime");
            return (Criteria) this;
        }

        public Criteria andBanLongtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("ban_longtime not between", value1, value2, "banLongtime");
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