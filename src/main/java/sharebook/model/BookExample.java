package sharebook.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        public Criteria andIsbnIsNull() {
            addCriterion("ISBN is null");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNotNull() {
            addCriterion("ISBN is not null");
            return (Criteria) this;
        }

        public Criteria andIsbnEqualTo(Integer value) {
            addCriterion("ISBN =", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotEqualTo(Integer value) {
            addCriterion("ISBN <>", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThan(Integer value) {
            addCriterion("ISBN >", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISBN >=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThan(Integer value) {
            addCriterion("ISBN <", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThanOrEqualTo(Integer value) {
            addCriterion("ISBN <=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnIn(List<Integer> values) {
            addCriterion("ISBN in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotIn(List<Integer> values) {
            addCriterion("ISBN not in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnBetween(Integer value1, Integer value2) {
            addCriterion("ISBN between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotBetween(Integer value1, Integer value2) {
            addCriterion("ISBN not between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andPressIsNull() {
            addCriterion("press is null");
            return (Criteria) this;
        }

        public Criteria andPressIsNotNull() {
            addCriterion("press is not null");
            return (Criteria) this;
        }

        public Criteria andPressEqualTo(String value) {
            addCriterion("press =", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotEqualTo(String value) {
            addCriterion("press <>", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressGreaterThan(String value) {
            addCriterion("press >", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressGreaterThanOrEqualTo(String value) {
            addCriterion("press >=", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLessThan(String value) {
            addCriterion("press <", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLessThanOrEqualTo(String value) {
            addCriterion("press <=", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLike(String value) {
            addCriterion("press like", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotLike(String value) {
            addCriterion("press not like", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressIn(List<String> values) {
            addCriterion("press in", values, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotIn(List<String> values) {
            addCriterion("press not in", values, "press");
            return (Criteria) this;
        }

        public Criteria andPressBetween(String value1, String value2) {
            addCriterion("press between", value1, value2, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotBetween(String value1, String value2) {
            addCriterion("press not between", value1, value2, "press");
            return (Criteria) this;
        }

        public Criteria andPressTimeIsNull() {
            addCriterion("press_time is null");
            return (Criteria) this;
        }

        public Criteria andPressTimeIsNotNull() {
            addCriterion("press_time is not null");
            return (Criteria) this;
        }

        public Criteria andPressTimeEqualTo(Integer value) {
            addCriterion("press_time =", value, "pressTime");
            return (Criteria) this;
        }

        public Criteria andPressTimeNotEqualTo(Integer value) {
            addCriterion("press_time <>", value, "pressTime");
            return (Criteria) this;
        }

        public Criteria andPressTimeGreaterThan(Integer value) {
            addCriterion("press_time >", value, "pressTime");
            return (Criteria) this;
        }

        public Criteria andPressTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("press_time >=", value, "pressTime");
            return (Criteria) this;
        }

        public Criteria andPressTimeLessThan(Integer value) {
            addCriterion("press_time <", value, "pressTime");
            return (Criteria) this;
        }

        public Criteria andPressTimeLessThanOrEqualTo(Integer value) {
            addCriterion("press_time <=", value, "pressTime");
            return (Criteria) this;
        }

        public Criteria andPressTimeIn(List<Integer> values) {
            addCriterion("press_time in", values, "pressTime");
            return (Criteria) this;
        }

        public Criteria andPressTimeNotIn(List<Integer> values) {
            addCriterion("press_time not in", values, "pressTime");
            return (Criteria) this;
        }

        public Criteria andPressTimeBetween(Integer value1, Integer value2) {
            addCriterion("press_time between", value1, value2, "pressTime");
            return (Criteria) this;
        }

        public Criteria andPressTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("press_time not between", value1, value2, "pressTime");
            return (Criteria) this;
        }

        public Criteria andPageNumberIsNull() {
            addCriterion("page_number is null");
            return (Criteria) this;
        }

        public Criteria andPageNumberIsNotNull() {
            addCriterion("page_number is not null");
            return (Criteria) this;
        }

        public Criteria andPageNumberEqualTo(Integer value) {
            addCriterion("page_number =", value, "pageNumber");
            return (Criteria) this;
        }

        public Criteria andPageNumberNotEqualTo(Integer value) {
            addCriterion("page_number <>", value, "pageNumber");
            return (Criteria) this;
        }

        public Criteria andPageNumberGreaterThan(Integer value) {
            addCriterion("page_number >", value, "pageNumber");
            return (Criteria) this;
        }

        public Criteria andPageNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_number >=", value, "pageNumber");
            return (Criteria) this;
        }

        public Criteria andPageNumberLessThan(Integer value) {
            addCriterion("page_number <", value, "pageNumber");
            return (Criteria) this;
        }

        public Criteria andPageNumberLessThanOrEqualTo(Integer value) {
            addCriterion("page_number <=", value, "pageNumber");
            return (Criteria) this;
        }

        public Criteria andPageNumberIn(List<Integer> values) {
            addCriterion("page_number in", values, "pageNumber");
            return (Criteria) this;
        }

        public Criteria andPageNumberNotIn(List<Integer> values) {
            addCriterion("page_number not in", values, "pageNumber");
            return (Criteria) this;
        }

        public Criteria andPageNumberBetween(Integer value1, Integer value2) {
            addCriterion("page_number between", value1, value2, "pageNumber");
            return (Criteria) this;
        }

        public Criteria andPageNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("page_number not between", value1, value2, "pageNumber");
            return (Criteria) this;
        }

        public Criteria andSrcIsNull() {
            addCriterion("src is null");
            return (Criteria) this;
        }

        public Criteria andSrcIsNotNull() {
            addCriterion("src is not null");
            return (Criteria) this;
        }

        public Criteria andSrcEqualTo(String value) {
            addCriterion("src =", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotEqualTo(String value) {
            addCriterion("src <>", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcGreaterThan(String value) {
            addCriterion("src >", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcGreaterThanOrEqualTo(String value) {
            addCriterion("src >=", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcLessThan(String value) {
            addCriterion("src <", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcLessThanOrEqualTo(String value) {
            addCriterion("src <=", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcLike(String value) {
            addCriterion("src like", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotLike(String value) {
            addCriterion("src not like", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcIn(List<String> values) {
            addCriterion("src in", values, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotIn(List<String> values) {
            addCriterion("src not in", values, "src");
            return (Criteria) this;
        }

        public Criteria andSrcBetween(String value1, String value2) {
            addCriterion("src between", value1, value2, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotBetween(String value1, String value2) {
            addCriterion("src not between", value1, value2, "src");
            return (Criteria) this;
        }

        public Criteria andPricingIsNull() {
            addCriterion("pricing is null");
            return (Criteria) this;
        }

        public Criteria andPricingIsNotNull() {
            addCriterion("pricing is not null");
            return (Criteria) this;
        }

        public Criteria andPricingEqualTo(BigDecimal value) {
            addCriterion("pricing =", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingNotEqualTo(BigDecimal value) {
            addCriterion("pricing <>", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingGreaterThan(BigDecimal value) {
            addCriterion("pricing >", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pricing >=", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingLessThan(BigDecimal value) {
            addCriterion("pricing <", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pricing <=", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingIn(List<BigDecimal> values) {
            addCriterion("pricing in", values, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingNotIn(List<BigDecimal> values) {
            addCriterion("pricing not in", values, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pricing between", value1, value2, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pricing not between", value1, value2, "pricing");
            return (Criteria) this;
        }

        public Criteria andSellerNumberIsNull() {
            addCriterion("seller_number is null");
            return (Criteria) this;
        }

        public Criteria andSellerNumberIsNotNull() {
            addCriterion("seller_number is not null");
            return (Criteria) this;
        }

        public Criteria andSellerNumberEqualTo(Integer value) {
            addCriterion("seller_number =", value, "sellerNumber");
            return (Criteria) this;
        }

        public Criteria andSellerNumberNotEqualTo(Integer value) {
            addCriterion("seller_number <>", value, "sellerNumber");
            return (Criteria) this;
        }

        public Criteria andSellerNumberGreaterThan(Integer value) {
            addCriterion("seller_number >", value, "sellerNumber");
            return (Criteria) this;
        }

        public Criteria andSellerNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("seller_number >=", value, "sellerNumber");
            return (Criteria) this;
        }

        public Criteria andSellerNumberLessThan(Integer value) {
            addCriterion("seller_number <", value, "sellerNumber");
            return (Criteria) this;
        }

        public Criteria andSellerNumberLessThanOrEqualTo(Integer value) {
            addCriterion("seller_number <=", value, "sellerNumber");
            return (Criteria) this;
        }

        public Criteria andSellerNumberIn(List<Integer> values) {
            addCriterion("seller_number in", values, "sellerNumber");
            return (Criteria) this;
        }

        public Criteria andSellerNumberNotIn(List<Integer> values) {
            addCriterion("seller_number not in", values, "sellerNumber");
            return (Criteria) this;
        }

        public Criteria andSellerNumberBetween(Integer value1, Integer value2) {
            addCriterion("seller_number between", value1, value2, "sellerNumber");
            return (Criteria) this;
        }

        public Criteria andSellerNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("seller_number not between", value1, value2, "sellerNumber");
            return (Criteria) this;
        }

        public Criteria andBookType2IsNull() {
            addCriterion("book_type2 is null");
            return (Criteria) this;
        }

        public Criteria andBookType2IsNotNull() {
            addCriterion("book_type2 is not null");
            return (Criteria) this;
        }

        public Criteria andBookType2EqualTo(Integer value) {
            addCriterion("book_type2 =", value, "bookType2");
            return (Criteria) this;
        }

        public Criteria andBookType2NotEqualTo(Integer value) {
            addCriterion("book_type2 <>", value, "bookType2");
            return (Criteria) this;
        }

        public Criteria andBookType2GreaterThan(Integer value) {
            addCriterion("book_type2 >", value, "bookType2");
            return (Criteria) this;
        }

        public Criteria andBookType2GreaterThanOrEqualTo(Integer value) {
            addCriterion("book_type2 >=", value, "bookType2");
            return (Criteria) this;
        }

        public Criteria andBookType2LessThan(Integer value) {
            addCriterion("book_type2 <", value, "bookType2");
            return (Criteria) this;
        }

        public Criteria andBookType2LessThanOrEqualTo(Integer value) {
            addCriterion("book_type2 <=", value, "bookType2");
            return (Criteria) this;
        }

        public Criteria andBookType2In(List<Integer> values) {
            addCriterion("book_type2 in", values, "bookType2");
            return (Criteria) this;
        }

        public Criteria andBookType2NotIn(List<Integer> values) {
            addCriterion("book_type2 not in", values, "bookType2");
            return (Criteria) this;
        }

        public Criteria andBookType2Between(Integer value1, Integer value2) {
            addCriterion("book_type2 between", value1, value2, "bookType2");
            return (Criteria) this;
        }

        public Criteria andBookType2NotBetween(Integer value1, Integer value2) {
            addCriterion("book_type2 not between", value1, value2, "bookType2");
            return (Criteria) this;
        }

        public Criteria andBookType1IsNull() {
            addCriterion("book_type1 is null");
            return (Criteria) this;
        }

        public Criteria andBookType1IsNotNull() {
            addCriterion("book_type1 is not null");
            return (Criteria) this;
        }

        public Criteria andBookType1EqualTo(Integer value) {
            addCriterion("book_type1 =", value, "bookType1");
            return (Criteria) this;
        }

        public Criteria andBookType1NotEqualTo(Integer value) {
            addCriterion("book_type1 <>", value, "bookType1");
            return (Criteria) this;
        }

        public Criteria andBookType1GreaterThan(Integer value) {
            addCriterion("book_type1 >", value, "bookType1");
            return (Criteria) this;
        }

        public Criteria andBookType1GreaterThanOrEqualTo(Integer value) {
            addCriterion("book_type1 >=", value, "bookType1");
            return (Criteria) this;
        }

        public Criteria andBookType1LessThan(Integer value) {
            addCriterion("book_type1 <", value, "bookType1");
            return (Criteria) this;
        }

        public Criteria andBookType1LessThanOrEqualTo(Integer value) {
            addCriterion("book_type1 <=", value, "bookType1");
            return (Criteria) this;
        }

        public Criteria andBookType1In(List<Integer> values) {
            addCriterion("book_type1 in", values, "bookType1");
            return (Criteria) this;
        }

        public Criteria andBookType1NotIn(List<Integer> values) {
            addCriterion("book_type1 not in", values, "bookType1");
            return (Criteria) this;
        }

        public Criteria andBookType1Between(Integer value1, Integer value2) {
            addCriterion("book_type1 between", value1, value2, "bookType1");
            return (Criteria) this;
        }

        public Criteria andBookType1NotBetween(Integer value1, Integer value2) {
            addCriterion("book_type1 not between", value1, value2, "bookType1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2IsNull() {
            addCriterion("book_type_name2 is null");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2IsNotNull() {
            addCriterion("book_type_name2 is not null");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2EqualTo(String value) {
            addCriterion("book_type_name2 =", value, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2NotEqualTo(String value) {
            addCriterion("book_type_name2 <>", value, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2GreaterThan(String value) {
            addCriterion("book_type_name2 >", value, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2GreaterThanOrEqualTo(String value) {
            addCriterion("book_type_name2 >=", value, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2LessThan(String value) {
            addCriterion("book_type_name2 <", value, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2LessThanOrEqualTo(String value) {
            addCriterion("book_type_name2 <=", value, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2Like(String value) {
            addCriterion("book_type_name2 like", value, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2NotLike(String value) {
            addCriterion("book_type_name2 not like", value, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2In(List<String> values) {
            addCriterion("book_type_name2 in", values, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2NotIn(List<String> values) {
            addCriterion("book_type_name2 not in", values, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2Between(String value1, String value2) {
            addCriterion("book_type_name2 between", value1, value2, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName2NotBetween(String value1, String value2) {
            addCriterion("book_type_name2 not between", value1, value2, "bookTypeName2");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1IsNull() {
            addCriterion("book_type_name1 is null");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1IsNotNull() {
            addCriterion("book_type_name1 is not null");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1EqualTo(String value) {
            addCriterion("book_type_name1 =", value, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1NotEqualTo(String value) {
            addCriterion("book_type_name1 <>", value, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1GreaterThan(String value) {
            addCriterion("book_type_name1 >", value, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1GreaterThanOrEqualTo(String value) {
            addCriterion("book_type_name1 >=", value, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1LessThan(String value) {
            addCriterion("book_type_name1 <", value, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1LessThanOrEqualTo(String value) {
            addCriterion("book_type_name1 <=", value, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1Like(String value) {
            addCriterion("book_type_name1 like", value, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1NotLike(String value) {
            addCriterion("book_type_name1 not like", value, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1In(List<String> values) {
            addCriterion("book_type_name1 in", values, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1NotIn(List<String> values) {
            addCriterion("book_type_name1 not in", values, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1Between(String value1, String value2) {
            addCriterion("book_type_name1 between", value1, value2, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andBookTypeName1NotBetween(String value1, String value2) {
            addCriterion("book_type_name1 not between", value1, value2, "bookTypeName1");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1IsNull() {
            addCriterion("professional_type1 is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1IsNotNull() {
            addCriterion("professional_type1 is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1EqualTo(Integer value) {
            addCriterion("professional_type1 =", value, "professionalType1");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1NotEqualTo(Integer value) {
            addCriterion("professional_type1 <>", value, "professionalType1");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1GreaterThan(Integer value) {
            addCriterion("professional_type1 >", value, "professionalType1");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1GreaterThanOrEqualTo(Integer value) {
            addCriterion("professional_type1 >=", value, "professionalType1");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1LessThan(Integer value) {
            addCriterion("professional_type1 <", value, "professionalType1");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1LessThanOrEqualTo(Integer value) {
            addCriterion("professional_type1 <=", value, "professionalType1");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1In(List<Integer> values) {
            addCriterion("professional_type1 in", values, "professionalType1");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1NotIn(List<Integer> values) {
            addCriterion("professional_type1 not in", values, "professionalType1");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1Between(Integer value1, Integer value2) {
            addCriterion("professional_type1 between", value1, value2, "professionalType1");
            return (Criteria) this;
        }

        public Criteria andProfessionalType1NotBetween(Integer value1, Integer value2) {
            addCriterion("professional_type1 not between", value1, value2, "professionalType1");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2IsNull() {
            addCriterion("professional_type2 is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2IsNotNull() {
            addCriterion("professional_type2 is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2EqualTo(Integer value) {
            addCriterion("professional_type2 =", value, "professionalType2");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2NotEqualTo(Integer value) {
            addCriterion("professional_type2 <>", value, "professionalType2");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2GreaterThan(Integer value) {
            addCriterion("professional_type2 >", value, "professionalType2");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2GreaterThanOrEqualTo(Integer value) {
            addCriterion("professional_type2 >=", value, "professionalType2");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2LessThan(Integer value) {
            addCriterion("professional_type2 <", value, "professionalType2");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2LessThanOrEqualTo(Integer value) {
            addCriterion("professional_type2 <=", value, "professionalType2");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2In(List<Integer> values) {
            addCriterion("professional_type2 in", values, "professionalType2");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2NotIn(List<Integer> values) {
            addCriterion("professional_type2 not in", values, "professionalType2");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2Between(Integer value1, Integer value2) {
            addCriterion("professional_type2 between", value1, value2, "professionalType2");
            return (Criteria) this;
        }

        public Criteria andProfessionalType2NotBetween(Integer value1, Integer value2) {
            addCriterion("professional_type2 not between", value1, value2, "professionalType2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1IsNull() {
            addCriterion("professional_type_name1 is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1IsNotNull() {
            addCriterion("professional_type_name1 is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1EqualTo(String value) {
            addCriterion("professional_type_name1 =", value, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1NotEqualTo(String value) {
            addCriterion("professional_type_name1 <>", value, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1GreaterThan(String value) {
            addCriterion("professional_type_name1 >", value, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1GreaterThanOrEqualTo(String value) {
            addCriterion("professional_type_name1 >=", value, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1LessThan(String value) {
            addCriterion("professional_type_name1 <", value, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1LessThanOrEqualTo(String value) {
            addCriterion("professional_type_name1 <=", value, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1Like(String value) {
            addCriterion("professional_type_name1 like", value, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1NotLike(String value) {
            addCriterion("professional_type_name1 not like", value, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1In(List<String> values) {
            addCriterion("professional_type_name1 in", values, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1NotIn(List<String> values) {
            addCriterion("professional_type_name1 not in", values, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1Between(String value1, String value2) {
            addCriterion("professional_type_name1 between", value1, value2, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName1NotBetween(String value1, String value2) {
            addCriterion("professional_type_name1 not between", value1, value2, "professionalTypeName1");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2IsNull() {
            addCriterion("professional_type_name2 is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2IsNotNull() {
            addCriterion("professional_type_name2 is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2EqualTo(String value) {
            addCriterion("professional_type_name2 =", value, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2NotEqualTo(String value) {
            addCriterion("professional_type_name2 <>", value, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2GreaterThan(String value) {
            addCriterion("professional_type_name2 >", value, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2GreaterThanOrEqualTo(String value) {
            addCriterion("professional_type_name2 >=", value, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2LessThan(String value) {
            addCriterion("professional_type_name2 <", value, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2LessThanOrEqualTo(String value) {
            addCriterion("professional_type_name2 <=", value, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2Like(String value) {
            addCriterion("professional_type_name2 like", value, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2NotLike(String value) {
            addCriterion("professional_type_name2 not like", value, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2In(List<String> values) {
            addCriterion("professional_type_name2 in", values, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2NotIn(List<String> values) {
            addCriterion("professional_type_name2 not in", values, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2Between(String value1, String value2) {
            addCriterion("professional_type_name2 between", value1, value2, "professionalTypeName2");
            return (Criteria) this;
        }

        public Criteria andProfessionalTypeName2NotBetween(String value1, String value2) {
            addCriterion("professional_type_name2 not between", value1, value2, "professionalTypeName2");
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