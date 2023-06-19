package com.turing.wallet.model;

import java.util.ArrayList;
import java.util.List;

public class WalletChainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WalletChainExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTagTypeIsNull() {
            addCriterion("tag_type is null");
            return (Criteria) this;
        }

        public Criteria andTagTypeIsNotNull() {
            addCriterion("tag_type is not null");
            return (Criteria) this;
        }

        public Criteria andTagTypeEqualTo(Integer value) {
            addCriterion("tag_type =", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeNotEqualTo(Integer value) {
            addCriterion("tag_type <>", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeGreaterThan(Integer value) {
            addCriterion("tag_type >", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_type >=", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeLessThan(Integer value) {
            addCriterion("tag_type <", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeLessThanOrEqualTo(Integer value) {
            addCriterion("tag_type <=", value, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeIn(List<Integer> values) {
            addCriterion("tag_type in", values, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeNotIn(List<Integer> values) {
            addCriterion("tag_type not in", values, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeBetween(Integer value1, Integer value2) {
            addCriterion("tag_type between", value1, value2, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_type not between", value1, value2, "tagType");
            return (Criteria) this;
        }

        public Criteria andTagAddressIsNull() {
            addCriterion("tag_address is null");
            return (Criteria) this;
        }

        public Criteria andTagAddressIsNotNull() {
            addCriterion("tag_address is not null");
            return (Criteria) this;
        }

        public Criteria andTagAddressEqualTo(String value) {
            addCriterion("tag_address =", value, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressNotEqualTo(String value) {
            addCriterion("tag_address <>", value, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressGreaterThan(String value) {
            addCriterion("tag_address >", value, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressGreaterThanOrEqualTo(String value) {
            addCriterion("tag_address >=", value, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressLessThan(String value) {
            addCriterion("tag_address <", value, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressLessThanOrEqualTo(String value) {
            addCriterion("tag_address <=", value, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressLike(String value) {
            addCriterion("tag_address like", value, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressNotLike(String value) {
            addCriterion("tag_address not like", value, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressIn(List<String> values) {
            addCriterion("tag_address in", values, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressNotIn(List<String> values) {
            addCriterion("tag_address not in", values, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressBetween(String value1, String value2) {
            addCriterion("tag_address between", value1, value2, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andTagAddressNotBetween(String value1, String value2) {
            addCriterion("tag_address not between", value1, value2, "tagAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressIsNull() {
            addCriterion("icon_address is null");
            return (Criteria) this;
        }

        public Criteria andIconAddressIsNotNull() {
            addCriterion("icon_address is not null");
            return (Criteria) this;
        }

        public Criteria andIconAddressEqualTo(String value) {
            addCriterion("icon_address =", value, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressNotEqualTo(String value) {
            addCriterion("icon_address <>", value, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressGreaterThan(String value) {
            addCriterion("icon_address >", value, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressGreaterThanOrEqualTo(String value) {
            addCriterion("icon_address >=", value, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressLessThan(String value) {
            addCriterion("icon_address <", value, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressLessThanOrEqualTo(String value) {
            addCriterion("icon_address <=", value, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressLike(String value) {
            addCriterion("icon_address like", value, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressNotLike(String value) {
            addCriterion("icon_address not like", value, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressIn(List<String> values) {
            addCriterion("icon_address in", values, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressNotIn(List<String> values) {
            addCriterion("icon_address not in", values, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressBetween(String value1, String value2) {
            addCriterion("icon_address between", value1, value2, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andIconAddressNotBetween(String value1, String value2) {
            addCriterion("icon_address not between", value1, value2, "iconAddress");
            return (Criteria) this;
        }

        public Criteria andChainProtocolIsNull() {
            addCriterion("chain_protocol is null");
            return (Criteria) this;
        }

        public Criteria andChainProtocolIsNotNull() {
            addCriterion("chain_protocol is not null");
            return (Criteria) this;
        }

        public Criteria andChainProtocolEqualTo(String value) {
            addCriterion("chain_protocol =", value, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolNotEqualTo(String value) {
            addCriterion("chain_protocol <>", value, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolGreaterThan(String value) {
            addCriterion("chain_protocol >", value, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolGreaterThanOrEqualTo(String value) {
            addCriterion("chain_protocol >=", value, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolLessThan(String value) {
            addCriterion("chain_protocol <", value, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolLessThanOrEqualTo(String value) {
            addCriterion("chain_protocol <=", value, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolLike(String value) {
            addCriterion("chain_protocol like", value, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolNotLike(String value) {
            addCriterion("chain_protocol not like", value, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolIn(List<String> values) {
            addCriterion("chain_protocol in", values, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolNotIn(List<String> values) {
            addCriterion("chain_protocol not in", values, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolBetween(String value1, String value2) {
            addCriterion("chain_protocol between", value1, value2, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainProtocolNotBetween(String value1, String value2) {
            addCriterion("chain_protocol not between", value1, value2, "chainProtocol");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressIsNull() {
            addCriterion("chain_browser_address is null");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressIsNotNull() {
            addCriterion("chain_browser_address is not null");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressEqualTo(String value) {
            addCriterion("chain_browser_address =", value, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressNotEqualTo(String value) {
            addCriterion("chain_browser_address <>", value, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressGreaterThan(String value) {
            addCriterion("chain_browser_address >", value, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("chain_browser_address >=", value, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressLessThan(String value) {
            addCriterion("chain_browser_address <", value, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressLessThanOrEqualTo(String value) {
            addCriterion("chain_browser_address <=", value, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressLike(String value) {
            addCriterion("chain_browser_address like", value, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressNotLike(String value) {
            addCriterion("chain_browser_address not like", value, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressIn(List<String> values) {
            addCriterion("chain_browser_address in", values, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressNotIn(List<String> values) {
            addCriterion("chain_browser_address not in", values, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressBetween(String value1, String value2) {
            addCriterion("chain_browser_address between", value1, value2, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserAddressNotBetween(String value1, String value2) {
            addCriterion("chain_browser_address not between", value1, value2, "chainBrowserAddress");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxIsNull() {
            addCriterion("chain_browser_tx is null");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxIsNotNull() {
            addCriterion("chain_browser_tx is not null");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxEqualTo(String value) {
            addCriterion("chain_browser_tx =", value, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxNotEqualTo(String value) {
            addCriterion("chain_browser_tx <>", value, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxGreaterThan(String value) {
            addCriterion("chain_browser_tx >", value, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxGreaterThanOrEqualTo(String value) {
            addCriterion("chain_browser_tx >=", value, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxLessThan(String value) {
            addCriterion("chain_browser_tx <", value, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxLessThanOrEqualTo(String value) {
            addCriterion("chain_browser_tx <=", value, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxLike(String value) {
            addCriterion("chain_browser_tx like", value, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxNotLike(String value) {
            addCriterion("chain_browser_tx not like", value, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxIn(List<String> values) {
            addCriterion("chain_browser_tx in", values, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxNotIn(List<String> values) {
            addCriterion("chain_browser_tx not in", values, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxBetween(String value1, String value2) {
            addCriterion("chain_browser_tx between", value1, value2, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andChainBrowserTxNotBetween(String value1, String value2) {
            addCriterion("chain_browser_tx not between", value1, value2, "chainBrowserTx");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRegExIsNull() {
            addCriterion("reg_ex is null");
            return (Criteria) this;
        }

        public Criteria andRegExIsNotNull() {
            addCriterion("reg_ex is not null");
            return (Criteria) this;
        }

        public Criteria andRegExEqualTo(String value) {
            addCriterion("reg_ex =", value, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExNotEqualTo(String value) {
            addCriterion("reg_ex <>", value, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExGreaterThan(String value) {
            addCriterion("reg_ex >", value, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExGreaterThanOrEqualTo(String value) {
            addCriterion("reg_ex >=", value, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExLessThan(String value) {
            addCriterion("reg_ex <", value, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExLessThanOrEqualTo(String value) {
            addCriterion("reg_ex <=", value, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExLike(String value) {
            addCriterion("reg_ex like", value, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExNotLike(String value) {
            addCriterion("reg_ex not like", value, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExIn(List<String> values) {
            addCriterion("reg_ex in", values, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExNotIn(List<String> values) {
            addCriterion("reg_ex not in", values, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExBetween(String value1, String value2) {
            addCriterion("reg_ex between", value1, value2, "regEx");
            return (Criteria) this;
        }

        public Criteria andRegExNotBetween(String value1, String value2) {
            addCriterion("reg_ex not between", value1, value2, "regEx");
            return (Criteria) this;
        }

        public Criteria andShowNameIsNull() {
            addCriterion("show_name is null");
            return (Criteria) this;
        }

        public Criteria andShowNameIsNotNull() {
            addCriterion("show_name is not null");
            return (Criteria) this;
        }

        public Criteria andShowNameEqualTo(String value) {
            addCriterion("show_name =", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotEqualTo(String value) {
            addCriterion("show_name <>", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameGreaterThan(String value) {
            addCriterion("show_name >", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameGreaterThanOrEqualTo(String value) {
            addCriterion("show_name >=", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLessThan(String value) {
            addCriterion("show_name <", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLessThanOrEqualTo(String value) {
            addCriterion("show_name <=", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLike(String value) {
            addCriterion("show_name like", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotLike(String value) {
            addCriterion("show_name not like", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameIn(List<String> values) {
            addCriterion("show_name in", values, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotIn(List<String> values) {
            addCriterion("show_name not in", values, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameBetween(String value1, String value2) {
            addCriterion("show_name between", value1, value2, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotBetween(String value1, String value2) {
            addCriterion("show_name not between", value1, value2, "showName");
            return (Criteria) this;
        }

        public Criteria andDefaultShowIsNull() {
            addCriterion("default_show is null");
            return (Criteria) this;
        }

        public Criteria andDefaultShowIsNotNull() {
            addCriterion("default_show is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultShowEqualTo(Integer value) {
            addCriterion("default_show =", value, "defaultShow");
            return (Criteria) this;
        }

        public Criteria andDefaultShowNotEqualTo(Integer value) {
            addCriterion("default_show <>", value, "defaultShow");
            return (Criteria) this;
        }

        public Criteria andDefaultShowGreaterThan(Integer value) {
            addCriterion("default_show >", value, "defaultShow");
            return (Criteria) this;
        }

        public Criteria andDefaultShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("default_show >=", value, "defaultShow");
            return (Criteria) this;
        }

        public Criteria andDefaultShowLessThan(Integer value) {
            addCriterion("default_show <", value, "defaultShow");
            return (Criteria) this;
        }

        public Criteria andDefaultShowLessThanOrEqualTo(Integer value) {
            addCriterion("default_show <=", value, "defaultShow");
            return (Criteria) this;
        }

        public Criteria andDefaultShowIn(List<Integer> values) {
            addCriterion("default_show in", values, "defaultShow");
            return (Criteria) this;
        }

        public Criteria andDefaultShowNotIn(List<Integer> values) {
            addCriterion("default_show not in", values, "defaultShow");
            return (Criteria) this;
        }

        public Criteria andDefaultShowBetween(Integer value1, Integer value2) {
            addCriterion("default_show between", value1, value2, "defaultShow");
            return (Criteria) this;
        }

        public Criteria andDefaultShowNotBetween(Integer value1, Integer value2) {
            addCriterion("default_show not between", value1, value2, "defaultShow");
            return (Criteria) this;
        }

        public Criteria andEvmStateIsNull() {
            addCriterion("evm_state is null");
            return (Criteria) this;
        }

        public Criteria andEvmStateIsNotNull() {
            addCriterion("evm_state is not null");
            return (Criteria) this;
        }

        public Criteria andEvmStateEqualTo(Boolean value) {
            addCriterion("evm_state =", value, "evmState");
            return (Criteria) this;
        }

        public Criteria andEvmStateNotEqualTo(Boolean value) {
            addCriterion("evm_state <>", value, "evmState");
            return (Criteria) this;
        }

        public Criteria andEvmStateGreaterThan(Boolean value) {
            addCriterion("evm_state >", value, "evmState");
            return (Criteria) this;
        }

        public Criteria andEvmStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("evm_state >=", value, "evmState");
            return (Criteria) this;
        }

        public Criteria andEvmStateLessThan(Boolean value) {
            addCriterion("evm_state <", value, "evmState");
            return (Criteria) this;
        }

        public Criteria andEvmStateLessThanOrEqualTo(Boolean value) {
            addCriterion("evm_state <=", value, "evmState");
            return (Criteria) this;
        }

        public Criteria andEvmStateIn(List<Boolean> values) {
            addCriterion("evm_state in", values, "evmState");
            return (Criteria) this;
        }

        public Criteria andEvmStateNotIn(List<Boolean> values) {
            addCriterion("evm_state not in", values, "evmState");
            return (Criteria) this;
        }

        public Criteria andEvmStateBetween(Boolean value1, Boolean value2) {
            addCriterion("evm_state between", value1, value2, "evmState");
            return (Criteria) this;
        }

        public Criteria andEvmStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("evm_state not between", value1, value2, "evmState");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Long value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Long value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Long value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Long value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Long value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Long value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Long> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Long> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Long value1, Long value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Long value1, Long value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Long value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Long value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Long value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Long value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Long value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Long value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Long> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Long> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Long value1, Long value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Long value1, Long value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
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