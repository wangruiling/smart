package org.smart.h2;

import org.apache.commons.dbutils.QueryRunner;

/**
 * @author: wangrl
 * @Date: 2016-03-06 22:30
 */
public class DbUtils {
    private static final QueryRunner queryReturn = new QueryRunner();

    public static void main(String[] args) {
        System.out.println(queryReturn);
    }
}
