/*
 * =============================================================================
 *
 *   Copyright (c) 2013, Hendrik Heneke
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
