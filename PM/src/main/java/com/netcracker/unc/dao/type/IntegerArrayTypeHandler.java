package com.netcracker.unc.dao.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

@MappedJdbcTypes(value = JdbcType.ARRAY)
public class IntegerArrayTypeHandler extends BaseTypeHandler<ArrayList<Integer>> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, ArrayList<Integer> integers, JdbcType jdbcType) throws SQLException {
        Array array = preparedStatement.getConnection().createArrayOf("integer", integers.toArray());
        preparedStatement.setArray(i, array);
    }

    @Override
    public ArrayList<Integer> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return toArrayList(resultSet.getArray(s));
    }

    @Override
    public ArrayList<Integer> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return toArrayList(resultSet.getArray(i));
    }

    @Override
    public ArrayList<Integer> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return toArrayList(callableStatement.getArray(i));
    }

    private ArrayList<Integer> toArrayList(Array pgArray) throws SQLException {
        if (pgArray == null) return new ArrayList<>();
        Integer[] integers = (Integer[]) pgArray.getArray();
        return new ArrayList<>(Arrays.asList(integers));
    }
}
