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
import org.thymeleaf.standard.processor.attr.StandardIfAttrProcessor;

import com.github.heneke.thymeleaf.togglz.TogglzDialect;

/**
 * Processor for the <code>active</code> attribute in {@link TogglzDialect}. It shows or hides the given DOM container
 * based on feature state: <br>
 * <br>
 * 
 * <pre>
 * &lt;span togglz:active="FEATURE"&gt;
 *    Only visible when FEATURE is active.
 * &lt;/span&gt;
 * </pre>
 * 
 * Features may also be specified dynamically by using expressions:<br>
 * <br>
 * 
 * <pre>
 * &lt;span togglz:active="${feature}"&gt;
 *    Only visible when feature resolved by evaluating ${feature} is active.
 * &lt;/span&gt;
 * </pre>
 * 
 * When using Thymeleaf 2.0.x, literal feature names have to be quoted with single quotes. Thymeleaf from 2.1 onward
 * supports unquoted string literals.
 * 
 * @author Hendrik Heneke
 * @since 1.0.0
 */
public class FeatureActiveAttrProcessor extends AbstractFeatureAttrProcessor {

	public static final String ATTR_NAME = "active";
	public static final int ATTR_PRECEDENCE = StandardIfAttrProcessor.ATTR_PRECEDENCE;

	public FeatureActiveAttrProcessor() {
		super(ATTR_NAME);
	}

	@Override
	protected boolean isVisible(Arguments arguments, Element element, String attributeName) {
		return determineFeatureState(arguments, element, attributeName, false);
	}

	@Override
	public int getPrecedence() {
		return ATTR_PRECEDENCE;
	}

}
