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
package com.github.heneke.thymeleaf.togglz.processor;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractConditionalVisibilityAttrProcessor;
import org.thymeleaf.standard.expression.StandardExpressionProcessor;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.LazyResolvingFeatureManager;
import org.togglz.core.util.NamedFeature;

@SuppressWarnings("deprecation")
public abstract class AbstractFeatureAttrProcessor extends AbstractConditionalVisibilityAttrProcessor {

	private final FeatureManager featureManager;

	protected AbstractFeatureAttrProcessor(final String attributeName) {
		super(attributeName);
		this.featureManager = new LazyResolvingFeatureManager();
	}

	/**
	 * Determines the feature state.
	 * 
	 * @param arguments the arguments
	 * @param element the element
	 * @param attributeName the attribute name
	 * @param defaultState
	 *            default state to return if the attribute value is <code>NULL</code> or empty
	 * @return the feature state
	 */
	protected boolean determineFeatureState(Arguments arguments, Element element, String attributeName,
			boolean defaultState) {
		final String attributeValue = element.getAttributeValue(attributeName);
		if (attributeValue == null || attributeValue.trim().length() == 0) {
			return defaultState;
		}

		final Object value = processExpression(arguments, attributeValue);
		if (value != null) {
			return isFeatureActive(value.toString());
		}
		else {
			return defaultState;
		}
	}

	private boolean isFeatureActive(String name) {
		return featureManager.isActive(new NamedFeature(name));
	}

	private Object processExpression(Arguments arguments, String attributeValue) {
		return StandardExpressionProcessor.processExpression(arguments, attributeValue);
	}

}