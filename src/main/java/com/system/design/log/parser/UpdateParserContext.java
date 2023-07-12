package com.system.design.log.parser;

import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class UpdateParserContext implements ParserContext {

    @Override
    public boolean isTemplate() {
        return true;
    }

    @Override
    public String getExpressionPrefix() {
        return "}";
    }

    @Override
    public String getExpressionSuffix() {
        return "%{";
    }

}
