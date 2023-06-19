package com.turing.wallet.model;

import java.util.ArrayList;
import java.util.List;

public class WalletCurrencyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WalletCurrencyExample() {
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

        public Criteria andCurrencyCodeIsNull() {
            addCriterion("currency_code is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNotNull() {
            addCriterion("currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeEqualTo(String value) {
            addCriterion("currency_code =", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotEqualTo(String value) {
            addCriterion("currency_code <>", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThan(String value) {
            addCriterion("currency_code >", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("currency_code >=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThan(String value) {
            addCriterion("currency_code <", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("currency_code <=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLike(String value) {
            addCriterion("currency_code like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotLike(String value) {
            addCriterion("currency_code not like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIn(List<String> values) {
            addCriterion("currency_code in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotIn(List<String> values) {
            addCriterion("currency_code not in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeBetween(String value1, String value2) {
            addCriterion("currency_code between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("currency_code not between", value1, value2, "currencyCode");
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

        public Criteria andChainIdIsNull() {
            addCriterion("chain_id is null");
            return (Criteria) this;
        }

        public Criteria andChainIdIsNotNull() {
            addCriterion("chain_id is not null");
            return (Criteria) this;
        }

        public Criteria andChainIdEqualTo(Long value) {
            addCriterion("chain_id =", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotEqualTo(Long value) {
            addCriterion("chain_id <>", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdGreaterThan(Long value) {
            addCriterion("chain_id >", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdGreaterThanOrEqualTo(Long value) {
            addCriterion("chain_id >=", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLessThan(Long value) {
            addCriterion("chain_id <", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLessThanOrEqualTo(Long value) {
            addCriterion("chain_id <=", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdIn(List<Long> values) {
            addCriterion("chain_id in", values, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotIn(List<Long> values) {
            addCriterion("chain_id not in", values, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdBetween(Long value1, Long value2) {
            addCriterion("chain_id between", value1, value2, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotBetween(Long value1, Long value2) {
            addCriterion("chain_id not between", value1, value2, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainNameIsNull() {
            addCriterion("chain_name is null");
            return (Criteria) this;
        }

        public Criteria andChainNameIsNotNull() {
            addCriterion("chain_name is not null");
            return (Criteria) this;
        }

        public Criteria andChainNameEqualTo(String value) {
            addCriterion("chain_name =", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotEqualTo(String value) {
            addCriterion("chain_name <>", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameGreaterThan(String value) {
            addCriterion("chain_name >", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameGreaterThanOrEqualTo(String value) {
            addCriterion("chain_name >=", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameLessThan(String value) {
            addCriterion("chain_name <", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameLessThanOrEqualTo(String value) {
            addCriterion("chain_name <=", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameLike(String value) {
            addCriterion("chain_name like", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotLike(String value) {
            addCriterion("chain_name not like", value, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameIn(List<String> values) {
            addCriterion("chain_name in", values, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotIn(List<String> values) {
            addCriterion("chain_name not in", values, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameBetween(String value1, String value2) {
            addCriterion("chain_name between", value1, value2, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainNameNotBetween(String value1, String value2) {
            addCriterion("chain_name not between", value1, value2, "chainName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameIsNull() {
            addCriterion("chain_show_name is null");
            return (Criteria) this;
        }

        public Criteria andChainShowNameIsNotNull() {
            addCriterion("chain_show_name is not null");
            return (Criteria) this;
        }

        public Criteria andChainShowNameEqualTo(String value) {
            addCriterion("chain_show_name =", value, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameNotEqualTo(String value) {
            addCriterion("chain_show_name <>", value, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameGreaterThan(String value) {
            addCriterion("chain_show_name >", value, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameGreaterThanOrEqualTo(String value) {
            addCriterion("chain_show_name >=", value, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameLessThan(String value) {
            addCriterion("chain_show_name <", value, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameLessThanOrEqualTo(String value) {
            addCriterion("chain_show_name <=", value, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameLike(String value) {
            addCriterion("chain_show_name like", value, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameNotLike(String value) {
            addCriterion("chain_show_name not like", value, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameIn(List<String> values) {
            addCriterion("chain_show_name in", values, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameNotIn(List<String> values) {
            addCriterion("chain_show_name not in", values, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameBetween(String value1, String value2) {
            addCriterion("chain_show_name between", value1, value2, "chainShowName");
            return (Criteria) this;
        }

        public Criteria andChainShowNameNotBetween(String value1, String value2) {
            addCriterion("chain_show_name not between", value1, value2, "chainShowName");
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

        public Criteria andWalletCurrencyNameIsNull() {
            addCriterion("wallet_currency_name is null");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameIsNotNull() {
            addCriterion("wallet_currency_name is not null");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameEqualTo(String value) {
            addCriterion("wallet_currency_name =", value, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameNotEqualTo(String value) {
            addCriterion("wallet_currency_name <>", value, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameGreaterThan(String value) {
            addCriterion("wallet_currency_name >", value, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_currency_name >=", value, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameLessThan(String value) {
            addCriterion("wallet_currency_name <", value, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameLessThanOrEqualTo(String value) {
            addCriterion("wallet_currency_name <=", value, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameLike(String value) {
            addCriterion("wallet_currency_name like", value, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameNotLike(String value) {
            addCriterion("wallet_currency_name not like", value, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameIn(List<String> values) {
            addCriterion("wallet_currency_name in", values, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameNotIn(List<String> values) {
            addCriterion("wallet_currency_name not in", values, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameBetween(String value1, String value2) {
            addCriterion("wallet_currency_name between", value1, value2, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andWalletCurrencyNameNotBetween(String value1, String value2) {
            addCriterion("wallet_currency_name not between", value1, value2, "walletCurrencyName");
            return (Criteria) this;
        }

        public Criteria andContractAddressIsNull() {
            addCriterion("contract_address is null");
            return (Criteria) this;
        }

        public Criteria andContractAddressIsNotNull() {
            addCriterion("contract_address is not null");
            return (Criteria) this;
        }

        public Criteria andContractAddressEqualTo(String value) {
            addCriterion("contract_address =", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotEqualTo(String value) {
            addCriterion("contract_address <>", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressGreaterThan(String value) {
            addCriterion("contract_address >", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressGreaterThanOrEqualTo(String value) {
            addCriterion("contract_address >=", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressLessThan(String value) {
            addCriterion("contract_address <", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressLessThanOrEqualTo(String value) {
            addCriterion("contract_address <=", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressLike(String value) {
            addCriterion("contract_address like", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotLike(String value) {
            addCriterion("contract_address not like", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressIn(List<String> values) {
            addCriterion("contract_address in", values, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotIn(List<String> values) {
            addCriterion("contract_address not in", values, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressBetween(String value1, String value2) {
            addCriterion("contract_address between", value1, value2, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotBetween(String value1, String value2) {
            addCriterion("contract_address not between", value1, value2, "contractAddress");
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

        public Criteria andAddressRegularIsNull() {
            addCriterion("address_regular is null");
            return (Criteria) this;
        }

        public Criteria andAddressRegularIsNotNull() {
            addCriterion("address_regular is not null");
            return (Criteria) this;
        }

        public Criteria andAddressRegularEqualTo(String value) {
            addCriterion("address_regular =", value, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularNotEqualTo(String value) {
            addCriterion("address_regular <>", value, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularGreaterThan(String value) {
            addCriterion("address_regular >", value, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularGreaterThanOrEqualTo(String value) {
            addCriterion("address_regular >=", value, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularLessThan(String value) {
            addCriterion("address_regular <", value, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularLessThanOrEqualTo(String value) {
            addCriterion("address_regular <=", value, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularLike(String value) {
            addCriterion("address_regular like", value, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularNotLike(String value) {
            addCriterion("address_regular not like", value, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularIn(List<String> values) {
            addCriterion("address_regular in", values, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularNotIn(List<String> values) {
            addCriterion("address_regular not in", values, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularBetween(String value1, String value2) {
            addCriterion("address_regular between", value1, value2, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andAddressRegularNotBetween(String value1, String value2) {
            addCriterion("address_regular not between", value1, value2, "addressRegular");
            return (Criteria) this;
        }

        public Criteria andDefaultChainIsNull() {
            addCriterion("default_chain is null");
            return (Criteria) this;
        }

        public Criteria andDefaultChainIsNotNull() {
            addCriterion("default_chain is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultChainEqualTo(Byte value) {
            addCriterion("default_chain =", value, "defaultChain");
            return (Criteria) this;
        }

        public Criteria andDefaultChainNotEqualTo(Byte value) {
            addCriterion("default_chain <>", value, "defaultChain");
            return (Criteria) this;
        }

        public Criteria andDefaultChainGreaterThan(Byte value) {
            addCriterion("default_chain >", value, "defaultChain");
            return (Criteria) this;
        }

        public Criteria andDefaultChainGreaterThanOrEqualTo(Byte value) {
            addCriterion("default_chain >=", value, "defaultChain");
            return (Criteria) this;
        }

        public Criteria andDefaultChainLessThan(Byte value) {
            addCriterion("default_chain <", value, "defaultChain");
            return (Criteria) this;
        }

        public Criteria andDefaultChainLessThanOrEqualTo(Byte value) {
            addCriterion("default_chain <=", value, "defaultChain");
            return (Criteria) this;
        }

        public Criteria andDefaultChainIn(List<Byte> values) {
            addCriterion("default_chain in", values, "defaultChain");
            return (Criteria) this;
        }

        public Criteria andDefaultChainNotIn(List<Byte> values) {
            addCriterion("default_chain not in", values, "defaultChain");
            return (Criteria) this;
        }

        public Criteria andDefaultChainBetween(Byte value1, Byte value2) {
            addCriterion("default_chain between", value1, value2, "defaultChain");
            return (Criteria) this;
        }

        public Criteria andDefaultChainNotBetween(Byte value1, Byte value2) {
            addCriterion("default_chain not between", value1, value2, "defaultChain");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeIsNull() {
            addCriterion("currency_type is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeIsNotNull() {
            addCriterion("currency_type is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeEqualTo(Integer value) {
            addCriterion("currency_type =", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeNotEqualTo(Integer value) {
            addCriterion("currency_type <>", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeGreaterThan(Integer value) {
            addCriterion("currency_type >", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("currency_type >=", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeLessThan(Integer value) {
            addCriterion("currency_type <", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("currency_type <=", value, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeIn(List<Integer> values) {
            addCriterion("currency_type in", values, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeNotIn(List<Integer> values) {
            addCriterion("currency_type not in", values, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeBetween(Integer value1, Integer value2) {
            addCriterion("currency_type between", value1, value2, "currencyType");
            return (Criteria) this;
        }

        public Criteria andCurrencyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("currency_type not between", value1, value2, "currencyType");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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