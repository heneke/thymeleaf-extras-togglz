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
package org.thymeleaf.extras.togglz.dialect.processor;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractConditionalVisibilityAttrProcessor;
import org.thymeleaf.standard.processor.attr.StandardIfAttrProcessor;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.LazyResolvingFeatureManager;
import org.togglz.core.util.NamedFeature;

public class FeatureActiveAttrProcessor extends AbstractConditionalVisibilityAttrProcessor {

	public static final String ATTR_NAME = "active";
	public static final int ATTR_PRECEDENCE = StandardIfAttrProcessor.ATTR_PRECEDENCE;

	private final FeatureManager featureManager;

	public FeatureActiveAttrProcessor() {
		super(ATTR_NAME);
		this.featureManager = new LazyResolvingFeatureManager();
	}

	@Override
	protected boolean isVisible(Arguments arguments, Element element, String attributeName) {
		String attributeValue = element.getAttributeValue(attributeName);
		if (attributeValue == null || attributeValue.trim().length() == 0) {
			return false;
		}
		return isFeatureActive(attributeValue.trim());
	}

	@Override
	public int getPrecedence() {
		return ATTR_PRECEDENCE;
	}

	private boolean isFeatureActive(String name) {
		return featureManager.isActive(new NamedFeature(name));
	}

}
