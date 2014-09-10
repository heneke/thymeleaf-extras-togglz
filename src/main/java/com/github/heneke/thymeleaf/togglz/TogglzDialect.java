/*
 * =============================================================================
 *
 *   Copyright (c) 2014, Hendrik Heneke
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package com.github.heneke.thymeleaf.togglz;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;
import org.thymeleaf.processor.IProcessor;

import com.github.heneke.thymeleaf.togglz.processor.FeatureActiveAttrProcessor;
import com.github.heneke.thymeleaf.togglz.processor.FeatureInactiveAttrProcessor;

/**
 * Dialect for Thymeleaf that allows to show/hide DOM containers based on features state. In Order to use it, add an
 * instance of the dialect to your via {@link TemplateEngine}. The dialect uses the default prefix <code>togglz</code>.
 * 
 * @author Hendrik Heneke
 * @since 1.0.0
 * @see FeatureActiveAttrProcessor
 */
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
		final Set<IProcessor> processors = new LinkedHashSet<IProcessor>();
		processors.add(new FeatureActiveAttrProcessor());
		processors.add(new FeatureInactiveAttrProcessor());
		return processors;
	}

	@Override
	public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
		return Collections.emptyMap();
	}

}
