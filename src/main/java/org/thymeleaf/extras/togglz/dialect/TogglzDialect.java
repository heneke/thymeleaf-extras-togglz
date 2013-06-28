package org.thymeleaf.extras.togglz.dialect;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;
import org.thymeleaf.extras.togglz.dialect.processor.FeatureActiveAttrProcessor;
import org.thymeleaf.processor.IProcessor;

public class TogglzDialect extends AbstractDialect implements IExpressionEnhancingDialect {

	public static final String DEFAULT_PREFIX = "togglz";

	public TogglzDialect() {
		super();
	}

	@Override
	public String getPrefix() {
		return DEFAULT_PREFIX;
	}

	@Override
	public boolean isLenient() {
		return false;
	}

	@Override
	public Set<IProcessor> getProcessors() {
		final Set<IProcessor> processors = new LinkedHashSet<>();
		processors.add(new FeatureActiveAttrProcessor());
		return processors;
	}

	@Override
	public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
		return Collections.emptyMap();
	}

}
