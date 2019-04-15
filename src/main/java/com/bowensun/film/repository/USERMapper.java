package com.bowensun.film.repository;

import static com.bowensun.film.domain.USERDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.bowensun.film.domain.USER;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface USERMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<USER> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("USERResult")
    USER selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="USERResult", value = {
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR)
    })
    List<USER> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer uid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, USER)
                .where(uid, isEqualTo(uid_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(USER record) {
        return insert(SqlBuilder.insert(record)
                .into(USER)
                .map(uid).toProperty("uid")
                .map(name).toProperty("name")
                .map(password).toProperty("password")
                .map(salt).toProperty("salt")
                .map(state).toProperty("state")
                .map(username).toProperty("username")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(USER record) {
        return insert(SqlBuilder.insert(record)
                .into(USER)
                .map(uid).toPropertyWhenPresent("uid", record::getUid)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(password).toPropertyWhenPresent("password", record::getPassword)
                .map(salt).toPropertyWhenPresent("salt", record::getSalt)
                .map(state).toPropertyWhenPresent("state", record::getState)
                .map(username).toPropertyWhenPresent("username", record::getUsername)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<USER>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, uid, name, password, salt, state, username)
                .from(USER);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<USER>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, uid, name, password, salt, state, username)
                .from(USER);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default USER selectByPrimaryKey(Integer uid_) {
        return SelectDSL.selectWithMapper(this::selectOne, uid, name, password, salt, state, username)
                .from(USER)
                .where(uid, isEqualTo(uid_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(USER record) {
        return UpdateDSL.updateWithMapper(this::update, USER)
                .set(name).equalTo(record::getName)
                .set(password).equalTo(record::getPassword)
                .set(salt).equalTo(record::getSalt)
                .set(state).equalTo(record::getState)
                .set(username).equalTo(record::getUsername)
                .where(uid, isEqualTo(record::getUid))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(USER record) {
        return UpdateDSL.updateWithMapper(this::update, USER)
                .set(name).equalToWhenPresent(record::getName)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(salt).equalToWhenPresent(record::getSalt)
                .set(state).equalToWhenPresent(record::getState)
                .set(username).equalToWhenPresent(record::getUsername)
                .where(uid, isEqualTo(record::getUid))
                .build()
                .execute();
    }
}