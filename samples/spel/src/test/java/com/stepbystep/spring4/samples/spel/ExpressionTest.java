/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.beans
 * @file ExpressionTest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-17
 */
package com.stepbystep.spring4.samples.spel;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * <code>ExpressionTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-17
 */
public class ExpressionTest {
    private static final Logger LOG = LoggerFactory
            .getLogger(ExpressionTest.class);
    @Test
    public void testExpression(){
        //解析器
        ExpressionParser parser = new SpelExpressionParser();
        //解析器解析出字符串表达式
        Expression expression = parser.parseExpression("('Hello' + ' Spel').concat(#end)");
        //上下文环境
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("end","!");
        //获取表达式的值
        Object value = expression.getValue(context);
        LOG.info("value = {}",value);
        Assert.assertEquals("Hello Spel!", value);
    }
}
